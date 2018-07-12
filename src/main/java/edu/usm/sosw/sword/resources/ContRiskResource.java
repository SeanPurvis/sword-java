package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.ContRisk;
import edu.usm.sosw.sword.db.ContRiskDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>ContRisk</code> class provides a JSON REST API end point for ContRisk objects and the <code>ContRisks</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see ContRisk
 * @see ContRiskResource
 */
@Path("api/v1/cont_risk")
@Produces(MediaType.APPLICATION_JSON)
public class ContRiskResource {
	//Database interface instance
	ContRiskDAO ContRiskDAO;
	
	public ContRiskResource(ContRiskDAO ContRiskDAO) {
		this.ContRiskDAO = ContRiskDAO;
		this.ContRiskDAO.createContRiskTable();
	}
	
	@GET
	public List<ContRisk> getAll() { return ContRiskDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public ContRisk getId(@PathParam("id") Integer id) { return ContRiskDAO.findById(id); }
	
	@GET
	@Path("/case/{id}")
	public ContRisk getCaseId(@PathParam("caseid") Integer caseid) { return ContRiskDAO.findByCaseId(caseid); }
	
	@POST
	public int add(@Valid ContRisk ContRisk) { return ContRiskDAO.insert(ContRisk); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid ContRisk ContRisk) { ContRiskDAO.updateById(ContRisk); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid ContRisk ContRisk) { ContRiskDAO.updateByCaseId(ContRisk); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { ContRiskDAO.deleteById(id); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { ContRiskDAO.deleteByCaseId(caseid); }
}
