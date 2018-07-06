package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Contact;
import edu.usm.sosw.sword.mappers.ContactMapper;
import edu.usm.sosw.sword.resources.ContactResource;

/** 
 * This interface exists to provide proper access to the <code>Contact</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>ContactDAO</code> interface is used by the <code>ContactResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>ContactMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Contact Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Contact 
 * @see ContactMapper 
 * @see ContactResource
 */
@RegisterMapper(ContactMapper.class)
public interface ContactDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `contacts` (\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `relationship` varchar(50) DEFAULT ' ',\n" + 
			"  `previous_court` varchar(5) DEFAULT ' ',\n" + 
			"  `lastname` varchar(30) DEFAULT ' ',\n" + 
			"  `firstname` varchar(30) DEFAULT ' ',\n" + 
			"  `middlename` varchar(30) DEFAULT ' ',\n" + 
			"  `suffix` varchar(10) DEFAULT ' ',\n" + 
			"  `is_guardian` varchar(5) DEFAULT ' ',\n" + 
			"  `is_same_address` varchar(5) DEFAULT ' ',\n" + 
			"  `street` varchar(150) DEFAULT ' ',\n" + 
			"  `city` varchar(100) DEFAULT ' ',\n" + 
			"  `state` varchar(100) DEFAULT '',\n" + 
			"  `zip` varchar(15) DEFAULT ' ',\n" + 
			"  `home_phone` varchar(20) DEFAULT ' ',\n" + 
			"  `cell_phone` varchar(20) DEFAULT ' ',\n" + 
			"  `race` varchar(100) DEFAULT '',\n" + 
			"  `gender` varchar(100) DEFAULT '',\n" + 
			"  `ssn` varchar(15) DEFAULT ' ',\n" + 
			"  `dob` date DEFAULT NULL,\n" + 
			"  `marital_status` varchar(100) DEFAULT '',\n" + 
			"  `education` varchar(100) DEFAULT '',\n" + 
			"  `occupation` varchar(50) DEFAULT ' ',\n" + 
			"  `employer` varchar(255) DEFAULT ' ',\n" + 
			"  `work_phone` varchar(20) DEFAULT ' ',\n" + 
			"  `receive_assistance` varchar(5) DEFAULT ' ',\n" + 
			"  `insurance` varchar(255) DEFAULT ' ',\n" + 
			"  `insurance_policy` varchar(100) DEFAULT ' ',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=17110 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createContactsTable();
	
	@SqlQuery("select * from contacts")
	List<Contact> getAll();
	
	@SqlQuery("select * from contacts where id = :id")
	Contact findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from contacts where caseid = :caseid")
	Contact findByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("delete from contacts where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from contacts where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("UPDATE `sword-test`.`contacts`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`relationship` = <{relationship:  }>,\n" + 
			"`previous_court` = <{previous_court:  }>,\n" + 
			"`lastname` = <{lastname:  }>,\n" + 
			"`firstname` = <{firstname:  }>,\n" + 
			"`middlename` = <{middlename:  }>,\n" + 
			"`suffix` = <{suffix:  }>,\n" + 
			"`is_guardian` = <{is_guardian:  }>,\n" + 
			"`is_same_address` = <{is_same_address:  }>,\n" + 
			"`street` = <{street:  }>,\n" + 
			"`city` = <{city:  }>,\n" + 
			"`state` = <{state: }>,\n" + 
			"`zip` = <{zip:  }>,\n" + 
			"`home_phone` = <{home_phone:  }>,\n" + 
			"`cell_phone` = <{cell_phone:  }>,\n" + 
			"`race` = <{race: }>,\n" + 
			"`gender` = <{gender: }>,\n" + 
			"`ssn` = <{ssn:  }>,\n" + 
			"`dob` = <{dob: }>,\n" + 
			"`marital_status` = <{marital_status: }>,\n" + 
			"`education` = <{education: }>,\n" + 
			"`occupation` = <{occupation:  }>,\n" + 
			"`employer` = <{employer:  }>,\n" + 
			"`work_phone` = <{work_phone:  }>,\n" + 
			"`receive_assistance` = <{receive_assistance:  }>,\n" + 
			"`insurance` = <{insurance:  }>,\n" + 
			"`insurance_policy` = <{insurance_policy:  }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Contact Contact);
	
	@SqlUpdate("UPDATE `sword-test`.`contacts`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`relationship` = <{relationship:  }>,\n" + 
			"`previous_court` = <{previous_court:  }>,\n" + 
			"`lastname` = <{lastname:  }>,\n" + 
			"`firstname` = <{firstname:  }>,\n" + 
			"`middlename` = <{middlename:  }>,\n" + 
			"`suffix` = <{suffix:  }>,\n" + 
			"`is_guardian` = <{is_guardian:  }>,\n" + 
			"`is_same_address` = <{is_same_address:  }>,\n" + 
			"`street` = <{street:  }>,\n" + 
			"`city` = <{city:  }>,\n" + 
			"`state` = <{state: }>,\n" + 
			"`zip` = <{zip:  }>,\n" + 
			"`home_phone` = <{home_phone:  }>,\n" + 
			"`cell_phone` = <{cell_phone:  }>,\n" + 
			"`race` = <{race: }>,\n" + 
			"`gender` = <{gender: }>,\n" + 
			"`ssn` = <{ssn:  }>,\n" + 
			"`dob` = <{dob: }>,\n" + 
			"`marital_status` = <{marital_status: }>,\n" + 
			"`education` = <{education: }>,\n" + 
			"`occupation` = <{occupation:  }>,\n" + 
			"`employer` = <{employer:  }>,\n" + 
			"`work_phone` = <{work_phone:  }>,\n" + 
			"`receive_assistance` = <{receive_assistance:  }>,\n" + 
			"`insurance` = <{insurance:  }>,\n" + 
			"`insurance_policy` = <{insurance_policy:  }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean Contact Contact);
	
	@SqlUpdate("INSERT INTO `sword-test`.`contacts`\n" + 
			"(`id`,\n" + 
			"`caseid`,\n" + 
			"`relationship`,\n" + 
			"`previous_court`,\n" + 
			"`lastname`,\n" + 
			"`firstname`,\n" + 
			"`middlename`,\n" + 
			"`suffix`,\n" + 
			"`is_guardian`,\n" + 
			"`is_same_address`,\n" + 
			"`street`,\n" + 
			"`city`,\n" + 
			"`state`,\n" + 
			"`zip`,\n" + 
			"`home_phone`,\n" + 
			"`cell_phone`,\n" + 
			"`race`,\n" + 
			"`gender`,\n" + 
			"`ssn`,\n" + 
			"`dob`,\n" + 
			"`marital_status`,\n" + 
			"`education`,\n" + 
			"`occupation`,\n" + 
			"`employer`,\n" + 
			"`work_phone`,\n" + 
			"`receive_assistance`,\n" + 
			"`insurance`,\n" + 
			"`insurance_policy`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{caseid: }>,\n" + 
			"<{relationship:  }>,\n" + 
			"<{previous_court:  }>,\n" + 
			"<{lastname:  }>,\n" + 
			"<{firstname:  }>,\n" + 
			"<{middlename:  }>,\n" + 
			"<{suffix:  }>,\n" + 
			"<{is_guardian:  }>,\n" + 
			"<{is_same_address:  }>,\n" + 
			"<{street:  }>,\n" + 
			"<{city:  }>,\n" + 
			"<{state: }>,\n" + 
			"<{zip:  }>,\n" + 
			"<{home_phone:  }>,\n" + 
			"<{cell_phone:  }>,\n" + 
			"<{race: }>,\n" + 
			"<{gender: }>,\n" + 
			"<{ssn:  }>,\n" + 
			"<{dob: }>,\n" + 
			"<{marital_status: }>,\n" + 
			"<{education: }>,\n" + 
			"<{occupation:  }>,\n" + 
			"<{employer:  }>,\n" + 
			"<{work_phone:  }>,\n" + 
			"<{receive_assistance:  }>,\n" + 
			"<{insurance:  }>,\n" + 
			"<{insurance_policy:  }>);\n" + 
			"")
	int insert(@BindBean Contact Contact);
	
	void close();
}
