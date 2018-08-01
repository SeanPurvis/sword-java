package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.MedicalStaff;


/**
 * This MedicalStaffMapper maps SQL query results to a MedicalStaff object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>MedicalStaff</code> object with SQL Query results populated into the data members.
 * @see MedicalStaff 
 * @see MedicalStaffDAO
 */

public class MedicalStaffMapper implements ResultSetMapper<MedicalStaff>{
	public MedicalStaff map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MedicalStaff(
				r.getInt("med_emp_id"),
				r.getString("name"),
				r.getInt("visitation_fee"));
	}
}
