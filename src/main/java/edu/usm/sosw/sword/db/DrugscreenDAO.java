package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Drugscreen;
import edu.usm.sosw.sword.mappers.DrugscreenMapper;
import edu.usm.sosw.sword.resources.DrugscreenResource;

/** 
 * This interface exists to provide proper access to the <code>Drugscreen</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>DrugscreenDAO</code> interface is used by the <code>DrugscreenResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>DrugscreenMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Drugscreen Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Drugscreen 
 * @see DrugscreenMapper 
 * @see DrugscreenResource
 */
@RegisterMapper(DrugscreenMapper.class)
public interface DrugscreenDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `drugscreens` (\n" + 
			"  `youthid` int(8) NOT NULL,\n" + 
			"  `id` int(7) NOT NULL AUTO_INCREMENT,\n" + 
			"  `testdate` date NOT NULL DEFAULT '0000-00-00',\n" + 
			"  `benzodiazepine` varchar(5) DEFAULT NULL,\n" + 
			"  `crystal_methamphetamine` varchar(5) DEFAULT NULL,\n" + 
			"  `amphetamines` varchar(5) DEFAULT NULL,\n" + 
			"  `thc` varchar(5) DEFAULT NULL,\n" + 
			"  `coke` varchar(5) DEFAULT NULL,\n" + 
			"  `opiates` varchar(5) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createDrugscreenTable();
	
	@SqlQuery("select * from drugscreens")
	List<Drugscreen> getAll();
	
	@SqlQuery("select * from drugscreens where id = :id")
	Drugscreen findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from drugscreens where youthid =:youthid")
	Drugscreen findByYouthId(@Bind("youthid") Integer youthid);
	
	@SqlUpdate("delete from drugscreens where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from drugscreens where youthid = :youthid")
	void deleteByYouthId(@Bind("youthid") Integer youthid);
	
	@SqlUpdate("UPDATE `sword-test`.`drugscreens`\n" + 
			"SET\n" + 
			"`youthid` = <{youthid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`testdate` = <{testdate: 0000-00-00}>,\n" + 
			"`benzodiazepine` = <{benzodiazepine: }>,\n" + 
			"`crystal_methamphetamine` = <{crystal_methamphetamine: }>,\n" + 
			"`amphetamines` = <{amphetamines: }>,\n" + 
			"`thc` = <{thc: }>,\n" + 
			"`coke` = <{coke: }>,\n" + 
			"`opiates` = <{opiates: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Drugscreen Drugscreen);
	
	@SqlUpdate("UPDATE `sword-test`.`drugscreens`\n" + 
			"SET\n" + 
			"`youthid` = <{youthid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`testdate` = <{testdate: 0000-00-00}>,\n" + 
			"`benzodiazepine` = <{benzodiazepine: }>,\n" + 
			"`crystal_methamphetamine` = <{crystal_methamphetamine: }>,\n" + 
			"`amphetamines` = <{amphetamines: }>,\n" + 
			"`thc` = <{thc: }>,\n" + 
			"`coke` = <{coke: }>,\n" + 
			"`opiates` = <{opiates: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByYouthId(@BindBean Drugscreen Drugscreen);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`drugscreens`\n" + 
			"(`youthid`,\n" + 
			"`id`,\n" + 
			"`testdate`,\n" + 
			"`benzodiazepine`,\n" + 
			"`crystal_methamphetamine`,\n" + 
			"`amphetamines`,\n" + 
			"`thc`,\n" + 
			"`coke`,\n" + 
			"`opiates`)\n" + 
			"VALUES\n" + 
			"(<{youthid: }>,\n" + 
			"<{id: }>,\n" + 
			"<{testdate: 0000-00-00}>,\n" + 
			"<{benzodiazepine: }>,\n" + 
			"<{crystal_methamphetamine: }>,\n" + 
			"<{amphetamines: }>,\n" + 
			"<{thc: }>,\n" + 
			"<{coke: }>,\n" + 
			"<{opiates: }>);\n" + 
			"")
	int insert(@BindBean Drugscreen Drugscreen);
	
	void close();
}
