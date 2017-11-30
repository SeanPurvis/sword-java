package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.usm.sosw.sword.api.User;
import edu.usm.sosw.sword.db.UserDAO;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	UserDAO userDAO;
	
	public UserResource(UserDAO userDAO) {
		this.userDAO = userDAO;
		this.userDAO.createUserTable();
	}
	
	@GET
	public User[] getAll(){
		return userDAO.getAll();
	}
	
	@GET
	@Path("/{id}")
	public User get(@PathParam("id") Integer id) {
		return userDAO.findById(id);
	}
	
	@POST
	public User add(@Valid User user) {
		userDAO.insert(user);
		
		return user;
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		userDAO.deleteById(id);
	}
}
