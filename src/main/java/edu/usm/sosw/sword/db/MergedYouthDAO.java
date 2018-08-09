package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.MergedYouth;
import edu.usm.sosw.sword.mappers.MergedYouthMapper;
import edu.usm.sosw.sword.resources.MergedYouthResource;

/** 
 * This interface exists to provide proper access to the <code>MergedYouth</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>MergedYouthDAO</code> interface is used by the <code>MergedYouthResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>MergedYouthMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>MergedYouth Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see MergedYouth 
 * @see MergedYouthMapper 
 * @see MergedYouthResource
 */
@RegisterMapper(MergedYouthMapper.class)
public interface MergedYouthDAO {

	@SqlUpdate("CREATE TABLE IF NOT EXISTS `merged_youths` (\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `edited_table` varchar(45) NOT NULL,\n" + 
			"  `table_id` int(11) NOT NULL,\n" + 
			"  `old_youthid` int(11) NOT NULL,\n" + 
			"  `new_youthid` int(11) NOT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=1350 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createMergedYouthTable();
	
	@SqlQuery("select * from merged_youths")
	List<MergedYouth> getAll();
	
	@SqlQuery("select * from merged_youths where id = :id")
	MergedYouth findById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from merged_youths where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("UPDATE `sword-test`.`merged_youths`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`edited_table` = <{edited_table: }>,\n" + 
			"`table_id` = <{table_id: }>,\n" + 
			"`old_youthid` = <{old_youthid: }>,\n" + 
			"`new_youthid` = <{new_youthid: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean MergedYouth MergedYouth);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`merged_youths`\n" + 
			"(`id`,\n" + 
			"`edited_table`,\n" + 
			"`table_id`,\n" + 
			"`old_youthid`,\n" + 
			"`new_youthid`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{edited_table: }>,\n" + 
			"<{table_id: }>,\n" + 
			"<{old_youthid: }>,\n" + 
			"<{new_youthid: }>);\n" + 
			"")
	int insert(@BindBean MergedYouth MergedYouth);
	
	void close();
}
