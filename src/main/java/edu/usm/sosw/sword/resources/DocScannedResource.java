package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.DocScanned;
import edu.usm.sosw.sword.db.DocScannedDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>DocScanned</code> class provides a JSON REST API end point for DocScanned objects and the <code>DocScanneds</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see DocScanned
 * @see DocScannedResource
 */

@Path("/api/v1/docscanned")
@Produces(MediaType.APPLICATION_JSON)
public class DocScannedResource {
	//Database interface instance
	DocScannedDAO DocScannedDAO;
	
	public DocScannedResource(DocScannedDAO DocScannedDAO) {
		this.DocScannedDAO = DocScannedDAO;
		this.DocScannedDAO.createDocScannedTable();
	}
	
	@GET
	public List<DocScanned> getAll() { return DocScannedDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public DocScanned getId(@PathParam("id") Integer id) { return DocScannedDAO.findById(id); }
	
	@GET
	@Path("/case/{id}")
	public DocScanned getCaseId(@PathParam("caseid") Integer caseid) { return DocScannedDAO.findByCaseId(caseid); }
	
	@POST
	public int add(@Valid DocScanned DocScanned) { return DocScannedDAO.insert(DocScanned); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid DocScanned DocScanned) { DocScannedDAO.updateById(DocScanned); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid DocScanned DocScanned) { DocScannedDAO.updateByCaseId(DocScanned); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { DocScannedDAO.deleteById(id); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { DocScannedDAO.deleteByCaseId(caseid); }
}
