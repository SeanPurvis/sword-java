package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Jailer;


/**
 * This JailerMapper maps SQL query results to a Jailer object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Jailer</code> object with SQL Query results populated into the data members.
 * @see Jailer 
 * @see JailerDAO
 */

public class JailerMapper implements ResultSetMapper<Jailer>{
	public Jailer map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Jailer(
			r.getInt("id"),
			r.getString("code"),
			r.getString("name"),
			r.getInt("status"));
	}
}
