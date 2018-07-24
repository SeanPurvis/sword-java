package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Case;
import edu.usm.sosw.sword.db.CaseDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Case</code> class provides a JSON REST API end point for Case objects and the <code>cases</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Case
 * @see CaseResource
 */

@Path("/api/v1/case")
@Produces(MediaType.APPLICATION_JSON)
public class CaseResource {
	// Database interface instance
	CaseDAO CaseDAO;
	
	public CaseResource(CaseDAO CaseDAO) {
		this.CaseDAO = CaseDAO;
		this.CaseDAO.createCasesTable();
	}
	
	@GET
	public List<Case> getAll() { return CaseDAO.getAll(); }
	
	@GET
	@Path("/did/{id}")
	public Case getDid(@PathParam("did") String did) { return CaseDAO.findByDid(did); }
	
	@GET
	@Path("/{id}")
	public Case getId(@PathParam("id") Integer id) { return CaseDAO.findById(id); }
	
	@GET
	@Path("/youthid/{id}")
	public Case getYouthId(@PathParam("youthid") Integer youthid) { return CaseDAO.findByYouthId(youthid); }
	
	@POST
	public int add(@Valid Case Case) { return CaseDAO.insert(Case); }
	
	@PUT
	@Path("/did/{id}")
	public void updateByDid(@Valid Case Case) { CaseDAO.updateByDid(Case); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Case Case) { CaseDAO.updateById(Case); }
	
	@PUT
	@Path("/youth/{id}")
	public void updateByYouthId(@Valid Case Case) { CaseDAO.updateByYouthId(Case); }
	
	@DELETE
	@Path("/did/{id}")
	public void deleteByDid(@PathParam("did") String did) { CaseDAO.deleteByDid(did); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { CaseDAO.deleteById(id); }
	
	@DELETE
	@Path("/youth/{id}")
	public void deleteByYouthId(@PathParam("youthid") Integer youthid) { CaseDAO.deleteByYouthId(youthid); }	
}









