package edu.usm.sosw.sword;

import java.security.Principal;
import java.util.EnumSet;
import java.util.Optional;

import javax.annotation.Priority;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.ws.rs.NameBinding;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import edu.usm.sosw.sword.db.*;
import edu.usm.sosw.sword.resources.*;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.keys.HmacKey;
import org.skife.jdbi.v2.DBI;

import com.github.toastshaman.dropwizard.auth.jwt.JwtAuthFilter;

import edu.usm.sosw.sword.api.MyUser;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SwordApplication extends Application<SwordConfiguration> {

	public static void main(final String[] args) throws Exception {
		new SwordApplication().run(args);
	}

	@Override
	public String getName() {
		return "SWORD";
	}

	@Override
	public void initialize(final Bootstrap<SwordConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final SwordConfiguration configuration, final Environment environment)
			throws UnsupportedEncodingException {

		// Generate JWT secret key, Initialize JDBI interface, and register Database
		// Access Objects
		final byte[] key = configuration.getJwtTokenSecret();
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
		
		// Initialize all DAOs for use with jersey.
		final UserDAO dao = jdbi.onDemand(UserDAO.class);
		final YouthDAO YouthDAO = jdbi.onDemand(YouthDAO.class);
		final CountyDAO CountyDAO = jdbi.onDemand(CountyDAO.class);
		final CounselorDAO CounselorDAO = jdbi.onDemand(CounselorDAO.class);
		final CourtRelatedDAO CourtRelatedDAO = jdbi.onDemand(CourtRelatedDAO.class);
    	final RunningRecordDAO RunningRecordDAO = jdbi.onDemand(RunningRecordDAO.class);
        final CustodyDAO CustodyDAO = jdbi.onDemand(CustodyDAO.class);
        final CaseNoteDAO CaseNoteDAO = jdbi.onDemand(CaseNoteDAO.class);
        final ContRiskDAO ContRiskDAO = jdbi.onDemand(ContRiskDAO.class);
        final ContactDAO ContactDAO = jdbi.onDemand(ContactDAO.class);
        final ChargeDAO ChargeDAO = jdbi.onDemand(ChargeDAO.class);
        final CaseDAO CaseDAO = jdbi.onDemand(CaseDAO.class);
        final ActionDAO ActionDAO = jdbi.onDemand(ActionDAO.class);
        
		// Create consumer
		final JwtConsumer consumer = new JwtConsumerBuilder().setAllowedClockSkewInSeconds(30) 
				// allow some leeway in
				// validating time based
				// claims to account for
				// clock skew
				.setRequireExpirationTime() // the JWT must have an expiration time
				.setRequireSubject() // the JWT must have a subject claim
				.setVerificationKey(new HmacKey(key)) // verify the signature with the public key
				.setRelaxVerificationKeyValidation() // relaxes key length requirement
				.build(); // create the JwtConsumer instance

		// Register Authentication Provider
		environment.jersey().register(
				new AuthDynamicFeature(new JwtAuthFilter.Builder<MyUser>().setJwtConsumer(consumer).setRealm("realm")
						.setPrefix("Bearer").setAuthenticator(new JWTAuthenticator(dao)).buildAuthFilter()));

		// Register the API end points with jersey.
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Principal.class));
		environment.jersey().register(RolesAllowedDynamicFeature.class);
		environment.jersey().register(new SecuredResource(configuration.getJwtTokenSecret(), dao));
		environment.jersey().register(new UserResource(dao));
		environment.jersey().register(new YouthResource(YouthDAO));
		environment.jersey().register(new CountyResource(CountyDAO));
		environment.jersey().register(new CounselorResource(CounselorDAO));
		environment.jersey().register(new CourtRelatedResource(CourtRelatedDAO));
        environment.jersey().register(new RunningRecordResource(RunningRecordDAO));
        environment.jersey().register(new CustodyResource(CustodyDAO));
        environment.jersey().register(new ActionResource(ActionDAO));
        environment.jersey().register(new CaseResource(CaseDAO));
        environment.jersey().register(new ChargeResource(ChargeDAO));
        environment.jersey().register(new ContactResource(ContactDAO));
        environment.jersey().register(new ContRiskResource(ContRiskDAO));
        environment.jersey().register(new CaseNoteResource(CaseNoteDAO));
		enableCorsHeaders(environment);
	}

	// Enable Cross Site Origin Request Headers
	private void enableCorsHeaders(Environment environment) {
		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// Configure CORS parameters
		cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
		cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

	}

	@NameBinding
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.TYPE, ElementType.METHOD })
	public @interface Secured {
	}

	@Secured
	@Provider
	@Priority(Priorities.AUTHENTICATION)
	public class AuthenticationFilter implements ContainerRequestFilter {

		UserDAO UserDAO;

		AuthenticationFilter(UserDAO userDAO) {
			this.UserDAO = userDAO;
		}

		private static final String REALM = "example";
		private static final String AUTHENTICATION_SCHEME = "Bearer";

		@Override
		public void filter(ContainerRequestContext requestContext) throws IOException {

			// Get the Authorization header from the request
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

			// Validate the Authorization header
			if (!isTokenBasedAuthentication(authorizationHeader)) {
				abortWithUnauthorized(requestContext);
				return;
			}

			// Extract the token from the Authorization header
			String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

			try {

				// Validate the token
				validateToken(token);

			} catch (Exception e) {
				abortWithUnauthorized(requestContext);
			}
		}

		private boolean isTokenBasedAuthentication(String authorizationHeader) {

			// Check if the Authorization header is valid
			// It must not be null and must be prefixed with "Bearer" plus a whitespace
			// The authentication scheme comparison must be case-insensitive
			return authorizationHeader != null
					&& authorizationHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
		}

		private void abortWithUnauthorized(ContainerRequestContext requestContext) {

			// Abort the filter chain with a 401 status code response
			// The WWW-Authenticate header is sent along with the response
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
					.header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"").build());
		}

		private void validateToken(String token) throws Exception {
			// Check if the token was issued by the server and if it's not expired
			// Throw an Exception if the token is invalid
		}
	}

	public class JWTAuthenticator implements Authenticator<JwtContext, MyUser> {

		UserDAO UserDAO;

		public JWTAuthenticator(UserDAO userDAO) {
			this.UserDAO = userDAO;
		}

		@Override
		public Optional<MyUser> authenticate(JwtContext context) {
			// Provide your own implementation to lookup users based on the principal
			// attribute in the
			// JWT Token. E.g.: lookup users from a database etc.
			// This method will be called once the token's signature has been verified

			// In case you want to verify different parts of the token you can do that here.
			// E.g.: Verifying that the provided token has not expired.

			// All JsonWebTokenExceptions will result in a 401 Unauthorized response.

			try {
				if (context.getJwtClaims().getExpirationTime().isAfter(NumericDate.now())) {
					final String subject = context.getJwtClaims().getSubject();
					MyUser user = UserDAO.findByUsername(subject);

					if (user.getId() != null) {
						return Optional.of(new MyUser(user.getId(), user.getUsername()));
					}
				}
				return Optional.empty();
			} catch (MalformedClaimException e) {
				return Optional.empty();
			}

		}
	}

}
