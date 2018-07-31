package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Medical;
import edu.usm.sosw.sword.mappers.MedicalMapper;
import edu.usm.sosw.sword.resources.MedicalResource;

/** 
 * This interface exists to provide proper access to the <code>Medical</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>MedicalDAO</code> interface is used by the <code>MedicalResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>MedicalMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Medical Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Medical 
 * @see MedicalMapper 
 * @see MedicalResource
 */
@RegisterMapper(MedicalMapper.class)
public interface MedicalDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `medical` (\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `id` int(7) NOT NULL AUTO_INCREMENT,\n" + 
			"  `immediate_medical_needs` varchar(255) DEFAULT NULL,\n" + 
			"  `immediate_phych_needs` varchar(255) DEFAULT NULL,\n" + 
			"  `current_medications` varchar(255) DEFAULT NULL,\n" + 
			"  `medical_insurance` varchar(255) DEFAULT NULL,\n" + 
			"  `agency1` varchar(255) DEFAULT NULL,\n" + 
			"  `benefits1` varchar(255) DEFAULT NULL,\n" + 
			"  `agency2` varchar(255) DEFAULT NULL,\n" + 
			"  `benefits2` varchar(255) DEFAULT NULL,\n" + 
			"  `agency3` varchar(255) DEFAULT NULL,\n" + 
			"  `benefits3` varchar(255) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=658 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createMedicalTable();
	
	@SqlQuery("select * from medical")
	List<Medical> getAll();
	
	@SqlQuery("select * from medical where id = :id")
	Medical findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from medical where caseid = :caseid")
	Medical findByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("delete from medical where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from medical where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("UPDATE `sword-test`.`medical`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`immediate_medical_needs` = <{immediate_medical_needs: }>,\n" + 
			"`immediate_phych_needs` = <{immediate_phych_needs: }>,\n" + 
			"`current_medications` = <{current_medications: }>,\n" + 
			"`medical_insurance` = <{medical_insurance: }>,\n" + 
			"`agency1` = <{agency1: }>,\n" + 
			"`benefits1` = <{benefits1: }>,\n" + 
			"`agency2` = <{agency2: }>,\n" + 
			"`benefits2` = <{benefits2: }>,\n" + 
			"`agency3` = <{agency3: }>,\n" + 
			"`benefits3` = <{benefits3: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Medical Medical);
	
	@SqlUpdate("UPDATE `sword-test`.`medical`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`immediate_medical_needs` = <{immediate_medical_needs: }>,\n" + 
			"`immediate_phych_needs` = <{immediate_phych_needs: }>,\n" + 
			"`current_medications` = <{current_medications: }>,\n" + 
			"`medical_insurance` = <{medical_insurance: }>,\n" + 
			"`agency1` = <{agency1: }>,\n" + 
			"`benefits1` = <{benefits1: }>,\n" + 
			"`agency2` = <{agency2: }>,\n" + 
			"`benefits2` = <{benefits2: }>,\n" + 
			"`agency3` = <{agency3: }>,\n" + 
			"`benefits3` = <{benefits3: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean Medical Medical);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`medical`\n" + 
			"(`caseid`,\n" + 
			"`id`,\n" + 
			"`immediate_medical_needs`,\n" + 
			"`immediate_phych_needs`,\n" + 
			"`current_medications`,\n" + 
			"`medical_insurance`,\n" + 
			"`agency1`,\n" + 
			"`benefits1`,\n" + 
			"`agency2`,\n" + 
			"`benefits2`,\n" + 
			"`agency3`,\n" + 
			"`benefits3`)\n" + 
			"VALUES\n" + 
			"(<{caseid: }>,\n" + 
			"<{id: }>,\n" + 
			"<{immediate_medical_needs: }>,\n" + 
			"<{immediate_phych_needs: }>,\n" + 
			"<{current_medications: }>,\n" + 
			"<{medical_insurance: }>,\n" + 
			"<{agency1: }>,\n" + 
			"<{benefits1: }>,\n" + 
			"<{agency2: }>,\n" + 
			"<{benefits2: }>,\n" + 
			"<{agency3: }>,\n" + 
			"<{benefits3: }>);\n" + 
			"")
	int insert(@BindBean Medical Medical);
	
	void close();
}
