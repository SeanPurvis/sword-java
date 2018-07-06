package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Charge;
import edu.usm.sosw.sword.db.ChargeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>Charge</code> class provides a JSON REST API end point for Charge objects and the <code>Charges</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Charge
 * @see ChargeResource
 */
@Path("api/v1/charges")
@Produces(MediaType.APPLICATION_JSON)
public class ChargeResource {
	//Our database interface instance
	ChargeDAO ChargeDAO;
	
	public ChargeResource(ChargeDAO ChargeDAO) {
		this.ChargeDAO = ChargeDAO;
		this.ChargeDAO.createChargesTable();
	}
	
	@GET
	public List<Charge> getAll() { return ChargeDAO.getAll();}
	
	@GET
	@Path("/case/{id}")
	public Charge getCaseId(@PathParam("caseid") Integer caseid) { return ChargeDAO.findByCaseId(caseid); }
	
	@GET
	@Path("/{id}")
	public Charge getId(@PathParam("id") Integer id) { return ChargeDAO.findById(id); }
	
	@GET
	@Path("/docket_number/{id}")
	public Charge getDocketNum(@PathParam("docket_number") String docket_number) { return ChargeDAO.findByDocketNum(docket_number); }
	
	@POST
	public int add(@Valid Charge Charge) { return ChargeDAO.insert(Charge); }
	
	@PUT
	@Path("/case/{id}")
	public void updateByCaseId(@Valid Charge Charge) { ChargeDAO.updateByCaseId(Charge); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid Charge Charge) { ChargeDAO.updateById(Charge); }
	
	@PUT
	@Path("/docket_number/{id}")
	public void updateByDocketNum(@Valid Charge Charge) { ChargeDAO.updateByDocketNum(Charge); }
	
	@DELETE
	@Path("/case/{id}")
	public void deleteByCaseId(@PathParam("caseid") Integer caseid) { ChargeDAO.deleteByCaseId(caseid); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { ChargeDAO.deleteById(id); }
	
	@DELETE
	@Path("docket_number/{id}")
	public void deleteByDocketNum(@PathParam("docket_number") String docket_number) { ChargeDAO.deleteByDocketNum(docket_number); }
}
