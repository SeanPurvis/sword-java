package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Jail;


/**
 * This JailMapper maps SQL query results to a Jail object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Jail</code> object with SQL Query results populated into the data members.
 * @see Jail 
 * @see JailDAO
 */

public class JailMapper implements ResultSetMapper<Jail>{
	public Jail map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Jail(
				r.getInt("id"),
				r.getString("name"),
				r.getString("unit"),
				r.getString("cells"));
	}
}
