package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.User;

public class UserMapper implements ResultSetMapper<User> {
	public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new User(r.getInt("id"), r.getString("username"), r.getString("name"), r.getString("phone"),
				r.getString("password"), r.getString("employer"), r.getString("role"), r.getString("email"));
	}
}
