package edu.usm.sosw.sword.mappers;

import edu.usm.sosw.sword.api.RunningRecord;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This RunningRecordMapper maps SQL query results to a RunningRecord object.
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 * @type RunningRecord Object
 * @return a new <code>RunningRecord</code> object with SQL query results populated into the data members.
 * @see RunningRecord
 * @see RunningRecordDAO
 */
public class RunningRecordMapper implements ResultSetMapper<RunningRecord> {
    public RunningRecord map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new RunningRecord(r.getString("did"), r.getInt("youthid"), r.getInt("id"), r.getInt("noteid"),
               r.getInt("notepartid"), r.getString("note"));
    }
}
