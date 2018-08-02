package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Medication;


/**
 * This MedicationMapper maps SQL query results to a Medication object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Medication</code> object with SQL Query results populated into the data members.
 * @see Medication 
 * @see MedicationDAO
 */

public class MedicationMapper implements ResultSetMapper<Medication>{
	public Medication map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Medication(
				r.getInt("med_id"),
				r.getString("medication"),
				r.getString("floor_stock"));
	}
}