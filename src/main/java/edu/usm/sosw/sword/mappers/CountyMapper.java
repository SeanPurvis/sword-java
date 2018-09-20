package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.County;

/**
 * This CountyMapper maps SQL query results to a County object. 
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * @type County Object
 * @return a new <code>County</code> object with SQL Query results populated into the data members.
 * @see County
 * @see CountyDAO
 */
public class CountyMapper implements ResultSetMapper<County> {
	public County map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new County(r.getInt("id"), r.getString("name"));
	}
}
