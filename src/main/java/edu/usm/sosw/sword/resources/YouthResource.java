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

import edu.usm.sosw.sword.api.Youth;
import edu.usm.sosw.sword.db.YouthDAO;

/**
 * The YouthResource class provides a JSON REST API end point for Youth objects and the <code>youths</code> table. 
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function. 
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * 
 * @see Youth 
 * @see YouthDAO
 */
@Path("/api/v1/youth")
@Produces(MediaType.APPLICATION_JSON)
public class YouthResource {
	
	// Database interface instance
	YouthDAO YouthDAO;
	
	public YouthResource(YouthDAO YouthDAO) {
		this.YouthDAO = YouthDAO;
		this.YouthDAO.createYouthTable();
	}
	
	@GET
	@PermitAll
	public List<Youth> getAll() {
		return YouthDAO.getAll();
	}
	
	@GET
	@PermitAll
	@Path("/{id}")
	public Youth get(@PathParam("id") Integer id) {
		return YouthDAO.findById(id);
	}
	
	@POST
	@PermitAll
	public int add(@Valid Youth Youth) {
		return YouthDAO.insert(Youth);
	}
	
	@PUT
	@PermitAll
	@Path("/{id}")
	public void update(@Valid Youth Youth) {
		YouthDAO.update(Youth);
	}
	
	@DELETE
	@PermitAll
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		YouthDAO.deleteById(id);
	}
}
