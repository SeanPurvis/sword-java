package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


import edu.usm.sosw.sword.api.Case;


/**
 * This CaseMapper maps SQL query results to a Case object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Case Object
 * @return a new <code>Case</code> object with SQL Query results populated into the data members.
 * @see Case 
 * @see CaseDAO
 */
public class CaseMapper implements ResultSetMapper<Case>{
	public Case map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Case(
				r.getString("did"),
				r.getInt("id"),
				r.getInt("youthid"),
				r.getString("lastname"),
				r.getString("firstname"),
				r.getString("middlename"),
				r.getString("suffix"),
				r.getString("alias_monikers"),
				r.getString("street"),
				r.getString("city"),
				r.getString("county"),
				r.getString("state"),
				r.getString("zip"),
				r.getString("home_phone"),
				r.getString("length_of_residence_in_county"),
				r.getString("location_of_residence"),
				r.getInt("height_feet"),
				r.getInt("height_inch"),
				r.getString("weight"),
				r.getString("eye_color"),
				r.getString("hair_color"),
				r.getString("scars"),
				r.getString("religion"),
				r.getString("emp_status"),
				r.getString("emp_where"),
				r.getString("immediate_needs"),
				r.getString("living_arrangements"),
				r.getString("school_attended_last"),
				r.getString("school_attended_city"),
				r.getString("school_attended_state"),
				r.getString("school_attended_zip"),
				r.getString("current_grade"),
				r.getString("special_ed"),
				r.getString("school_attendance"),
				r.getString("school_placement"),
				r.getInt("years_school_completed"),
				r.getDate("input_date"),
				r.getString("input_user"),
				r.getString("protection_case"),
				r.getDate("modified_date"),
				r.getString("cell_phone"),
				r.getString("isclosed"),
				r.getString("closing_reason"),
				r.getDate("closing_date"),
				r.getString("disability"));
	}
}
