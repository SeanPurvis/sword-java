package edu.usm.sosw.sword.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.dropwizard.auth.AuthenticationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

import edu.usm.sosw.sword.api.Credentials;
import edu.usm.sosw.sword.api.User;
import edu.usm.sosw.sword.db.UserDAO;


@Path("/authentication")
public class Authentication {
	
	UserDAO userDAO;
	
	Key key = MacProvider.generateKey();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("username") String username,
									 @FormParam("password") String password) {
		
		//String username = credentials.getUsername();
		//String password = credentials.getPassword();
		
		try {
			//Authenticate user with the credentials provided
			authenticate(username, password);
			
			// Issue a token for the user
			String token = issueToken(username);
			
			// Return the token to the response
			return Response.ok(token).build();
		} catch (Exception e) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}
	
	private void authenticate(String username, String password) throws Exception {
		// Authenticate against the database
		// Throw an exception if credentials are invalid

		// Results from the SQL query 
		User login = userDAO.findByUsername(username);
		
		boolean flag = User.checkPassword(password, login.getPassword());
		
		// Checks if the stored username and password are the same as
		// the credentials provided.
			if (!flag) {
				throw new Exception("Login failed.");
			}
		}
	
	private String issueToken(String username) {
		// Issue a token associated to the user
		// Return the issued token
		String compactJws = Jwts.builder()
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();
		return compactJws;
	}
}
