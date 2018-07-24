package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Drugscreen;


/**
 * This DrugscreenMapper maps SQL query results to a Drugscreen object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Drugscreen</code> object with SQL Query results populated into the data members.
 * @see Drugscreen 
 * @see DrugscreenDAO
 */

public class DrugscreenMapper implements ResultSetMapper<Drugscreen>{
	public Drugscreen map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Drugscreen(
				r.getInt("youthid"),
				r.getInt("id"),
				r.getDate("testdate"),
				r.getString("benzodiazepine"),
				r.getString("crystal_methamphetamine"),
				r.getString("amphetamines"),
				r.getString("thc"),
				r.getString("coke"),
				r.getString("opiates"));
	}
}
