package edu.usm.sosw.sword.resources;

import edu.usm.sosw.sword.api.CourtRelated;
import edu.usm.sosw.sword.db.CourtRelatedDAO;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The <code>CourtRelatedResource</code> class provides a JSON REST API end point for <code>CourtRelated</code> objects
 * and the <code>static_court_related</code> table.
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 *
 * @see CourtRelated
 * @see CourtRelatedDAO
 */
@Path("/api/v1/courtrelated")
@Produces(MediaType.APPLICATION_JSON)
public class CourtRelatedResource {
    // Our database interface instance
    CourtRelatedDAO CourtRelatedDAO;

    public CourtRelatedResource(CourtRelatedDAO CourtRelatedDAO) {
        this.CourtRelatedDAO = CourtRelatedDAO;
        this.CourtRelatedDAO.createCourtRelatedTable();
    }

    @GET
    @PermitAll
    public List<CourtRelated> getAll() { return CourtRelatedDAO.getAll(); }

    @GET
    @PermitAll
    @Path("/{id}")
    public CourtRelated get(@PathParam("id") Integer id) { return CourtRelatedDAO.findById(id); }

    @POST
    @PermitAll
    public int add(@Valid CourtRelated CourtRelated) { return CourtRelatedDAO.insert(CourtRelated); }

    @PUT
    @PermitAll
    @Path("/{id}")
    public void update(@Valid CourtRelated CourtRelated) { CourtRelatedDAO.update(CourtRelated);}

    @DELETE
    @PermitAll
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) { CourtRelatedDAO.deleteById(id);}

}
