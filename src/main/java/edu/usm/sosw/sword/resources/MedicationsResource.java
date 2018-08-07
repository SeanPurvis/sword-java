package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Medications;
import edu.usm.sosw.sword.db.MedicationsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Medications</code> class provides a JSON REST API end point for Medications objects and the <code>Medicationss</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Medications
 * @see MedicationsResource
 */

@Path("/api/v1/medications")
@Produces(MediaType.APPLICATION_JSON)
public class MedicationsResource {
	
	MedicationsDAO MedicationsDAO;
	
	public MedicationsResource(MedicationsDAO MedicationsDAO) {
		this.MedicationsDAO = MedicationsDAO;
		this.MedicationsDAO.createMedicationsTable();
	}
	
	@GET
	public List<Medications> getAll() { return MedicationsDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public Medications getId(@PathParam("id") Integer id) { return MedicationsDAO.findById(id); }
	
	@GET
	@Path("/youth/{id}")
	public Medications getYouthId(@PathParam("Youthid") Integer youthid) { return MedicationsDAO.findByYouthId(youthid); }
	
	@POST
	public int add(@Valid Medications Medications) { return MedicationsDAO.insert(Medications); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Medications Medications) { MedicationsDAO.updateById(Medications); }
	
	@PUT
	@Path("/youth/{id}")
	public void updateByYouthId(@Valid Medications Medications) { MedicationsDAO.updateByYouthId(Medications); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { MedicationsDAO.deleteById(id); }
	
	@DELETE
	@Path("/youth/{id}")
	public void deleteByYouthId(@PathParam("Youthid") Integer youthid) { MedicationsDAO.deleteByYouthId(youthid); }
}
