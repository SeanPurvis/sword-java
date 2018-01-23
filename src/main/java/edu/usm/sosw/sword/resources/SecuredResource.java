package edu.usm.sosw.sword.resources;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;

import edu.usm.sosw.sword.api.Credentials;
import edu.usm.sosw.sword.api.MyUser;
import edu.usm.sosw.sword.db.UserDAO;
import io.dropwizard.auth.Auth;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.security.Principal;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.jose4j.jws.AlgorithmIdentifiers.HMAC_SHA256;

@Path("/jwt")
@Produces(APPLICATION_JSON)
public class SecuredResource {
	
	UserDAO UserDAO;

    private final byte[] tokenSecret;

    public SecuredResource(byte[] tokenSecret, UserDAO UserDAO) {
        this.tokenSecret = tokenSecret;
        this.UserDAO = UserDAO;
        this.UserDAO.createMyUserTable();
    }

    @SuppressWarnings("deprecation")
	@POST
    @Path("/authenticate")
    @Consumes(APPLICATION_JSON)
    public Map<String, String> generateValidToken(Credentials credentials){

    	MyUser user = UserDAO.findByUsername(credentials.getUsername());
    	
    	if (user.checkPassword(credentials.getPassword(), user.getPassword())) {
    		
        final JwtClaims claims = new JwtClaims();
        claims.setSubject(user.getUsername());
        claims.setClaim("id", user.getId());
        claims.setClaim("role", user.getRole());
        claims.setExpirationTimeMinutesInTheFuture(30);

        final JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(HMAC_SHA256);
        jws.setKey(new HmacKey(tokenSecret));
        try {
            return singletonMap("token", jws.getCompactSerialization());
        }
        catch (JoseException e) { throw Throwables.propagate(e); }
    	}
    	return singletonMap("error", "Login failed.");
    }

    @GET
    @Path("/check-token")
    public Map<String, Object> get(@Auth Principal user) {
        return ImmutableMap.<String, Object>of("username", user.getName(), "id", ((MyUser) user).getId());
    }
}