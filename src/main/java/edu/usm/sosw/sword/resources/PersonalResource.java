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

import edu.usm.sosw.sword.api.Personal;
import edu.usm.sosw.sword.db.PersonalDAO;

/**
 * The <code>Personal</code> class provides a JSON REST API end point for Personal objects and the <code>Personal</code> table.
 *
 * Currently, only path parameters are implemented but QueryParameters should be implemented in the future. 
 * The resource class is exposed by registering it within the SwordApplication run function.
 *
 * @author Jonathon Evans
 * @version 0.0.1
 *
 * @see Personal
 * @see PersonalDAO
 */
@Path("/api/v1/personal")
@Produces(MediaType.APPLICATION_JSON)
public class PersonalResource {
    // Our database interface instance.
    PersonalDAO PersonalDAO;

    public PersonalResource(PersonalDAO PersonalDAO) {
        this.PersonalDAO = PersonalDAO;
        this.PersonalDAO.createPersonalTable();
    }

    @GET
    public List<Personal> getAll(){
        return PersonalDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public Personal get(@PathParam("id") Integer id) {
        return PersonalDAO.findById(id);
    }

    @POST
    public int add(@Valid Personal Personal) {
        return PersonalDAO.insert(Personal);
    }

    @PUT
    @Path("/{id}")
    public void update(@Valid Personal Personal) {
        PersonalDAO.updateById(Personal);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        PersonalDAO.deleteById(id);
    }
}
