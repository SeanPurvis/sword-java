package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Contact;
import edu.usm.sosw.sword.db.ContactDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Contact</code> class provides a JSON REST API end point for Contact objects and the <code>Contacts</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Contact
 * @see ContactResource
 */
@Path("api/v1/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
	//Our database interface instance
	ContactDAO ContactDAO;
	
	public ContactResource(ContactDAO ContactDAO) {
		this.ContactDAO = ContactDAO;
		this.ContactDAO.createContactsTable();
	}
	
	@GET
	public List<Contact> getAll() { return ContactDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public Contact getId(@PathParam("id") Integer id) { return ContactDAO.findById(id); }
	
	@GET
	@Path("/case/{id}")
	public Contact getCaseId(@PathParam("caseid") Integer caseid) { return ContactDAO.findByCaseId(caseid); }
	
	@POST
	public int add(@Valid Contact Contact) { return ContactDAO.insert(Contact); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Contact Contact) { ContactDAO.updateById(Contact); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid Contact Contact) { ContactDAO.updateByCaseId(Contact); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { ContactDAO.deleteById(id); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { ContactDAO.deleteByCaseId(caseid); }
}
