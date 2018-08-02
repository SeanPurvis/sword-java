package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Medication;
import edu.usm.sosw.sword.mappers.MedicationMapper;
import edu.usm.sosw.sword.resources.MedicationResource;

/** 
 * This interface exists to provide proper access to the <code>Medication</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>MedicationDAO</code> interface is used by the <code>MedicationResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>MedicationMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Medication Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Medication 
 * @see MedicationMapper 
 * @see MedicationResource
 */
@RegisterMapper(MedicationMapper.class)
public interface MedicationDAO {

	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_medication` (\n" + 
			"  `med_id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `medication` varchar(100) DEFAULT ' ',\n" + 
			"  `floor_stock` varchar(5) DEFAULT 'No',\n" + 
			"  PRIMARY KEY (`med_id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createmedicationTable();
	
	@SqlQuery("select * from static_medication")
	List<Medication> getAll();
	
	@SqlQuery("select * from static_medication where med_id = :med_id")
	Medication findByMedId(@Bind("med_id") Integer med_id);
	
	@SqlUpdate("delete from medication where med_id = :med_id")
	void deleteByMedId(@Bind("med_id") Integer med_id);
	
	@SqlUpdate("UPDATE `sword-test`.`static_medication`\n" + 
			"SET\n" + 
			"`med_id` = <{med_id: }>,\n" + 
			"`medication` = <{medication:  }>,\n" + 
			"`floor_stock` = <{floor_stock: No}>\n" + 
			"WHERE `med_id` = <{expr}>;\n" + 
			"")
	void updateByMedId(@BindBean Medication Medication);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`static_medication`\n" + 
			"(`med_id`,\n" + 
			"`medication`,\n" + 
			"`floor_stock`)\n" + 
			"VALUES\n" + 
			"(<{med_id: }>,\n" + 
			"<{medication:  }>,\n" + 
			"<{floor_stock: No}>);\n" + 
			"")
	int insert(@BindBean Medication Medication);
	
	void close();
}
