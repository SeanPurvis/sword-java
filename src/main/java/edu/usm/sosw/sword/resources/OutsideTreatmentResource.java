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

import edu.usm.sosw.sword.api.OutsideTreatment;
import edu.usm.sosw.sword.db.OutsideTreatmentDAO;

/**
 * The <code>OutsideTreatment</code> class provides a JSON REST API end point for OutsideTreatment objects and the <code>OutsideTreatment</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 *
 * @see OutsideTreatment
 * @see OutsideTreatmentDAO
 */
@Path("/api/v1/static_outside_treatment")
@Produces(MediaType.APPLICATION_JSON)
public class OutsideTreatmentResource {
    // Our database interface instance.
    OutsideTreatmentDAO OutsideTreatmentDAO;

    public OutsideTreatmentResource(OutsideTreatmentDAO OutsideTreatmentDAO) {
        this.OutsideTreatmentDAO = OutsideTreatmentDAO;
        this.OutsideTreatmentDAO.createOutsideTreatmentTable();
    }

    @GET
    public List<OutsideTreatment> getAll(){
        return OutsideTreatmentDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public OutsideTreatment get(@PathParam("outside_treatment_id") Integer outside_treatment_id) {
        return OutsideTreatmentDAO.findById(outside_treatment_id);
    }

    @POST
    public int add(@Valid OutsideTreatment OutsideTreatment) {
        return OutsideTreatmentDAO.insert(OutsideTreatment);
    }

    @PUT
    @Path("/{id}")
    public void update(@Valid OutsideTreatment OutsideTreatment) {
        OutsideTreatmentDAO.updateById(OutsideTreatment);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("outside_treatment_id") Integer outside_treatment_id) {
        OutsideTreatmentDAO.deleteById(outside_treatment_id);
    }
}
