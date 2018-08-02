package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.ChargeList;

public class ChargeListMapper implements ResultSetMapper<ChargeList> {
	public ChargeList map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ChargeList(r.getInt("id"), r.getString("category"),
				r.getString("description"), r.getString("statute"), r.getString("type"),
				r.getInt("risk_assessment_value"), r.getString("petition_name"),
				r.getString("petition_child_declaration"), r.getString("petition_crime_desc_template"));
	}
}
