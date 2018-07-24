package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.DcIncidents;


/**
 * This DcIncidentsMapper maps SQL query results to a DcIncidents object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>DcIncidents</code> object with SQL Query results populated into the data members.
 * @see DcIncidents 
 * @see DcIncidentsDAO
 */

public class DcIncidentsMapper implements ResultSetMapper<DcIncidents>{
	public DcIncidents map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new DcIncidents(
				r.getInt("caseid"),
				r.getInt("id"),
				r.getDate("doa"),
				r.getString("doa_time"),
				r.getString("cell"),
				r.getString("booking_officer"),
				r.getString("arresting_officer"),
				r.getString("arresting_agency"),
				r.getString("attorney"),
				r.getString("docket"),
				r.getString("hold_for"),
				r.getString("hold_released_by"),
				r.getDate("hold_released_date"),
				r.getString("intake_notes"),
				r.getDate("releasing_date"),
				r.getString("releasing_time"),
				r.getString("releasing_officer"),
				r.getString("releasing_how"),
				r.getString("releasing_authority"),
				r.getString("releasing_to"),
				r.getString("ordering_county"));
	}
}
