package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Youth;

/**
 * This YouthMapper maps SQL query results to a Youth object.
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * @type Youth Object
 * @return a new <code>Youth</code> object with SQL Query results populated into the data members.
 * @see Youth 
 * @see YouthDAO
 */
public class YouthMapper implements ResultSetMapper<Youth>{
	public Youth map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Youth(r.getInt("id"), r.getString("ssn"), r.getString("race"), r.getString("gender"),
				r.getDate("dob"), r.getString("birthcity"), r.getString("birthstate"), r.getString("isadult"),
				r.getString("immediate_medical"));
	}
}
