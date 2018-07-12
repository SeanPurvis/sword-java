package edu.usm.sosw.sword.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import edu.usm.sosw.sword.db.CaseNoteDAO;
import edu.usm.sosw.sword.api.CaseNote;

@Path("/api/v1/casenote")
@Produces(MediaType.APPLICATION_JSON)
public class CaseNoteResource {
	CaseNoteDAO CaseNoteDAO;
	
	public CaseNoteResource(CaseNoteDAO CaseNoteDAO) {
		this.CaseNoteDAO = CaseNoteDAO;
		this.CaseNoteDAO.createCaseNoteTable();
	}
	
	@GET
	public List<CaseNote> getAll() { return CaseNoteDAO.getAll(); }
	
	@GET
	@Path("/id/{id}")
	public CaseNote getId(@PathParam("id") Integer id) { return CaseNoteDAO.findById(id); }
	
	@GET
	@Path("/youthid/{id}")
	public CaseNote getYouthId(@PathParam("youthid") Integer youthid) { return CaseNoteDAO.findByYouthId(youthid); }
	
	@GET
	@Path("/caseid/{id}")
	public CaseNote getCaseId(@PathParam("caseid") Integer caseid) { return CaseNoteDAO.findByCaseId(caseid); }
	
	@GET
	@Path("/note_id/{id}")
	public CaseNote getNoteId(@PathParam("note_id") Integer note_id) { return CaseNoteDAO.findByNoteId(note_id); }
	
	@POST
	public int add(@Valid CaseNote CaseNote) { return CaseNoteDAO.insert(CaseNote); }
	
	@PUT
	@Path("/id/{id}")
	public void update(@Valid CaseNote CaseNote) { CaseNoteDAO.update(CaseNote); }
	
	@DELETE
	@Path("/id/{id}")
	public void delete(@PathParam("id") Integer id) { CaseNoteDAO.deleteById(id); }
}
