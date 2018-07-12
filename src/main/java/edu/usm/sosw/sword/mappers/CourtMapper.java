package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Court;

/**
 * This CourtMapper maps SQL query results to an Court object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Court Object
 * @return a new <code>Court</code> object with SQL Query results populated into the data members.
 * @see Court 
 * @see CourtDAO
 */
public class CourtMapper implements ResultSetMapper<Court>{
	public Court map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Court(
				r.getInt("id"),
				r.getInt("caseid"),
				r.getString("attorney_childs"),
				r.getDate("attorney_childs_appointed_date"),
				r.getString("attorney_fathers"),
				r.getString("attorney_mothers"),
				r.getDate("case_appointed_date"),
				r.getString("court_summary"),
				r.getString("court_type"),
				r.getDate("formal_petition_filed_date"),
				r.getDate("formal_petition_ordered_data"),
				r.getInt("formal_petition_code"),
				r.getDate("gal_appointed_date"),
				r.getString("gal_bar_number"),
				r.getDate("hearing_date"),
				r.getString("hearing_type"),
				r.getDate("informal_adjustment_ordered_date"),
				r.getString("judge"),
				r.getString("mdhs_name"),
				r.getString("mdhs_reccomendation"),
				r.getDate("motion_entered_date"),
				r.getDate("next_hearing_date"),
				r.getString("no_show"),
				r.getInt("number_of_continuances_granted"),
				r.getString("plan_concurrent"),
				r.getString("plan_permanent"),
				r.getString("subpoenaed_names"),
				r.getDate("summons_issued_on_child_date"),
				r.getDate("summons_served_on_child_date"),
				r.getDate("take_no_action_ordered_date"),
				r.getString("waived"),
				r.getString("witnesses"),
				r.getString("zero_to_three_program"));	
	}
}
