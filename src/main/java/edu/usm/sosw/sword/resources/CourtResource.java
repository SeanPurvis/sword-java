package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Court;
import edu.usm.sosw.sword.db.CourtDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Court</code> class provides a JSON REST API end point for Court objects and the <code>Courts</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Court
 * @see CourtResource
 */

@Path("/api/v1/courts")
@Produces(MediaType.APPLICATION_JSON)
public class CourtResource {
	//Database interface instance
	CourtDAO CourtDAO;
	
	public CourtResource(CourtDAO CourtDAO) {
		this.CourtDAO = CourtDAO;
		this.CourtDAO.createCourtTable();
	}
	
	@GET
	public List<Court> getALL() { return CourtDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public Court getId(@PathParam("id") Integer id) { return CourtDAO.findById(id); }
	
	@GET
	@Path("/case/{id}")
	public Court getCaseId(@PathParam("caseid") Integer caseid) { return CourtDAO.findByCaseId(caseid); }
	
	@POST
	public int add(@Valid Court Court) { return CourtDAO.insert(Court); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Court Court) { CourtDAO.updateById(Court); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid Court Court) { CourtDAO.updateByCaseId(Court); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { CourtDAO.deleteById(id); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { CourtDAO.deleteByCaseId(caseid); }
}
