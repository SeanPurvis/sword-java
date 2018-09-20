package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Case;
import edu.usm.sosw.sword.api.CaseNote;

/**
 * This CaseNoteMapper maps SQL query results to a CaseNote object.
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @type CaseNote Object
 * @return a new <code>CaseNote</code> object with SQL Query results populated into the data members.
 * @see CaseNote 
 * @see CaseNoteDAO
 */
public class CaseNoteMapper implements ResultSetMapper<CaseNote> {
	public CaseNote map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CaseNote(r.getInt("id"), r.getInt("youthid"), r.getInt("caseid"), r.getInt("note_id"), r.getString("note"),
				r.getDate("input_date"), r.getString("input_user"));
	}
}