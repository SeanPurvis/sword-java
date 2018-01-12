package edu.usm.sosw.sword.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.usm.sosw.sword.api.Credentials;

@Path("/authentication")
public class Authentication {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateUser(Credentials credentials) {
		
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
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
	}
	
	private String issueToken(String username) {
		// Issue a token associated to the user
		// Return the issued token
	}
}
