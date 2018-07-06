package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Charge;
import edu.usm.sosw.sword.mappers.ChargeMapper;
import edu.usm.sosw.sword.resources.ChargeResource;

/** 
 * This interface exists to provide proper access to the <code>Charge</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>ChargeDAO</code> interface is used by the <code>ChargeResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>ChargeMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Charge Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Charge 
 * @see ChargeMapper 
 * @see ChargeResource
 */
@RegisterMapper(ChargeMapper.class)
public interface ChargeDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS`charges` (\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `docket_number` varchar(20) DEFAULT NULL,\n" + 
			"  `statute` varchar(15) DEFAULT '',\n" + 
			"  `class` varchar(2) DEFAULT ' ',\n" + 
			"  `risk_assessment_value` int(1) DEFAULT 0,\n" + 
			"  `offense_desc` varchar(255) DEFAULT NULL,\n" + 
			"  `date_offense_occurred` date DEFAULT NULL,\n" + 
			"  `docket_year` int(5) DEFAULT 0,\n" + 
			"  `docket_intake` int(7) DEFAULT 0,\n" + 
			"  `input_date` date DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=18539 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createChargesTable();
	
	@SqlQuery("select * from charges")
	List<Charge> getAll();
	
	@SqlQuery("select * from charges where caseid = :caseid")
	Charge findByCaseId(@Bind("caseid") int caseid);
	
	@SqlQuery("select * from charges where id = :id")
	Charge findById(@Bind("id") int id);
	
	@SqlQuery("select * from charges where docket_number = :docket_number")
	Charge findByDocketNum(@Bind("docket_number") String docket_number);
	
	@SqlUpdate("delete from charges where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") int caseid);
	
	@SqlUpdate("delete from charges where id = :id")
	void deleteById(@Bind("id") int id);
	
	@SqlUpdate("delete from charges where docket_number = :docket_number")
	void deleteByDocketNum(@Bind("docket_number") String docket_number);
	
	@SqlUpdate("UPDATE `sword-test`.`charges`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`docket_number` = <{docket_number: }>,\n" + 
			"`statute` = <{statute: }>,\n" + 
			"`class` = <{class:  }>,\n" + 
			"`risk_assessment_value` = <{risk_assessment_value: 0}>,\n" + 
			"`offense_desc` = <{offense_desc: }>,\n" + 
			"`date_offense_occurred` = <{date_offense_occurred: }>,\n" + 
			"`docket_year` = <{docket_year: 0}>,\n" + 
			"`docket_intake` = <{docket_intake: 0}>,\n" + 
			"`input_date` = <{input_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean Charge Charge);
	
	@SqlUpdate("UPDATE `sword-test`.`charges`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`docket_number` = <{docket_number: }>,\n" + 
			"`statute` = <{statute: }>,\n" + 
			"`class` = <{class:  }>,\n" + 
			"`risk_assessment_value` = <{risk_assessment_value: 0}>,\n" + 
			"`offense_desc` = <{offense_desc: }>,\n" + 
			"`date_offense_occurred` = <{date_offense_occurred: }>,\n" + 
			"`docket_year` = <{docket_year: 0}>,\n" + 
			"`docket_intake` = <{docket_intake: 0}>,\n" + 
			"`input_date` = <{input_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Charge Charge);
	
	@SqlUpdate("UPDATE `sword-test`.`charges`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`docket_number` = <{docket_number: }>,\n" + 
			"`statute` = <{statute: }>,\n" + 
			"`class` = <{class:  }>,\n" + 
			"`risk_assessment_value` = <{risk_assessment_value: 0}>,\n" + 
			"`offense_desc` = <{offense_desc: }>,\n" + 
			"`date_offense_occurred` = <{date_offense_occurred: }>,\n" + 
			"`docket_year` = <{docket_year: 0}>,\n" + 
			"`docket_intake` = <{docket_intake: 0}>,\n" + 
			"`input_date` = <{input_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByDocketNum(@BindBean Charge Charge);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`charges`\n" + 
			"(`caseid`,\n" + 
			"`id`,\n" + 
			"`docket_number`,\n" + 
			"`statute`,\n" + 
			"`class`,\n" + 
			"`risk_assessment_value`,\n" + 
			"`offense_desc`,\n" + 
			"`date_offense_occurred`,\n" + 
			"`docket_year`,\n" + 
			"`docket_intake`,\n" + 
			"`input_date`)\n" + 
			"VALUES\n" + 
			"(<{caseid: }>,\n" + 
			"<{id: }>,\n" + 
			"<{docket_number: }>,\n" + 
			"<{statute: }>,\n" + 
			"<{class:  }>,\n" + 
			"<{risk_assessment_value: 0}>,\n" + 
			"<{offense_desc: }>,\n" + 
			"<{date_offense_occurred: }>,\n" + 
			"<{docket_year: 0}>,\n" + 
			"<{docket_intake: 0}>,\n" + 
			"<{input_date: }>);\n" + 
			"")
	int insert(@BindBean Charge Charge);
	
	void close();
}
