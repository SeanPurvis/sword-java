package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


import edu.usm.sosw.sword.api.DcCharges;


/**
 * This DcChargesMapper maps SQL query results to a DcCharges object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>DcCharges</code> object with SQL Query results populated into the data members.
 * @see DcCharges 
 * @see DcChargesDAO
 */

public class DcChargesMapper implements ResultSetMapper<DcCharges>{
	public DcCharges map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new DcCharges(
				r.getInt("caseid"),
				r.getInt("id"),
				r.getString("statute"),
				r.getString("sqlclass"),
				r.getString("offense_desc"),
				r.getInt("book"),
				r.getInt("page"),
				r.getInt("line"),
				r.getDate("offense_date"));
	}
}