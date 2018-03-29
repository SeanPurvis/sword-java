package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.County;

public class CountyMapper implements ResultSetMapper<County> {
	public County map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new County(r.getInt("id"), r.getString("name"));
	}
}
