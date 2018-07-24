package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Jailer;
import edu.usm.sosw.sword.db.JailerDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Jailer</code> class provides a JSON REST API end point for Jailer objects and the <code>Jailers</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Jailer
 * @see JailerResource
 */

@Path("/api/v1/jailer")
@Produces(MediaType.APPLICATION_JSON)
public class JailerResource {
	// Database interface instance
	JailerDAO JailerDAO;
	
	public JailerResource(JailerDAO JailerDAO) {
		this.JailerDAO = JailerDAO;
		this.JailerDAO.createJailerTable();
	}
	
	@GET
	public List<Jailer> getAll() { return JailerDAO.getAll(); }
		
	@GET
	@Path("/{id}")
	public Jailer getId(@PathParam("id") Integer id) { return JailerDAO.findById(id); }
	
	
	@POST
	public int add(@Valid Jailer Jailer) { return JailerDAO.insert(Jailer); }
	
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Jailer Jailer) { JailerDAO.updateById(Jailer); }
	
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { JailerDAO.deleteById(id); }
}