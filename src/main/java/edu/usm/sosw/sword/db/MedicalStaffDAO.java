package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.MedicalStaff;
import edu.usm.sosw.sword.mappers.MedicalStaffMapper;
import edu.usm.sosw.sword.resources.MedicalStaffResource;

/** 
 * This interface exists to provide proper access to the <code>MedicalStaff</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>MedicalStaffDAO</code> interface is used by the <code>MedicalStaffResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>MedicalStaffMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>MedicalStaff Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see MedicalStaff 
 * @see MedicalStaffMapper 
 * @see MedicalStaffResource
 */
@RegisterMapper(MedicalStaffMapper.class)
public interface MedicalStaffDAO {

		@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_medical_staff` (\n" + 
				"  `med_emp_id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
				"  `name` varchar(100) DEFAULT ' ',\n" + 
				"  `visitation_fee` int(8) DEFAULT 0,\n" + 
				"  PRIMARY KEY (`med_emp_id`)\n" + 
				") ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;\n" + 
				"")
		void createMedicalStaffTable();
		
		@SqlQuery("select * from static_medical_staff")
		List<MedicalStaff> getAll();
		
		@SqlQuery("select * from static_medical_staff where med_emp_id = :med_emp_id")
		MedicalStaff findByMedEmpId(@Bind("med_emp_id") Integer med_emp_id);
		
		@SqlUpdate("delete from static_medical_staff where med_emp_id = :med_emp_id")
		void deleteByMedEmpId(@Bind("med_emp_id") Integer med_emp_id);
		
		@SqlUpdate("UPDATE `sword-test`.`static_medication`\n" + 
				"SET\n" + 
				"`med_id` = <{med_id: }>,\n" + 
				"`medication` = <{medication:  }>,\n" + 
				"`floor_stock` = <{floor_stock: No}>\n" + 
				"WHERE `med_id` = <{expr}>;\n" + 
				"")
		void updateByMedEmpId(@BindBean MedicalStaff MedicalStaff);
		
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
		int insert(@BindBean MedicalStaff MedicalStaff);
		
		void close();
}
