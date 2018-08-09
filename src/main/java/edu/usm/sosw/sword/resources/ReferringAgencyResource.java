package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.usm.sosw.sword.api.ReferringAgency;
import edu.usm.sosw.sword.db.ReferringAgencyDAO;

/**
 * The ReferringAgencyResource class provides a JSON REST API end point for ReferringAgency objects and the <code>static_referring_agencies</code> table. 
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function. 
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * 
 * @see ReferringAgency 
 * @see ReferringAgencyDAO
 */
@Path("/api/v1/referring_agencies")
@Produces(MediaType.APPLICATION_JSON)
public class ReferringAgencyResource {
	
	// Database interface instance
	ReferringAgencyDAO ReferringAgencyDAO;
	
	public ReferringAgencyResource(ReferringAgencyDAO ReferringAgencyDAO) {
		this.ReferringAgencyDAO = ReferringAgencyDAO;
		this.ReferringAgencyDAO.createReferringAgencyTable();
	}
	
	@GET
	public List<ReferringAgency> getAll() {
		return ReferringAgencyDAO.getAll();
	}
	
	@GET
	@Path("/{id}")
	public ReferringAgency get(@PathParam("id") Integer id) {
		return ReferringAgencyDAO.findById(id);
	}
	
	@PUT
	@Path("/{id}")
	public void update(@Valid ReferringAgency ReferringAgency) {
		ReferringAgencyDAO.updateById(ReferringAgency);
	}
	
	@POST
	public int add(@Valid ReferringAgency ReferringAgency) {
		return ReferringAgencyDAO.insert(ReferringAgency);
	}
	
	@DELETE
	public void delete(@PathParam("id") Integer id) {
		ReferringAgencyDAO.deleteById(id);
	}
}
