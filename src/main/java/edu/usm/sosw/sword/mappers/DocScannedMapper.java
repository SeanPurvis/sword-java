package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.DocScanned;


/**
 * This DocScannedMapper maps SQL query results to a DocScanned object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>DocScanned</code> object with SQL Query results populated into the data members.
 * @see DocScanned 
 * @see DocScannedDAO
 */

public class DocScannedMapper implements ResultSetMapper<DocScanned>{
	public DocScanned map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new DocScanned(
				r.getInt("caseid"),
				r.getInt("id"),
				r.getString("doc_name"),
				r.getBlob("text"),
				r.getDate("order_date"));
	}
}