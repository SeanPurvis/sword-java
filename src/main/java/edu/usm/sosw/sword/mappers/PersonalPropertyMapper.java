package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.PersonalProperty;


/**
 * This PersonalPropertyMapper maps SQL query results to a PersonalProperty object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>PersonalProperty</code> object with SQL Query results populated into the data members.
 * @see PersonalProperty 
 * @see PersonalPropertyDAO
 */

public class PersonalPropertyMapper implements ResultSetMapper<PersonalProperty>{
	public PersonalProperty map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new PersonalProperty(
				r.getInt("caseid"),
				r.getInt("id"),
				r.getInt("locker_number"),
				r.getString("currency"),
				r.getString("belt"),
				r.getString("bra"),
				r.getString("dress"),
				r.getString("hat"),
				r.getString("jacket"),
				r.getString("leggings"),
				r.getString("pants"),
				r.getString("shirt"),
				r.getString("shoes"),
				r.getString("shorts"),
				r.getString("skirt"),
				r.getString("socks"),
				r.getString("underwear"),
				r.getString("bracelet"),
				r.getString("earrings"),
				r.getString("necklace"),
				r.getString("ring"),
				r.getString("watch"),
				r.getString("drugs"),
				r.getString("lighter"),
				r.getString("other_drugs"),
				r.getString("tobacco"),
				r.getString("weapons"),
				r.getString("other_property"),
				r.getDate("release_date"),
				r.getString("release_to"));
	}
}
