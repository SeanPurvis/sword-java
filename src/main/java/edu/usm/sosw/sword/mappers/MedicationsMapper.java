package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Medications;


/**
 * This MedicationsMapper maps SQL query results to a Medications object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Medications</code> object with SQL Query results populated into the data members.
 * @see Medications 
 * @see MedicationsDAO
 */

public class MedicationsMapper implements ResultSetMapper<Medications>{
	public Medications map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Medications(
				r.getInt("id"),
				r.getInt("youthid"),
				r.getDate("request_date"),
				r.getString("medication"),
				r.getString("frequency"),
				r.getInt("quantity"),
				r.getString("dosage"),
				r.getBigDecimal("cost"),
				r.getDate("start_date"),
				r.getDate("end_date"),
				r.getString("ordering_county"));
	}
}
