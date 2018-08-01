package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.MedicalStaff;
import edu.usm.sosw.sword.db.MedicalStaffDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>MedicalStaff</code> class provides a JSON REST API end point for MedicalStaff objects and the <code>MedicalStaffs</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see MedicalStaff
 * @see MedicalStaffResource
 */

@Path("/api/v1/medical_staff")
@Produces(MediaType.APPLICATION_JSON)
public class MedicalStaffResource {
	
	MedicalStaffDAO MedicalStaffDAO;
	
	public MedicalStaffResource(MedicalStaffDAO MedicalStaffDAO) {
		this.MedicalStaffDAO = MedicalStaffDAO;
		this.MedicalStaffDAO.createMedicalStaffTable();
	}
	
	@GET
	public List<MedicalStaff> getAll() { return MedicalStaffDAO.getAll(); }
	
	@GET
	@Path("/med_emp/{id}")
	public MedicalStaff getMedEmpId(@PathParam("med_emp_id") Integer med_emp_id) { return MedicalStaffDAO.findByMedEmpId(med_emp_id); }
	
	@POST
	public int add(@Valid MedicalStaff MedicalStaff) { return MedicalStaffDAO.insert(MedicalStaff); }
	
	@PUT
	@Path("/med_emp/{id}")
	public void udpateByMedEmpId(@Valid MedicalStaff MedicalStaff) { MedicalStaffDAO.updateByMedEmpId(MedicalStaff); }
	
	@DELETE
	@Path("/med_emp/{id}")
	public void deleteByMedEmpId(@PathParam("med_emp_id") Integer med_emp_id) { MedicalStaffDAO.deleteByMedEmpId(med_emp_id); }
}
