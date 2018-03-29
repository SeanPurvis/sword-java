package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Counselor;
import edu.usm.sosw.sword.api.Counselor;

/**
 * This CounselorMapper maps SQL query results to a Counselor object.
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Counselor</code> object with SQL Query results populated into the data members.
 * @see Counselor 
 * @see CounselorDAO
 */
public class CounselorMapper implements ResultSetMapper<Counselor> {
	public Counselor map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Counselor(r.getInt("id"), r.getString("name"), r.getString("email"), r.getInt("status")); 
	}
}
