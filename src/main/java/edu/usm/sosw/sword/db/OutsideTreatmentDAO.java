package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.OutsideTreatment;
import edu.usm.sosw.sword.mappers.OutsideTreatmentMapper;
import edu.usm.sosw.sword.resources.OutsideTreatmentResource;

/** 
 * This interface exists to provide proper access to the <code>OutsideTreatment</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>OutsideTreatmentDAO</code> interface is used by the <code>OutsideTreatmentResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>OutsideTreatmentMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>OutsideTreatment Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see OutsideTreatment 
 * @see OutsideTreatmentMapper 
 * @see OutsideTreatmentResource
 */
@RegisterMapper(OutsideTreatmentMapper.class)
public interface OutsideTreatmentDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_outside_treatment` (\n" + 
			"  `outside_treatment_id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `outside_source` varchar(100) DEFAULT ' ',\n" + 
			"  PRIMARY KEY (`outside_treatment_id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createOutsideTreatmentTable();
	
	@SqlQuery("select * from static_oustide_treatment")
	List<OutsideTreatment> getAll();
	
	@SqlQuery("select * from static_outside_treatment where outside_treatment_id = :outside_treatment_id")
	OutsideTreatment findById(@Bind("outside_treatment_id") Integer outside_treatment_id);
	
	@SqlUpdate("delete from static_outside_treatment where outside_treatment_id = :outside_treatment_id")
	void deleteById(@Bind("outside_treatment_id") Integer outside_treatment_id);
	
	@SqlUpdate("UPDATE `sword-test`.`static_outside_treatment`\n" + 
			"SET\n" + 
			"`outside_treatment_id` = <{outside_treatment_id: }>,\n" + 
			"`outside_source` = <{outside_source:  }>\n" + 
			"WHERE `outside_treatment_id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean OutsideTreatment OutsideTreatment);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`static_outside_treatment`\n" + 
			"(`outside_treatment_id`,\n" + 
			"`outside_source`)\n" + 
			"VALUES\n" + 
			"(<{outside_treatment_id: }>,\n" + 
			"<{outside_source:  }>);\n" + 
			"")
	int insert(@BindBean OutsideTreatment OutsideTreatment);
	
	void close();
}
