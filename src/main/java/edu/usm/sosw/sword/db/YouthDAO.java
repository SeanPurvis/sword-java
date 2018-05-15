package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Youth;
import edu.usm.sosw.sword.mappers.YouthMapper;

/** 
 * This interface exists to provide proper access to the <code>youths</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>YouthDAO</code> interface is used by the <code>YouthResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>YouthMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Youth Object.</code>
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @see Youth 
 * @see YouthMapper
 */
@RegisterMapper(YouthMapper.class)
public interface YouthDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `youths` (\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `ssn` varchar(15) DEFAULT ' ',\n" + 
			"  `race` varchar(100) DEFAULT '0',\n" + 
			"  `gender` varchar(100) DEFAULT '0',\n" + 
			"  `dob` date DEFAULT NULL,\n" + 
			"  `birthcity` varchar(100) DEFAULT '',\n" + 
			"  `birthstate` varchar(100) DEFAULT '',\n" + 
			"  `isadult` varchar(3) DEFAULT 'No',\n" + 
			"  `certified` varchar(3) DEFAULT 'No',\n" + 
			"  `immediate_medical` varchar(5) DEFAULT 'No',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=144634565 DEFAULT CHARSET=latin1;\n" + 
			"")
	public void createYouthTable();
	
	@SqlQuery("select * from youths")
	public List<Youth> getAll();
	
	@SqlQuery("select * from youths where id = :id")
	public Youth findById(@Bind("id") int id);
	
	@SqlQuery("select * from youths where ssn = :ssn")
	public Youth findBySSN(@Bind("ssn") String ssn);
	
	@SqlUpdate("delete from youths where id = :id")
	public void deleteById(@Bind("id") int id);
	
	@SqlUpdate("update youths set"
			+ "ssn = :ssn,"
			+ "race = :race,"
			+ "gender = :gender,"
			+ "dob = :dob,"
			+ "birthcity = :birthcity,"
			+ "birthstate = :birthstate,"
			+ "isadult = :isadult,"
			+ "certified = :certified,"
			+ "immediate_medical = :immediate_medical,"
			+ "where id = :id")
	public void update(@BindBean Youth Youth);
	
	@GetGeneratedKeys // Allows us to return the auto generated id to our client
	@SqlUpdate("insert into youths (ssn, race, gender, dob, birthcity, birthstate, isadult, certified, immediate_medical)"
			+ " values (:ssn, :race, :gender, :dob, :birthcity, :birthstate, :isadult, :certified, :immediate_medical)")
	public int insert(@BindBean Youth Youth);
	
	public void close();
	
	
}
