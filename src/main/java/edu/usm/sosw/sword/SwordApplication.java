package edu.usm.sosw.sword;

import java.security.Principal;
import java.util.Optional;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jose4j.jwt.MalformedClaimException;
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

import static java.math.BigDecimal.ONE;

import java.io.UnsupportedEncodingException;

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
                .setAuthenticator(new ExampleAuthenticator())
                .buildAuthFilter()));

        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Principal.class));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new SecuredResource(configuration.getJwtTokenSecret()));
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
		final UserDAO dao = jdbi.onDemand(UserDAO.class);
		environment.jersey().register(new UserResource(dao));
        
    }

    private static class ExampleAuthenticator implements Authenticator<JwtContext, MyUser> {

        @Override
        public Optional<MyUser> authenticate(JwtContext context) {
            // Provide your own implementation to lookup users based on the principal attribute in the
            // JWT Token. E.g.: lookup users from a database etc.
            // This method will be called once the token's signature has been verified

            // In case you want to verify different parts of the token you can do that here.
            // E.g.: Verifying that the provided token has not expired.

            // All JsonWebTokenExceptions will result in a 401 Unauthorized response.

            try {
                final String subject = context.getJwtClaims().getSubject();
                if ("good-guy".equals(subject)) {
                    return Optional.of(new MyUser(ONE, "good-guy"));
                }
                return Optional.empty();
            }
            catch (MalformedClaimException e) { return Optional.empty(); }
        }
    }

}
