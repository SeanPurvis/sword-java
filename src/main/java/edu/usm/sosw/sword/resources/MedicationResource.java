package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Medication;
import edu.usm.sosw.sword.db.MedicationDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Medication</code> class provides a JSON REST API end point for Medication objects and the <code>Medications</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Medication
 * @see MedicationResource
 */

@Path("/api/v1/static_medication")
@Produces(MediaType.APPLICATION_JSON)
public class MedicationResource {
	
	MedicationDAO MedicationDAO;
	
	public MedicationResource(MedicationDAO MedicationDAO) {
		this.MedicationDAO = MedicationDAO;
		this.MedicationDAO.createmedicationTable();
	}
	
	@GET
	public List<Medication> getAll() { return MedicationDAO.getAll(); }
	
	@GET
	@Path("/med/{id}")
	public Medication getMedId(@PathParam("med_id") Integer med_id) { return MedicationDAO.findByMedId(med_id); }
	
	@POST
	public int add(@Valid Medication Medication) { return MedicationDAO.insert(Medication); }
	
	@PUT
	@Path("/med/{id}")
	public void updateById(@Valid Medication Medication) { MedicationDAO.updateByMedId(Medication); }
	
	@DELETE
	@Path("/med/{id}")
	public void deleteByMedId(@PathParam("med_id") Integer med_id) { MedicationDAO.deleteByMedId(med_id); }
}
