package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.DcCharges;
import edu.usm.sosw.sword.db.DcChargesDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>DcCharges</code> class provides a JSON REST API end point for DcCharges objects and the <code>DcChargess</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see DcCharges
 * @see DcChargesResource
 */

@Path("/api/v1/dc_charges")
@Produces(MediaType.APPLICATION_JSON)
public class DcChargesResource {
	DcChargesDAO DcChargesDAO;
	
	public DcChargesResource(DcChargesDAO DcChargesDAO) {
		this.DcChargesDAO = DcChargesDAO;
		this.DcChargesDAO.createDcChargesTable();
	}
	
	@GET
	public List<DcCharges> getAll() { return DcChargesDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public DcCharges getId(@PathParam("id") Integer id) { return DcChargesDAO.findById(id); }
	
	@GET
	@Path("/case/{id}")
	public DcCharges getCaseId(@PathParam("caseid") Integer caseid) { return DcChargesDAO.findByCaseid(caseid); }
	
	@POST
	public int add(@Valid DcCharges DcCharges) { return DcChargesDAO.insert(DcCharges); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid DcCharges DcCharges) { DcChargesDAO.updateById(DcCharges); }
	
	@PUT
	@Path("/case/{id}") 
	public void updateByCaseId(@Valid DcCharges DcCharges) { DcChargesDAO.updateByCaseId(DcCharges); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { DcChargesDAO.deleteById(id); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { DcChargesDAO.deleteByCaseId(caseid); }
}
