package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Documents;
import edu.usm.sosw.sword.db.DocumentsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Documents</code> class provides a JSON REST API end point for Documents objects and the <code>Documentss</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Documents
 * @see DocumentsResource
 */

@Path("/api/v1/documents")
@Produces(MediaType.APPLICATION_JSON)
public class DocumentsResource {
	DocumentsDAO DocumentsDAO;
	
	public DocumentsResource(DocumentsDAO DocumentsDAO) {
		this.DocumentsDAO = DocumentsDAO;
		this.DocumentsDAO.createDocumentsTable();
	}
	
	@GET
	public List<Documents> getAll() { return DocumentsDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public Documents getId(@PathParam("id") Integer id) { return DocumentsDAO.findById(id); }
	
	@GET
	@Path("/charge/{id}") 
	public Documents getChargeId(@PathParam("chargeid") Integer chargeid) { return DocumentsDAO.findByChargeId(chargeid); }
	
	@POST
	public int add(@Valid Documents Documents) { return DocumentsDAO.insert(Documents); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Documents Documents) { DocumentsDAO.updateById(Documents); }
	
	@PUT
	@Path("/charge/{id}")
	public void updateByChargeId(@Valid Documents Documents) { DocumentsDAO.updateByChargeId(Documents); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { DocumentsDAO.deleteById(id); }
	
	@DELETE
	@Path("/charge/{id}")
	public void deleteByChargeId(@PathParam("chargeid") Integer chargeid) { DocumentsDAO.deleteByChargeId(chargeid); }
}
