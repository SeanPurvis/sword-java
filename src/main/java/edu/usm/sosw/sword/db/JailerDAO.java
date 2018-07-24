package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Jailer;
import edu.usm.sosw.sword.mappers.JailerMapper;
import edu.usm.sosw.sword.resources.JailerResource;

/** 
 * This interface exists to provide proper access to the <code>Jailer</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>JailerDAO</code> interface is used by the <code>JailerResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>JailerMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Jailer Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Jailer 
 * @see JailerMapper 
 * @see JailerResource
 */
@RegisterMapper(JailerMapper.class)
public interface JailerDAO {

	@SqlUpdate("CREATE TABLE IF NOT EXISTS`static_jailers` (\n" + 
			"  `id` int(4) NOT NULL AUTO_INCREMENT,\n" + 
			"  `code` varchar(20) DEFAULT NULL,\n" + 
			"  `name` varchar(100) DEFAULT NULL,\n" + 
			"  `status` int(3) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createJailerTable();
	
	@SqlQuery("select * from static_jailers")
	List<Jailer> getAll();
	
	@SqlQuery("select * from static_jailers where id = :id")
	Jailer findById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from static_jailers where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("UPDATE `sword-test`.`static_jailers`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`code` = <{code: }>,\n" + 
			"`name` = <{name: }>,\n" + 
			"`status` = <{status: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Jailer Jailer);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`static_jailers`\n" + 
			"(`id`,\n" + 
			"`code`,\n" + 
			"`name`,\n" + 
			"`status`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{code: }>,\n" + 
			"<{name: }>,\n" + 
			"<{status: }>);\n" + 
			"")
	int insert(@BindBean Jailer Jailer);
	
	void close();
}
