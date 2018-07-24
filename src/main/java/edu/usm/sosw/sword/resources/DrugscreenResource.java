package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Drugscreen;
import edu.usm.sosw.sword.db.DrugscreenDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Drugscreen</code> class provides a JSON REST API end point for Drugscreen objects and the <code>Drugscreens</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Drugscreen
 * @see DrugscreenResource
 */

@Path("/api/v1/drugscreens")
@Produces(MediaType.APPLICATION_JSON)
public class DrugscreenResource {
	
	DrugscreenDAO DrugscreenDAO;
	
	public DrugscreenResource(DrugscreenDAO DrugscreenDAO) {
		this.DrugscreenDAO = DrugscreenDAO;
		this.DrugscreenDAO.createDrugscreenTable();
	}
	
	@GET
	public List<Drugscreen> getAll() { return DrugscreenDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public Drugscreen getId(@PathParam("id") Integer id) { return DrugscreenDAO.findById(id); }
	
	@GET
	@Path("/youth/{id}")
	public Drugscreen getYouthId(@PathParam("youthid") Integer youthid) { return DrugscreenDAO.findByYouthId(youthid); }
	
	@POST
	public int add(@Valid Drugscreen Drugscreen) { return DrugscreenDAO.insert(Drugscreen); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Drugscreen Drugscreen) { DrugscreenDAO.updateById(Drugscreen); }
	
	@PUT
	@Path("/youth/{id}")
	public void updateByYouthId(@Valid Drugscreen Drugscreen) { DrugscreenDAO.updateByYouthId(Drugscreen); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { DrugscreenDAO.deleteById(id); }
	
	@DELETE
	@Path("/youth/{id}")
	public void deleteByYouthId(@PathParam("youthid") Integer youthid) { DrugscreenDAO.deleteByYouthId(youthid); }
}
