package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Jail;
import edu.usm.sosw.sword.mappers.JailMapper;
import edu.usm.sosw.sword.resources.JailResource;

/** 
 * This interface exists to provide proper access to the <code>Jail</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>JailDAO</code> interface is used by the <code>JailResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>JailMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Jail Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Jail 
 * @see JailMapper 
 * @see JailResource
 */
@RegisterMapper(JailMapper.class)
public interface JailDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS`static_jails` (\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `name` varchar(100) DEFAULT '',\n" + 
			"  `unit` varchar(45) DEFAULT '',\n" + 
			"  `cells` varchar(45) DEFAULT '',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createJailTable();
	
	@SqlQuery("select * from static_jails")
	List<Jail> getAll();
	
	@SqlQuery("select * from static_jails where id = :id")
	Jail findById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from static_jails where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("UPDATE `sword-test`.`static_jails`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`name` = <{name: }>,\n" + 
			"`unit` = <{unit: }>,\n" + 
			"`cells` = <{cells: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Jail Jail);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`static_jails`\n" + 
			"(`id`,\n" + 
			"`name`,\n" + 
			"`unit`,\n" + 
			"`cells`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{name: }>,\n" + 
			"<{unit: }>,\n" + 
			"<{cells: }>);\n" + 
			"")
	int insert(@BindBean Jail Jail);
	
	void close();
}
