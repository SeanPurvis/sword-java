package edu.usm.sosw.sword;

import java.security.Principal;
import java.util.Optional;

import javax.annotation.Priority;
import javax.ws.rs.NameBinding;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.keys.HmacKey;
import org.skife.jdbi.v2.DBI;

import com.github.toastshaman.dropwizard.auth.jwt.JwtAuthFilter;

import edu.usm.sosw.sword.db.UserDAO;
import edu.usm.sosw.sword.resources.SecuredResource;
import edu.usm.sosw.sword.resources.UserResource;
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
		return "Sword";
	}

	@Override
	public void initialize(final Bootstrap<SwordConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final SwordConfiguration configuration, final Environment environment) throws UnsupportedEncodingException {
		final byte[] key = configuration.getJwtTokenSecret();
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
		final UserDAO dao = jdbi.onDemand(UserDAO.class);


        final JwtConsumer consumer = new JwtConsumerBuilder()
            .setAllowedClockSkewInSeconds(30) // allow some leeway in validating time based claims to account for clock skew
            .setRequireExpirationTime() // the JWT must have an expiration time
            .setRequireSubject() // the JWT must have a subject claim
            .setVerificationKey(new HmacKey(key)) // verify the signature with the public key
            .setRelaxVerificationKeyValidation() // relaxes key length requirement
            .build(); // create the JwtConsumer instance

        environment.jersey().register(new AuthDynamicFeature(
            new JwtAuthFilter.Builder<MyUser>()
                .setJwtConsumer(consumer)
                .setRealm("realm")
                .setPrefix("Bearer")
                .setAuthenticator(new ExampleAuthenticator(dao))
                .buildAuthFilter()));

        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Principal.class));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new SecuredResource(configuration.getJwtTokenSecret(), dao));
		environment.jersey().register(new UserResource(dao));
        
    }

	@NameBinding
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE, ElementType.METHOD})
	public @interface Secured { }
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
	        String authorizationHeader =
	                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

	        // Validate the Authorization header
	        if (!isTokenBasedAuthentication(authorizationHeader)) {
	            abortWithUnauthorized(requestContext);
	            return;
	        }

	        // Extract the token from the Authorization header
	        String token = authorizationHeader
	                            .substring(AUTHENTICATION_SCHEME.length()).trim();

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
	        return authorizationHeader != null && authorizationHeader.toLowerCase()
	                    .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
	    }

	    private void abortWithUnauthorized(ContainerRequestContext requestContext) {

	        // Abort the filter chain with a 401 status code response
	        // The WWW-Authenticate header is sent along with the response
	        requestContext.abortWith(
	                Response.status(Response.Status.UNAUTHORIZED)
	                        .header(HttpHeaders.WWW_AUTHENTICATE, 
	                                AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
	                        .build());
	    }

	    private void validateToken(String token) throws Exception {
	        // Check if the token was issued by the server and if it's not expired
	        // Throw an Exception if the token is invalid
	    }
	}
    public class ExampleAuthenticator implements Authenticator<JwtContext, MyUser> {
    	
    	UserDAO UserDAO;
    	
    	public ExampleAuthenticator(UserDAO userDAO) {
    		this.UserDAO = userDAO;
    	}
        @Override
        public Optional<MyUser> authenticate(JwtContext context) {
            // Provide your own implementation to lookup users based on the principal attribute in the
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
            }
            catch (MalformedClaimException e) { return Optional.empty(); }
            
        }
    }

}
