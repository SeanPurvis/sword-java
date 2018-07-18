package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.DcIncidents;
import edu.usm.sosw.sword.db.DcIncidentsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>DcIncidents</code> class provides a JSON REST API end point for DcIncidents objects and the <code>DcIncidentss</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see DcIncidents
 * @see DcIncidentsResource
 */

@Path("/api/v1/dc_incidents")
@Produces(MediaType.APPLICATION_JSON)
public class DcIncidentsResource {
	// Database interface instance
	DcIncidentsDAO DcIncidentsDAO;
	
	public DcIncidentsResource(DcIncidentsDAO DcIncidentsDAO) {
		this.DcIncidentsDAO = DcIncidentsDAO;
		this.DcIncidentsDAO.createDcIncidentsTable();
	}
	
	@GET
	public List<DcIncidents> getAll() { return DcIncidentsDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public DcIncidents getId(@PathParam("id") Integer id) { return DcIncidentsDAO.findById(id); }
	
	@GET
	@Path("/case/{id}") 
	public DcIncidents getCaseId(@PathParam("caseid") Integer caseid) { return DcIncidentsDAO.findByCaseId(caseid); }
	
	@POST
	public int add(@Valid DcIncidents DcIncidents) { return DcIncidentsDAO.insert(DcIncidents); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid DcIncidents DcIncidents) { DcIncidentsDAO.updateById(DcIncidents); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseid(@Valid DcIncidents DcIncidents) { DcIncidentsDAO.updateByCaseId(DcIncidents); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { DcIncidentsDAO.deleteById(id); }
	
	@DELETE
	@Path("/id")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { DcIncidentsDAO.deleteByCaseId(caseid); }
}
