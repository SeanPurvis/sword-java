package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.OutsideTreatment;


/**
 * This OutsideTreatmentMapper maps SQL query results to a OutsideTreatment object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>OutsideTreatment</code> object with SQL Query results populated into the data members.
 * @see OutsideTreatment 
 * @see OutsideTreatmentDAO
 */

public class OutsideTreatmentMapper implements ResultSetMapper<OutsideTreatment>{
	public OutsideTreatment map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new OutsideTreatment(
				r.getInt("outside_treatment_id"),
				r.getString("outside_source"));
	}
}
