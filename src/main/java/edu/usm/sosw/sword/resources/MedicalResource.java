package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Medical;
import edu.usm.sosw.sword.db.MedicalDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Medical</code> class provides a JSON REST API end point for Medical objects and the <code>Medicals</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Medical
 * @see MedicalResource
 */

@Path("/api/v1/medical")
@Produces(MediaType.APPLICATION_JSON)
public class MedicalResource {
	
	MedicalDAO MedicalDAO;
	
	public MedicalResource(MedicalDAO MedicalDAO) {
		this.MedicalDAO = MedicalDAO;
		this.MedicalDAO.createMedicalTable();
	}
	
	@GET
	public List<Medical> getAll() { return MedicalDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public Medical getId(@PathParam("id") Integer id) { return MedicalDAO.findById(id); }
	
	@GET
	@Path("/case/{id}")
	public Medical getCaseId(@PathParam("caseid") Integer caseid) { return MedicalDAO.findByCaseId(caseid); }
	
	@POST
	public int add(@Valid Medical Medical) { return MedicalDAO.insert(Medical); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Medical Medical) { MedicalDAO.updateById(Medical); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid Medical Medical) { MedicalDAO.updateByCaseId(Medical); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { MedicalDAO.deleteById(id); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { MedicalDAO.deleteByCaseId(caseid); }
}
