package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.MyUser;

/**
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 *
 * This UserMapper provides the functionality to map SQL query results to a User object. 
 * 
 */
public class UserMapper implements ResultSetMapper<MyUser> {
	public MyUser map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyUser(r.getBigDecimal("id"), r.getString("username"), r.getString("name"), r.getString("phone"),
				r.getString("password"), r.getString("employer"), r.getString("role"), r.getString("email"));
	}
}
