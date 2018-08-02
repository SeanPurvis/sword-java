package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.MedicalVisit;
import edu.usm.sosw.sword.mappers.MedicalVisitMapper;
import edu.usm.sosw.sword.resources.MedicalVisitResource;

/** 
 * This interface exists to provide proper access to the <code>MedicalVisit</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>MedicalVisitDAO</code> interface is used by the <code>MedicalVisitResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>MedicalVisitMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>MedicalVisit Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see MedicalVisit 
 * @see MedicalVisitMapper 
 * @see MedicalVisitResource
 */
@RegisterMapper(MedicalVisitMapper.class)
public interface MedicalVisitDAO {

		@SqlUpdate("CREATE TABLE IF NOT EXISTS `medical_visit` (\n" + 
				"  `medical_visit_id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
				"  `youthid` int(8) NOT NULL,\n" + 
				"  `visit_date` date NOT NULL,\n" + 
				"  `medical_staff` varchar(100) DEFAULT NULL,\n" + 
				"  `complaint` text DEFAULT NULL,\n" + 
				"  `diagnosis` text DEFAULT NULL,\n" + 
				"  `outside_treatment` varchar(100) DEFAULT NULL,\n" + 
				"  `outside_treatment_fee` float DEFAULT NULL,\n" + 
				"  `secondary_outside_treatment` varchar(100) DEFAULT NULL,\n" + 
				"  `secondary_outside_treatment_fee` float DEFAULT NULL,\n" + 
				"  `transport_cost` float DEFAULT NULL,\n" + 
				"  `ordering_county` varchar(100) DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`medical_visit_id`)\n" + 
				") ENGINE=InnoDB AUTO_INCREMENT=2614 DEFAULT CHARSET=latin1;\n" + 
				"")
		void createMedicalVisitTable();
		
		@SqlQuery("select * from medical_visit")
		List<MedicalVisit> getAll();
		
		@SqlQuery("select * from medical_visit where medical_visit_id = :medical_visit_id")
		MedicalVisit findByMedicalVisitId(@Bind("medical_visit_id") Integer medical_visit_id);
		
		@SqlQuery("select * from medical_visit where youthid = :youthid")
		MedicalVisit findByYouthId(@Bind("youthid") Integer youthid);
		
		@SqlUpdate("delete from medical_visit where medical_visit_id = :medical_visit_id")
		void deleteByMedicalVisitId(@Bind("medical_visit_id") Integer medical_visit_id);
		
		@SqlUpdate("delete from medical_visit where youthid = :youthid")
		void deleteByYouthId(@Bind("youthid") Integer youthid);
		
		@SqlUpdate("UPDATE `sword-test`.`medical_visit`\n" + 
				"SET\n" + 
				"`medical_visit_id` = <{medical_visit_id: }>,\n" + 
				"`youthid` = <{youthid: }>,\n" + 
				"`visit_date` = <{visit_date: }>,\n" + 
				"`medical_staff` = <{medical_staff: }>,\n" + 
				"`complaint` = <{complaint: }>,\n" + 
				"`diagnosis` = <{diagnosis: }>,\n" + 
				"`outside_treatment` = <{outside_treatment: }>,\n" + 
				"`outside_treatment_fee` = <{outside_treatment_fee: }>,\n" + 
				"`secondary_outside_treatment` = <{secondary_outside_treatment: }>,\n" + 
				"`secondary_outside_treatment_fee` = <{secondary_outside_treatment_fee: }>,\n" + 
				"`transport_cost` = <{transport_cost: }>,\n" + 
				"`ordering_county` = <{ordering_county: }>\n" + 
				"WHERE `medical_visit_id` = <{expr}>;\n" + 
				"")
		void updateByMedicalVisitId(@BindBean MedicalVisit MedicalVisit);
		
		@SqlUpdate("UPDATE `sword-test`.`medical_visit`\n" + 
				"SET\n" + 
				"`medical_visit_id` = <{medical_visit_id: }>,\n" + 
				"`youthid` = <{youthid: }>,\n" + 
				"`visit_date` = <{visit_date: }>,\n" + 
				"`medical_staff` = <{medical_staff: }>,\n" + 
				"`complaint` = <{complaint: }>,\n" + 
				"`diagnosis` = <{diagnosis: }>,\n" + 
				"`outside_treatment` = <{outside_treatment: }>,\n" + 
				"`outside_treatment_fee` = <{outside_treatment_fee: }>,\n" + 
				"`secondary_outside_treatment` = <{secondary_outside_treatment: }>,\n" + 
				"`secondary_outside_treatment_fee` = <{secondary_outside_treatment_fee: }>,\n" + 
				"`transport_cost` = <{transport_cost: }>,\n" + 
				"`ordering_county` = <{ordering_county: }>\n" + 
				"WHERE `medical_visit_id` = <{expr}>;\n" + 
				"")
		void updateByYouthId(@BindBean MedicalVisit MedicalVisit);
		
		@GetGeneratedKeys
		@SqlUpdate("INSERT INTO `sword-test`.`medical_visit`\n" + 
				"(`medical_visit_id`,\n" + 
				"`youthid`,\n" + 
				"`visit_date`,\n" + 
				"`medical_staff`,\n" + 
				"`complaint`,\n" + 
				"`diagnosis`,\n" + 
				"`outside_treatment`,\n" + 
				"`outside_treatment_fee`,\n" + 
				"`secondary_outside_treatment`,\n" + 
				"`secondary_outside_treatment_fee`,\n" + 
				"`transport_cost`,\n" + 
				"`ordering_county`)\n" + 
				"VALUES\n" + 
				"(<{medical_visit_id: }>,\n" + 
				"<{youthid: }>,\n" + 
				"<{visit_date: }>,\n" + 
				"<{medical_staff: }>,\n" + 
				"<{complaint: }>,\n" + 
				"<{diagnosis: }>,\n" + 
				"<{outside_treatment: }>,\n" + 
				"<{outside_treatment_fee: }>,\n" + 
				"<{secondary_outside_treatment: }>,\n" + 
				"<{secondary_outside_treatment_fee: }>,\n" + 
				"<{transport_cost: }>,\n" + 
				"<{ordering_county: }>);\n" + 
				"")
		int insert(@BindBean MedicalVisit MedicalVisit);
		
		void close();
}
