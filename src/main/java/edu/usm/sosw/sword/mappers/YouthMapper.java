package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Youth;

public class YouthMapper implements ResultSetMapper<Youth>{
	public Youth map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Youth(r.getInt("id"), r.getString("ssn"), r.getString("race"), r.getString("gender"),
				r.getDate("dob"), r.getString("birthcity"), r.getString("birthstate"), r.getString("isadult"),
				r.getString("immediate_medical"));
	}
}
