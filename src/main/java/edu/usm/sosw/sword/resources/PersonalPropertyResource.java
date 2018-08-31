package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.PersonalProperty;
import edu.usm.sosw.sword.db.PersonalPropertyDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>PersonalProperty</code> class provides a JSON REST API end point for PersonalProperty objects and the <code>PersonalPropertys</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see PersonalProperty
 * @see PersonalPropertyResource
 */
@Path("api/v1/personal_property")
@Produces(MediaType.APPLICATION_JSON)
public class PersonalPropertyResource {
	//Our database interface instance
	PersonalPropertyDAO PersonalPropertyDAO;
	
	public PersonalPropertyResource(PersonalPropertyDAO PersonalPropertyDAO) {
		this.PersonalPropertyDAO = PersonalPropertyDAO;
		this.PersonalPropertyDAO.createPersonalPropertyTable();
	}
	
	@GET
	public List<PersonalProperty> getAll() { return PersonalPropertyDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public PersonalProperty getId(@PathParam("id") Integer id) { return PersonalPropertyDAO.findById(id); }
	
	@GET
	@Path("/case/{id}")
	public PersonalProperty getCaseId(@PathParam("caseid") Integer caseid) { return PersonalPropertyDAO.findByCaseId(caseid); }
	
	@POST
	public int add(@Valid PersonalProperty PersonalProperty) { return PersonalPropertyDAO.insert(PersonalProperty); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid PersonalProperty PersonalProperty) { PersonalPropertyDAO.updateById(PersonalProperty); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid PersonalProperty PersonalProperty) { PersonalPropertyDAO.updateByCaseId(PersonalProperty); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { PersonalPropertyDAO.deleteById(id); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { PersonalPropertyDAO.deleteByCaseId(caseid); }
}
