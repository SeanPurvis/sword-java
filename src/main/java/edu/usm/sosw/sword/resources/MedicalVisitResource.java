package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.MedicalVisit;
import edu.usm.sosw.sword.db.MedicalVisitDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>MedicalVisit</code> class provides a JSON REST API end point for MedicalVisit objects and the <code>MedicalVisits</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see MedicalVisit
 * @see MedicalVisitResource
 */

@Path("/api/v1/medical_visit")
@Produces(MediaType.APPLICATION_JSON)
public class MedicalVisitResource {
	
	MedicalVisitDAO MedicalVisitDAO;
	
	public MedicalVisitResource(MedicalVisitDAO MedicalVisitDAO) {
		this.MedicalVisitDAO = MedicalVisitDAO;
		this.MedicalVisitDAO.getAll();
	}
	
	@GET
	public List<MedicalVisit> getAll() { return MedicalVisitDAO.getAll(); }
	
	@GET
	@Path("/medical_visit/{id}")
	public MedicalVisit getMedicalVisitId(@PathParam("medical_visit_id") Integer medical_visit_id) { 
		return MedicalVisitDAO.findByMedicalVisitId(medical_visit_id); 
	}
	
	@GET
	@Path("/youth/{id}")
	public MedicalVisit getYouthId(@PathParam("youthid") Integer youthid) { return MedicalVisitDAO.findByYouthId(youthid); }
	
	@POST
	public int add(@Valid MedicalVisit MedicalVisit) { return MedicalVisitDAO.insert(MedicalVisit); }
	
	@PUT
	@Path("/medical_visit/{id}")
	public void updateByMedicalVisitId(@Valid MedicalVisit MedicalVisit) { MedicalVisitDAO.updateByMedicalVisitId(MedicalVisit); }
	
	@PUT
	@Path("/youth/{id}")
	public void updateByYouthId(@Valid MedicalVisit MedicalVisit) { MedicalVisitDAO.updateByYouthId(MedicalVisit); }
	
	@DELETE
	@Path("/medical_visit/{id}")
	public void deleteByMedicalVisitId(@PathParam("medical_visit_id") Integer medical_visit_id) { 
		MedicalVisitDAO.deleteByMedicalVisitId(medical_visit_id); 
	}
	
	@DELETE
	@Path("/youth/{id}")
	public void deleteByYouthid(@PathParam("youthid") Integer youthid) { MedicalVisitDAO.deleteByYouthId(youthid); }
}
