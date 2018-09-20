package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Custody;

/**
 * This CustodyMapper maps SQL query results to a Custody object. 
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 * @type Custody Object
 * @return a new <code>Custody</code> object with SQL Query results populated into the data members.
 * @see Custody
 * @see CustodyDAO
 */
public class CustodyMapper implements ResultSetMapper<Custody> {
    public Custody map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Custody(r.getInt("caseid"), r.getInt("id"), r.getDate("date_changed"), r.getString("changed_to"));
    }
}
