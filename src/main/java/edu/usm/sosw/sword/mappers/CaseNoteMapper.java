package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.CaseNote;

public class CaseNoteMapper implements ResultSetMapper<CaseNote> {
	public CaseNote map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CaseNote(r.getInt("id"), r.getInt("youthid"), r.getInt("caseid"), r.getInt("note_id"), r.getString("note"),
				r.getDate("input_date"), r.getString("input_user"));
	}
}