package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Medications;
import edu.usm.sosw.sword.mappers.MedicationsMapper;
import edu.usm.sosw.sword.resources.MedicationsResource;

/** 
 * This interface exists to provide proper access to the <code>Medications</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>MedicationsDAO</code> interface is used by the <code>MedicationsResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>MedicationsMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Medications Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Medications 
 * @see MedicationsMapper 
 * @see MedicationsResource
 */
@RegisterMapper(MedicationsMapper.class)
public interface MedicationsDAO {

	@SqlUpdate("CREATE TABLE IF NOT EXISTS `medications` (\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `youthid` int(8) NOT NULL,\n" + 
			"  `request_date` date DEFAULT NULL,\n" + 
			"  `medication` varchar(100) DEFAULT NULL,\n" + 
			"  `frequency` varchar(10) DEFAULT NULL,\n" + 
			"  `quantity` int(11) DEFAULT 0,\n" + 
			"  `dosage` varchar(100) DEFAULT ' ',\n" + 
			"  `cost` decimal(10,2) DEFAULT NULL,\n" + 
			"  `start_date` date DEFAULT NULL,\n" + 
			"  `end_date` date DEFAULT NULL,\n" + 
			"  `ordering_county` varchar(100) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=4180 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createMedicationsTable();
	
	@SqlQuery("select * from medications")
	List<Medications> getAll();
	
	@SqlQuery("select * from medications where id = :id")
	Medications findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from medications where youthid = :youthid")
	Medications findByYouthId(@Bind("id") Integer id);
	
	@SqlUpdate("delete from medications where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from medications where youthid = :youthid")
	void deleteByYouthId(@Bind("youthid") Integer youthid);
	
	@SqlUpdate("UPDATE `sword-test`.`medications`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`youthid` = <{youthid: }>,\n" + 
			"`request_date` = <{request_date: }>,\n" + 
			"`medication` = <{medication: }>,\n" + 
			"`frequency` = <{frequency: }>,\n" + 
			"`quantity` = <{quantity: 0}>,\n" + 
			"`dosage` = <{dosage:  }>,\n" + 
			"`cost` = <{cost: }>,\n" + 
			"`start_date` = <{start_date: }>,\n" + 
			"`end_date` = <{end_date: }>,\n" + 
			"`ordering_county` = <{ordering_county: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Medications Medications);
	
	@SqlUpdate("UPDATE `sword-test`.`medications`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`youthid` = <{youthid: }>,\n" + 
			"`request_date` = <{request_date: }>,\n" + 
			"`medication` = <{medication: }>,\n" + 
			"`frequency` = <{frequency: }>,\n" + 
			"`quantity` = <{quantity: 0}>,\n" + 
			"`dosage` = <{dosage:  }>,\n" + 
			"`cost` = <{cost: }>,\n" + 
			"`start_date` = <{start_date: }>,\n" + 
			"`end_date` = <{end_date: }>,\n" + 
			"`ordering_county` = <{ordering_county: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByYouthId(@BindBean Medications Medications);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`medications`\n" + 
			"(`id`,\n" + 
			"`youthid`,\n" + 
			"`request_date`,\n" + 
			"`medication`,\n" + 
			"`frequency`,\n" + 
			"`quantity`,\n" + 
			"`dosage`,\n" + 
			"`cost`,\n" + 
			"`start_date`,\n" + 
			"`end_date`,\n" + 
			"`ordering_county`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{youthid: }>,\n" + 
			"<{request_date: }>,\n" + 
			"<{medication: }>,\n" + 
			"<{frequency: }>,\n" + 
			"<{quantity: 0}>,\n" + 
			"<{dosage:  }>,\n" + 
			"<{cost: }>,\n" + 
			"<{start_date: }>,\n" + 
			"<{end_date: }>,\n" + 
			"<{ordering_county: }>);\n" + 
			"")
	int insert(@BindBean Medications Medications);
	
	void close();
}
