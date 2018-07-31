package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Medical;


/**
 * This MedicalMapper maps SQL query results to a Medical object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Medical</code> object with SQL Query results populated into the data members.
 * @see Medical 
 * @see MedicalDAO
 */

public class MedicalMapper implements ResultSetMapper<Medical>{
	public Medical map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Medical(
				r.getInt("caseid"),
				r.getInt("id"),
				r.getString("immediate_medical_needs"),
				r.getString("immediate_phych_needs"),
				r.getString("current_medications"),
				r.getString("medical_insurance"),
				r.getString("agency1"),
				r.getString("benefits1"),
				r.getString("agency2"),
				r.getString("benefits2"),
				r.getString("agency3"),
				r.getString("benefits3"));
	}
}