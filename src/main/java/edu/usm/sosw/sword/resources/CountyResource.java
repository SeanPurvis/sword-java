package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.usm.sosw.sword.api.County;
import edu.usm.sosw.sword.db.CountyDAO;

/**
 * The <code>County</code> class provides a JSON REST API end point for County objects and the <code>static_counties</code> table. 
 * 
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function.
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * 
 * @see County
 * @see CountyDAO
 */
@Path("/api/v1/county")
@Produces(MediaType.APPLICATION_JSON)
public class CountyResource {
	// Our database interface instance.
	CountyDAO CountyDAO;
	
	public CountyResource(CountyDAO CountyDAO) {
		this.CountyDAO = CountyDAO;
		this.CountyDAO.createCountyTable();
	}
	
	@GET
	@PermitAll
	public List<County> getAll(){
		return CountyDAO.getAll();
	}
	
	@GET
	@PermitAll
	@Path("/{id}")
	public County get(@PathParam("id") Integer id) {
		return CountyDAO.findById(id);
	}
	
	@POST
	@PermitAll
	public int add(@Valid County County) {
		return CountyDAO.insert(County);
	}
	
	@PUT
	@PermitAll
	@Path("/{id}")
	public void update(@Valid County County) {
		CountyDAO.update(County);
	}
	
	@DELETE
	@PermitAll
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		CountyDAO.deleteById(id);
	}
}
