package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Personal;


/**
 * This PersonalMapper maps SQL query results to a Personal object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Personal</code> object with SQL Query results populated into the data members.
 * @see Personal 
 * @see PersonalDAO
 */

public class PersonalMapper implements ResultSetMapper<Personal>{
	public Personal map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Personal(
				r.getInt("id"),
				r.getString("category"),
				r.getString("description"));
	}
}
