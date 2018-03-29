package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import edu.usm.sosw.sword.api.MyUser;
import edu.usm.sosw.sword.db.UserDAO;

/**
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * 
 * The MyUserResource class provides a JSON REST API end point for MyUser objects and the static_MyUsers table. 
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function. 
 * 
 */
@Path("/api/v1/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	// Our database interface instance.
	UserDAO UserDAO;
	
	public UserResource(UserDAO UserDAO) {
		this.UserDAO = UserDAO;
		this.UserDAO.createMyUserTable();
	}
	
	@GET
	public List<MyUser> getAll(){
		return UserDAO.getAll();
	}
	
	@GET
	@Path("/{id}")
	public MyUser get(@PathParam("id") Integer id) {
		return UserDAO.findById(id);
	}
	
	@POST
	public int add(@Valid MyUser MyUser) {
		// Pull the MyUser password, pass it to the hashing function, and then set the hash as the object's password.
		MyUser.setPassword(MyUser.hashPassword(MyUser.getPassword()));
		return UserDAO.insert(MyUser);
	}
	
	@PUT
	@Path("/{id}")
	public void update(@Valid MyUser MyUser) {
		UserDAO.update(MyUser);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		UserDAO.deleteById(id);
	}
}
