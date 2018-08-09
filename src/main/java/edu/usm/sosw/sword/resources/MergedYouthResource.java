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

import edu.usm.sosw.sword.api.MergedYouth;
import edu.usm.sosw.sword.db.MergedYouthDAO;

/**
 * The <code>MergedYouth</code> class provides a JSON REST API end point for MergedYouth objects and the <code>MergedYouth</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see MergedYouth
 * @see MergedYouthDAO
 */
@Path("/api/v1/merged_youths")
@Produces(MediaType.APPLICATION_JSON)
public class MergedYouthResource {
    // Our database interface instance.
    MergedYouthDAO MergedYouthDAO;

    public MergedYouthResource(MergedYouthDAO MergedYouthDAO) {
        this.MergedYouthDAO = MergedYouthDAO;
        this.MergedYouthDAO.createMergedYouthTable();
    }

    @GET
    public List<MergedYouth> getAll(){
        return MergedYouthDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public MergedYouth get(@PathParam("id") Integer id) {
        return MergedYouthDAO.findById(id);
    }

    @POST
    public int add(@Valid MergedYouth MergedYouth) {
        return MergedYouthDAO.insert(MergedYouth);
    }

    @PUT
    @Path("/{id}")
    public void update(@Valid MergedYouth MergedYouth) {
        MergedYouthDAO.updateById(MergedYouth);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        MergedYouthDAO.deleteById(id);
    }
}
