package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Charge;

/**
 * This ChargeMapper maps SQL query results to an Charge object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Charge Object
 * @return a new <code>Charge</code> object with SQL Query results populated into the data members.
 * @see Charge 
 * @see ChargeDAO
 */
public class ChargeMapper implements ResultSetMapper<Charge>{
	public Charge map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Charge(
				r.getInt("caseid"),
				r.getInt("id"),
				r.getString("docket_number"),
				r.getString("statute"),
				r.getString("class"),
				r.getInt("risk_assesment_value"),
				r.getString("offense_desc"),
				r.getDate("date_offense_occured"),
				r.getInt("docket_year"),
				r.getInt("docket_intake"),
				r.getDate("input_date"));
	}
}
