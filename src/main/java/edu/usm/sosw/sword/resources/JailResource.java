package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Jail;
import edu.usm.sosw.sword.db.JailDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Jail</code> class provides a JSON REST API end point for Jail objects and the <code>Jails</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Jail
 * @see JailResource
 */

@Path("/api/v1/jail")
@Produces(MediaType.APPLICATION_JSON)
public class JailResource {
	// Database interface instance
	JailDAO JailDAO;
	
	public JailResource(JailDAO JailDAO) {
		this.JailDAO = JailDAO;
		this.JailDAO.createJailTable();
	}
	
	@GET
	public List<Jail> getAll() { return JailDAO.getAll(); }
		
	@GET
	@Path("/{id}")
	public Jail getId(@PathParam("id") Integer id) { return JailDAO.findById(id); }
	
	
	@POST
	public int add(@Valid Jail Jail) { return JailDAO.insert(Jail); }
	
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Jail Jail) { JailDAO.updateById(Jail); }
	
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { JailDAO.deleteById(id); }
}