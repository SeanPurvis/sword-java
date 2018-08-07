package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.ReferringAgency;

/**
 * This ReferringAgencyMapper maps SQL query results to a ReferringAgency object.
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @return a new <code>ReferringAgency</code> object with SQL Query results populated into the data members.
 * @see ReferringAgency 
 * @see ReferringAgencyDAO
 */
public class ReferringAgencyMapper implements ResultSetMapper<ReferringAgency> {
	public ReferringAgency map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ReferringAgency(
				r.getInt("id"),
				r.getString("category"),
				r.getString("agency_name"));
	}
}
