package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.MergedYouth;


/**
 * This MergedYouthMapper maps SQL query results to a MergedYouth object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>MergedYouth</code> object with SQL Query results populated into the data members.
 * @see MergedYouth 
 * @see MergedYouthDAO
 */

public class MergedYouthMapper implements ResultSetMapper<MergedYouth>{
	public MergedYouth map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MergedYouth(
			r.getInt("id"),
			r.getString("edited_table"),
			r.getInt("table_id"),
			r.getInt("old_youthid"),
			r.getInt("new_youthid"));
	}
}
