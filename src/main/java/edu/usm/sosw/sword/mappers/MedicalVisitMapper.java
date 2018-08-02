package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.MedicalVisit;


/**
 * This MedicalVisitMapper maps SQL query results to a MedicalVisit object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>MedicalVisit</code> object with SQL Query results populated into the data members.
 * @see MedicalVisit 
 * @see MedicalVisitDAO
 */

public class MedicalVisitMapper implements ResultSetMapper<MedicalVisit>{
	public MedicalVisit map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MedicalVisit(
				r.getInt("medical_visit_id"),
				r.getInt("youthid"),
				r.getDate("visit_date"),
				r.getString("medical_staff"),
				r.getString("complaint"),
				r.getString("diagnosis"),
				r.getString("outside_treatment"),
				r.getDouble("outside_treatment_fee"),
				r.getString("secondary_outside_treatment"),
				r.getDouble("secondary_outside_treatment_fee"),
				r.getDouble("transport_cost"),
				r.getString("ordering_county"));
	}
}
