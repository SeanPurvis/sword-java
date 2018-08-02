package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import edu.usm.sosw.sword.api.Charge;
import edu.usm.sosw.sword.api.ChargeList;
import edu.usm.sosw.sword.db.ChargeListDAO;

/**
 * The <code>ChargeList</code> class provides a JSON REST API end point for ChargeList objects and the <code>static_charge_list</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 *
 * @see ChargeList
 * @see ChargeListResource
 */
public class ChargeListResource {
	// Our Database Interface instance
	ChargeListDAO ChargeListDAO;
	
	public ChargeListResource(ChargeListDAO ChargeListDAO) {
		this.ChargeListDAO = ChargeListDAO;
		this.ChargeListDAO.createChargeListTable();
	}
	
	@GET
	public List<ChargeList> getAll() { return ChargeListDAO.getAll(); }
	
	@GET
	@Path("/{id}")
	public ChargeList getId(@PathParam("id") Integer id) { return ChargeListDAO.findById(id); }
	
	@POST
	public int add(@Valid ChargeList ChargeList) { return ChargeListDAO.insert(ChargeList); }
	
	@PUT
	@Path("/{id}")
	public void updateById(@Valid ChargeList ChargeList) { ChargeListDAO.updateById(ChargeList); }
	
	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Integer id) { ChargeListDAO.deleteById(id); }
	
}
