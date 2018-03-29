package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.MyUser;

/**
 * This UserMapper maps SQL query results to a User object. 
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * @type User Object
 * @return a new <code>User</code> object with SQL Query results populated into the data members.
 * @see User 
 * @see UserDAO
 */
public class UserMapper implements ResultSetMapper<MyUser> {
	public MyUser map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyUser(r.getBigDecimal("id"), r.getString("username"), r.getString("name"),
				r.getString("phone"),r.getString("password"), r.getString("employer"), r.getString("role"),
				r.getString("email"));
	}
}
