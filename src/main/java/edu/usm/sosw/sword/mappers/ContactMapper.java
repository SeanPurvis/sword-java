package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Contact;

/**
 * This ContactMapper maps SQL query results to an Contact object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Contact Object
 * @return a new <code>Contact</code> object with SQL Query results populated into the data members.
 * @see Contact 
 * @see ContactDAO
 */
public class ContactMapper implements ResultSetMapper<Contact>{
	public Contact map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Contact(
				r.getInt("id"),
				r.getInt("caseid"),
				r.getString("relationship"),
				r.getString("previous_court"),
				r.getString("lastname"),
				r.getString("firstname"),
				r.getString("middlename"),
				r.getString("suffix"),
				r.getString("is_guardian"),
				r.getString("is_same_address"),
				r.getString("street"),
				r.getString("city"),
				r.getString("state"),
				r.getString("zip"),
				r.getString("home_phone"),
				r.getString("cell_phone"),
				r.getString("race"),
				r.getString("gender"),
				r.getString("ssn"),
				r.getDate("dob"),
				r.getString("marital_status"),
				r.getString("education"),
				r.getString("occupation"),
				r.getString("employer"),
				r.getString("work_phone"),
				r.getString("receive_assistance"),
				r.getString("insurance"),
				r.getString("insurance_policy"));
	}
}
