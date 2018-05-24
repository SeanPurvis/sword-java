package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.Counselor;
import edu.usm.sosw.sword.db.CounselorDAO;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

/**
 * The <code>County</code> class provides a JSON REST API end point for Counselor objects and the <code>counselors</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future.
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 *
 * @see Counselor
 * @see CounselorResource
 */
@Path("/api/v1/counselor")
@Produces(MediaType.APPLICATION_JSON)
public class CounselorResource {
    // Our database inteface instance
    CounselorDAO CounselorDAO;

    public CounselorResource(CounselorDAO CounselorDAO) {
        this.CounselorDAO = CounselorDAO;
        this.CounselorDAO.createCounselorsTable();
    }

    @GET
    @PermitAll
    public List<Counselor> getAll() { return CounselorDAO.getAll(); }

    @GET
    @PermitAll
    @Path("/{id}")
    public Counselor get(@PathParam("id") Integer id) { return CounselorDAO.findById(id); }

    @POST
    @PermitAll
    public int add(@Valid Counselor Counselor) { return CounselorDAO.insert(Counselor); }

    @PUT
    @PermitAll
    @Path("/{id}")
    public void update(@Valid Counselor Counselor) { CounselorDAO.update(Counselor); }

    @DELETE
    @PermitAll
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) { CounselorDAO.deleteById(id); }

}
