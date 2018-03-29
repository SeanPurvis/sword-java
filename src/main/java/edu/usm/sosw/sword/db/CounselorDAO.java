package edu.usm.sosw.sword.db;

import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.mappers.CounselorMapper;

/** 
 * This interface exists to provide proper access to the <code>counselors</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>CounselorDAO</code> interface is used by the <code>CounselorResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>CounselorMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Counselor Object.</code>
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @see Counselor 
 * @see CounselorMapper 
 * @see CounselorResource
 */
@RegisterMapper(CounselorMapper.class)
public interface CounselorDAO {
	
}
