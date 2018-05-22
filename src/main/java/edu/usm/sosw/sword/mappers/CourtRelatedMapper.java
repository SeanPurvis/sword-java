package edu.usm.sosw.sword.mappers;

import edu.usm.sosw.sword.api.CourtRelated;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This CourtRelatedMapper maps SQL query results to a CourtRelated object.
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 * @type CourtRelated Object
 * @return a new <code>CourtRelated</code> object with SQL Query results populated into the data members.
 * @see edu.usm.sosw.sword.api.CourtRelated
 */
public class CourtRelatedMapper implements ResultSetMapper<CourtRelated> {
    public CourtRelated map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new CourtRelated(r.getInt("id"), r.getString("category"), r.getString("description"));
    }
}
