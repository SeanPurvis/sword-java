package edu.usm.sosw.sword.resources;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import edu.usm.sosw.sword.api.Custody;
import edu.usm.sosw.sword.db.CustodyDAO;

/**
 * The <code>Custody</code> class provides a JSON REST API end point for Custody objects and the <code>custody</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 *
 * @see Custody
 * @see CustodyDAO
 */
@Path("/api/v1/custody")
@Produces(MediaType.APPLICATION_JSON)
public class CustodyResource {
    // Our database interface instance.
    CustodyDAO CustodyDAO;

    public CustodyResource(CustodyDAO CustodyDAO) {
        this.CustodyDAO = CustodyDAO;
        this.CustodyDAO.createCustodyTable();
    }

    @GET
    public List<Custody> getAll(){
        return CustodyDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public Custody get(@PathParam("id") Integer id) {
        return CustodyDAO.findById(id);
    }

    @POST
    public int add(@Valid Custody Custody) {
        return CustodyDAO.insert(Custody);
    }

    @PUT
    @Path("/{id}")
    public void update(@Valid Custody Custody) {
        CustodyDAO.update(Custody);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        CustodyDAO.deleteById(id);
    }
}
