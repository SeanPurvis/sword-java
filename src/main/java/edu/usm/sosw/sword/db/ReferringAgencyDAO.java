package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.ReferringAgency;
import edu.usm.sosw.sword.mappers.ReferringAgencyMapper;

/** 
 * This interface exists to provide proper access to the <code>action</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>ReferringAgencyDAO</code> interface is used by the <code>ReferringAgencyResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>ReferringAgencyMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>ReferringAgency Object.</code>
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @see ReferringAgency 
 * @see ReferringAgencyMapper 
 * @see ReferringAgencyResource
 */
@RegisterMapper(ReferringAgencyMapper.class)
public interface ReferringAgencyDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_referring_agencies` (\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `category` varchar(45) DEFAULT '',\n" + 
			"  `agency_name` varchar(100) DEFAULT '',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=MyISAM AUTO_INCREMENT=135 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createReferringAgencyTable();
	
	@SqlQuery("select * from static_referring_agencies")
	List<ReferringAgency> getAll();
	
	@SqlQuery("select * from static_referring_agencies where id = :id")
	ReferringAgency findById(@Bind("id") int id);
	
	@SqlUpdate("delete from static_referring_agencies where id = :id")
	void deleteById(@Bind("id") int id);
	
	@SqlUpdate("UPDATE `sword-test`.`static_referring_agencies`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`category` = <{category: }>,\n" + 
			"`agency_name` = <{agency_name: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean ReferringAgency ReferringAgency);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`static_referring_agencies`\n" + 
			"(`id`,\n" + 
			"`category`,\n" + 
			"`agency_name`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{category: }>,\n" + 
			"<{agency_name: }>);\n" + 
			"")
	int insert(@BindBean ReferringAgency ReferringAgency);
	
	void close();
}
