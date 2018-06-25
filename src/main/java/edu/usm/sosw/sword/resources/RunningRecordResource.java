package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.validation.Valid;

import edu.usm.sosw.sword.api.RunningRecord;
import edu.usm.sosw.sword.db.RunningRecordDAO;

/**
 * The <code>RunningRecord</code> class provides a JSON REST API end point for RunningRecord
 * objects and the <code>RunningRecords</code> table
 *
 * The resource class is exposed by registering it within the run function of the SwordApplication
 * class
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 *
 * @see RunningRecord
 * @see RunningRecordDAO
 *
 */
@Path("/api/v1/runningrecord")
@Produces(MediaType.APPLICATION_JSON)
public class RunningRecordResource {

	// Database interface instance
	RunningRecordDAO RunningRecordDAO;

	public RunningRecordResource(RunningRecordDAO RunningRecordDAO) {
		this.RunningRecordDAO = RunningRecordDAO;
		this.RunningRecordDAO.createRunningRecordTable();
	}

	@GET
	public List<RunningRecord> getAll() {
		return RunningRecordDAO.getAll();
	}

	@GET
	@Path("/{id}")
	public RunningRecord get(@PathParam("id") Integer id) {
		return RunningRecordDAO.findById(id);
	}

	@POST
	public int add(@Valid RunningRecord RunningRecord) {
		return RunningRecordDAO.insert(RunningRecord);
	}
     
    @PUT
    @Path("/{id}")
    public void update(@Valid RunningRecord RunningRecord) {
        RunningRecordDAO.update(RunningRecord);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        RunningRecordDAO.findById(id);
    }
}

