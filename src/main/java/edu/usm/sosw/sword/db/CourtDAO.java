package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Court;
import edu.usm.sosw.sword.mappers.CourtMapper;
import edu.usm.sosw.sword.resources.CourtResource;

/** 
 * This interface exists to provide proper access to the <code>Court</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>CourtDAO</code> interface is used by the <code>CourtResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>CourtMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Court Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Court 
 * @see CourtMapper 
 * @see CourtResource
 */
@RegisterMapper(CourtMapper.class)
public interface CourtDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `courts` (\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `attorney_childs` varchar(100) DEFAULT ' ',\n" + 
			"  `attorney_childs_appointed_date` date DEFAULT NULL,\n" + 
			"  `attorney_fathers` varchar(100) DEFAULT ' ',\n" + 
			"  `attorney_mothers` varchar(100) DEFAULT ' ',\n" + 
			"  `casa_appointed_date` date DEFAULT NULL,\n" + 
			"  `court_summary` varchar(255) DEFAULT ' ',\n" + 
			"  `court_type` varchar(100) DEFAULT ' ',\n" + 
			"  `formal_petition_filed_date` date DEFAULT NULL,\n" + 
			"  `formal_petition_ordered_date` date DEFAULT NULL,\n" + 
			"  `formal_petition_code` int(8) DEFAULT NULL,\n" + 
			"  `gal_appointed_date` date DEFAULT NULL,\n" + 
			"  `gal_bar_number` varchar(100) DEFAULT ' ',\n" + 
			"  `hearing_date` date DEFAULT NULL,\n" + 
			"  `hearing_type` varchar(100) DEFAULT ' ',\n" + 
			"  `informal_adjustment_ordered_date` date DEFAULT NULL,\n" + 
			"  `judge` varchar(100) DEFAULT '0',\n" + 
			"  `mdhs_name` varchar(255) DEFAULT ' ',\n" + 
			"  `mdhs_recommendation` varchar(255) DEFAULT ' ',\n" + 
			"  `motion_entered_date` date DEFAULT NULL,\n" + 
			"  `next_hearing_date` date DEFAULT NULL,\n" + 
			"  `no_show` varchar(5) DEFAULT 'No',\n" + 
			"  `number_of_continuances_granted` int(5) DEFAULT 0,\n" + 
			"  `plan_concurrent` varchar(100) DEFAULT ' ',\n" + 
			"  `plan_permanent` varchar(100) DEFAULT ' ',\n" + 
			"  `subpoenaed_names` varchar(255) DEFAULT ' ',\n" + 
			"  `summons_issued_on_child_date` date DEFAULT NULL,\n" + 
			"  `summons_served_on_child_date` date DEFAULT NULL,\n" + 
			"  `take_no_action_ordered_date` date DEFAULT NULL,\n" + 
			"  `waived` varchar(5) DEFAULT ' ',\n" + 
			"  `witnesses` varchar(255) DEFAULT ' ',\n" + 
			"  `zero_to_three_program` varchar(5) DEFAULT ' ',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=3644 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createCourtTable();
	
	@SqlQuery("select * from courts")
	List<Court> getAll();
	
	@SqlQuery("select * from courts where id = :id")
	Court findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from courts where caseid = :caseid")
	Court findByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("delete from courts where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from courts where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("UPDATE `sword-test`.`courts`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`attorney_childs` = <{attorney_childs:  }>,\n" + 
			"`attorney_childs_appointed_date` = <{attorney_childs_appointed_date: }>,\n" + 
			"`attorney_fathers` = <{attorney_fathers:  }>,\n" + 
			"`attorney_mothers` = <{attorney_mothers:  }>,\n" + 
			"`casa_appointed_date` = <{casa_appointed_date: }>,\n" + 
			"`court_summary` = <{court_summary:  }>,\n" + 
			"`court_type` = <{court_type:  }>,\n" + 
			"`formal_petition_filed_date` = <{formal_petition_filed_date: }>,\n" + 
			"`formal_petition_ordered_date` = <{formal_petition_ordered_date: }>,\n" + 
			"`formal_petition_code` = <{formal_petition_code: }>,\n" + 
			"`gal_appointed_date` = <{gal_appointed_date: }>,\n" + 
			"`gal_bar_number` = <{gal_bar_number:  }>,\n" + 
			"`hearing_date` = <{hearing_date: }>,\n" + 
			"`hearing_type` = <{hearing_type:  }>,\n" + 
			"`informal_adjustment_ordered_date` = <{informal_adjustment_ordered_date: }>,\n" + 
			"`judge` = <{judge: 0}>,\n" + 
			"`mdhs_name` = <{mdhs_name:  }>,\n" + 
			"`mdhs_recommendation` = <{mdhs_recommendation:  }>,\n" + 
			"`motion_entered_date` = <{motion_entered_date: }>,\n" + 
			"`next_hearing_date` = <{next_hearing_date: }>,\n" + 
			"`no_show` = <{no_show: No}>,\n" + 
			"`number_of_continuances_granted` = <{number_of_continuances_granted: 0}>,\n" + 
			"`plan_concurrent` = <{plan_concurrent:  }>,\n" + 
			"`plan_permanent` = <{plan_permanent:  }>,\n" + 
			"`subpoenaed_names` = <{subpoenaed_names:  }>,\n" + 
			"`summons_issued_on_child_date` = <{summons_issued_on_child_date: }>,\n" + 
			"`summons_served_on_child_date` = <{summons_served_on_child_date: }>,\n" + 
			"`take_no_action_ordered_date` = <{take_no_action_ordered_date: }>,\n" + 
			"`waived` = <{waived:  }>,\n" + 
			"`witnesses` = <{witnesses:  }>,\n" + 
			"`zero_to_three_program` = <{zero_to_three_program:  }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Court Court);
	
	@SqlUpdate("UPDATE `sword-test`.`courts`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`attorney_childs` = <{attorney_childs:  }>,\n" + 
			"`attorney_childs_appointed_date` = <{attorney_childs_appointed_date: }>,\n" + 
			"`attorney_fathers` = <{attorney_fathers:  }>,\n" + 
			"`attorney_mothers` = <{attorney_mothers:  }>,\n" + 
			"`casa_appointed_date` = <{casa_appointed_date: }>,\n" + 
			"`court_summary` = <{court_summary:  }>,\n" + 
			"`court_type` = <{court_type:  }>,\n" + 
			"`formal_petition_filed_date` = <{formal_petition_filed_date: }>,\n" + 
			"`formal_petition_ordered_date` = <{formal_petition_ordered_date: }>,\n" + 
			"`formal_petition_code` = <{formal_petition_code: }>,\n" + 
			"`gal_appointed_date` = <{gal_appointed_date: }>,\n" + 
			"`gal_bar_number` = <{gal_bar_number:  }>,\n" + 
			"`hearing_date` = <{hearing_date: }>,\n" + 
			"`hearing_type` = <{hearing_type:  }>,\n" + 
			"`informal_adjustment_ordered_date` = <{informal_adjustment_ordered_date: }>,\n" + 
			"`judge` = <{judge: 0}>,\n" + 
			"`mdhs_name` = <{mdhs_name:  }>,\n" + 
			"`mdhs_recommendation` = <{mdhs_recommendation:  }>,\n" + 
			"`motion_entered_date` = <{motion_entered_date: }>,\n" + 
			"`next_hearing_date` = <{next_hearing_date: }>,\n" + 
			"`no_show` = <{no_show: No}>,\n" + 
			"`number_of_continuances_granted` = <{number_of_continuances_granted: 0}>,\n" + 
			"`plan_concurrent` = <{plan_concurrent:  }>,\n" + 
			"`plan_permanent` = <{plan_permanent:  }>,\n" + 
			"`subpoenaed_names` = <{subpoenaed_names:  }>,\n" + 
			"`summons_issued_on_child_date` = <{summons_issued_on_child_date: }>,\n" + 
			"`summons_served_on_child_date` = <{summons_served_on_child_date: }>,\n" + 
			"`take_no_action_ordered_date` = <{take_no_action_ordered_date: }>,\n" + 
			"`waived` = <{waived:  }>,\n" + 
			"`witnesses` = <{witnesses:  }>,\n" + 
			"`zero_to_three_program` = <{zero_to_three_program:  }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean Court Court);
	
	@SqlUpdate("INSERT INTO `sword-test`.`courts`\n" + 
			"(`id`,\n" + 
			"`caseid`,\n" + 
			"`attorney_childs`,\n" + 
			"`attorney_childs_appointed_date`,\n" + 
			"`attorney_fathers`,\n" + 
			"`attorney_mothers`,\n" + 
			"`casa_appointed_date`,\n" + 
			"`court_summary`,\n" + 
			"`court_type`,\n" + 
			"`formal_petition_filed_date`,\n" + 
			"`formal_petition_ordered_date`,\n" + 
			"`formal_petition_code`,\n" + 
			"`gal_appointed_date`,\n" + 
			"`gal_bar_number`,\n" + 
			"`hearing_date`,\n" + 
			"`hearing_type`,\n" + 
			"`informal_adjustment_ordered_date`,\n" + 
			"`judge`,\n" + 
			"`mdhs_name`,\n" + 
			"`mdhs_recommendation`,\n" + 
			"`motion_entered_date`,\n" + 
			"`next_hearing_date`,\n" + 
			"`no_show`,\n" + 
			"`number_of_continuances_granted`,\n" + 
			"`plan_concurrent`,\n" + 
			"`plan_permanent`,\n" + 
			"`subpoenaed_names`,\n" + 
			"`summons_issued_on_child_date`,\n" + 
			"`summons_served_on_child_date`,\n" + 
			"`take_no_action_ordered_date`,\n" + 
			"`waived`,\n" + 
			"`witnesses`,\n" + 
			"`zero_to_three_program`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{caseid: }>,\n" + 
			"<{attorney_childs:  }>,\n" + 
			"<{attorney_childs_appointed_date: }>,\n" + 
			"<{attorney_fathers:  }>,\n" + 
			"<{attorney_mothers:  }>,\n" + 
			"<{casa_appointed_date: }>,\n" + 
			"<{court_summary:  }>,\n" + 
			"<{court_type:  }>,\n" + 
			"<{formal_petition_filed_date: }>,\n" + 
			"<{formal_petition_ordered_date: }>,\n" + 
			"<{formal_petition_code: }>,\n" + 
			"<{gal_appointed_date: }>,\n" + 
			"<{gal_bar_number:  }>,\n" + 
			"<{hearing_date: }>,\n" + 
			"<{hearing_type:  }>,\n" + 
			"<{informal_adjustment_ordered_date: }>,\n" + 
			"<{judge: 0}>,\n" + 
			"<{mdhs_name:  }>,\n" + 
			"<{mdhs_recommendation:  }>,\n" + 
			"<{motion_entered_date: }>,\n" + 
			"<{next_hearing_date: }>,\n" + 
			"<{no_show: No}>,\n" + 
			"<{number_of_continuances_granted: 0}>,\n" + 
			"<{plan_concurrent:  }>,\n" + 
			"<{plan_permanent:  }>,\n" + 
			"<{subpoenaed_names:  }>,\n" + 
			"<{summons_issued_on_child_date: }>,\n" + 
			"<{summons_served_on_child_date: }>,\n" + 
			"<{take_no_action_ordered_date: }>,\n" + 
			"<{waived:  }>,\n" + 
			"<{witnesses:  }>,\n" + 
			"<{zero_to_three_program:  }>);\n" + 
			"")
	int insert(@BindBean Court Court);
	
	void close();
}
