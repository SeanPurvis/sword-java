package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Documents;


/**
 * This DocumentsMapper maps SQL query results to a Documents object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Counselor Object
 * @return a new <code>Documents</code> object with SQL Query results populated into the data members.
 * @see Documents 
 * @see DocumentsDAO
 */

public class DocumentsMapper implements ResultSetMapper<Documents>{
	public Documents map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Documents(
				r.getInt("chargeid"),
				r.getInt("id"),
				r.getString("doc_name"),
				r.getBlob("text"),
				r.getDate("order_date"));
	}
}
