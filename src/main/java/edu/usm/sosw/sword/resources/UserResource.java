package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mindrot.jbcrypt.BCrypt;

import edu.usm.sosw.sword.api.User;
import edu.usm.sosw.sword.db.UserDAO;

/**
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * 
 * The UserResource class provides a JSON REST API end point for user objects and the static_users table. 
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function. 
 * 
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	// Our database interface instance.
	UserDAO userDAO;
	
	public UserResource(UserDAO userDAO) {
		this.userDAO = userDAO;
		this.userDAO.createUserTable();
	}
	
	@GET
	public List<User> getAll(){
		return userDAO.getAll();
	}
	
	@GET
	@Path("/{id}")
	public User get(@PathParam("id") Integer id) {
		return userDAO.findById(id);
	}
	
	@POST
	public int add(@Valid User user) {
		// Pull the user password, pass it to the hashing function, and then set the hash as the object's password.
		user.setPassword(hashPassword(user.getPassword()));
		return userDAO.insert(user);
	}
	
	@PUT
	@Path("/{id}")
	public void update(@Valid User user) {
		userDAO.update(user);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		userDAO.deleteById(id);
	}
	
    
    /**
     * This method is used to generate a string representing an account password
     * suitable for database storage. It will be OpenBSD style crypt formatted
     * hash string of length=60
     * The bcrypt workload is specified in the final variable below.
     * @param password_plaintext the user's plaintext password provided when
     * creating the new account or logging in.
     * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
     */
    public static String hashPassword(String password_plaintext) {
    	final int workload = 16;
    	String salt = BCrypt.gensalt(workload);
    	String hashed_password = BCrypt.hashpw(password_plaintext, salt);
    	
    	return(hashed_password);
    }
    
    /**
     * This method will verify a computed hash from a plaintext with that of the hash stored in the database. 
     * @param password_plaintext The user's plaintext password as provided during the login request.
     * @param stored_hash The account's stored password from the database. 
     * @return boolean - true if the password matches the password of the stored hash, false otherwise. 
     */
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
    	boolean password_verified = false;
    	
    	if(null == stored_hash || !stored_hash.startsWith("$2a$"))
    		throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
    	
    	password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
    	
    	return(password_verified);
    }
    
}
