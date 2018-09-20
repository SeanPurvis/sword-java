package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Action;
import edu.usm.sosw.sword.db.ActionDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Action</code> class provides a JSON REST API end point for Action objects and the <code>actions</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Action
 * @see ActionResource
 * @see ActionDAO
 */
@Path("/api/v1/actions")
@Produces(MediaType.APPLICATION_JSON)
public class ActionResource {
	// Our database interface instance
	ActionDAO ActionDAO;
	
	public ActionResource(ActionDAO ActionDAO) {
		this.ActionDAO = ActionDAO;
		this.ActionDAO.createActionsTable();
	}
	
	@GET
	public List<Action> getAll() { return ActionDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public Action getId(@PathParam("id") Integer id) { return ActionDAO.findById(id); }
	
	@GET
	@Path("/caseid/{id}")
	public Action getCaseId(@PathParam("caseid") Integer caseid) { return ActionDAO.findByCaseId(caseid); }
	
	@GET
	@Path("/courtid/{id}")
	public Action getCourtId(@PathParam("courtid") Integer courtid) { return ActionDAO.findByCourtId(courtid); }
	
	@POST
	public int add(@Valid Action Action) { return ActionDAO.insert(Action); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Action Action) { ActionDAO.updateById(Action); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid Action Action) { ActionDAO.updateByCaseId(Action); }
	
	@PUT
	@Path("/court/{id}")
	public void updateByCourtId(@Valid Action Action) { ActionDAO.updateByCourtId(Action); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { ActionDAO.deleteById(id);}
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { ActionDAO.deleteByCaseId(caseid); }
	
	@DELETE
	@Path("/court/{id}")
	public void deleteByCourtId(@PathParam("courtid") Integer courtid) { ActionDAO.deleteByCourtId(courtid); }
	
	
}
