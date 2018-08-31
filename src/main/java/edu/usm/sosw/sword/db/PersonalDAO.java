package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Personal;
import edu.usm.sosw.sword.mappers.PersonalMapper;
import edu.usm.sosw.sword.resources.PersonalResource;

/** 
 * This interface exists to provide proper access to the <code>Personal</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>PersonalDAO</code> interface is used by the <code>PersonalResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>PersonalMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Personal Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Personal 
 * @see PersonalMapper 
 * @see PersonalResource
 */
@RegisterMapper(PersonalMapper.class)
public interface PersonalDAO {

	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_personal` (\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `category` varchar(45) NOT NULL DEFAULT '',\n" + 
			"  `description` varchar(100) NOT NULL DEFAULT '',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createPersonalTable();
	
	@SqlQuery("select * from static_personal")
	List<Personal> getAll();
	
	@SqlQuery("select * from static_personal where id = :id")
	Personal findById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from static_personal where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("UPDATE `sword-test`.`static_personal`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`category` = <{category: }>,\n" + 
			"`description` = <{description: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Personal Personal);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`static_personal`\n" + 
			"(`id`,\n" + 
			"`category`,\n" + 
			"`description`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{category: }>,\n" + 
			"<{description: }>);\n" + 
			"")
	int insert(@BindBean Personal Personal);
	
	void close();
}
