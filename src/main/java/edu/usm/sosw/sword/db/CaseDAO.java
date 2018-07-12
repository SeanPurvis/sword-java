package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Case;
import edu.usm.sosw.sword.mappers.CaseMapper;
import edu.usm.sosw.sword.resources.CaseResource;

/** 
 * This interface exists to provide proper access to the <code>case</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>CaseDAO</code> interface is used by the <code>ActionResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>CaseMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Case Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Case 
 * @see CaseMapper 
 * @see CaseResource
 */
@RegisterMapper(CaseMapper.class)
public interface CaseDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS`cases` (\n" + 
			"  `did` varchar(32) NOT NULL,\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `youthid` int(8) NOT NULL,\n" + 
			"  `lastname` varchar(50) DEFAULT ' ',\n" + 
			"  `firstname` varchar(50) DEFAULT ' ',\n" + 
			"  `middlename` varchar(50) DEFAULT ' ',\n" + 
			"  `suffix` varchar(10) DEFAULT ' ',\n" + 
			"  `alias_monikers` varchar(100) DEFAULT ' ',\n" + 
			"  `street` varchar(100) DEFAULT ' ',\n" + 
			"  `city` varchar(50) DEFAULT ' ',\n" + 
			"  `county` varchar(100) DEFAULT NULL,\n" + 
			"  `state` varchar(45) DEFAULT NULL,\n" + 
			"  `zip` varchar(15) DEFAULT ' ',\n" + 
			"  `home_phone` varchar(20) DEFAULT ' ',\n" + 
			"  `length_of_residence_in_county` varchar(100) DEFAULT NULL,\n" + 
			"  `location_of_residence` varchar(100) DEFAULT NULL,\n" + 
			"  `height_feet` int(2) DEFAULT 0,\n" + 
			"  `height_inch` int(2) DEFAULT 0,\n" + 
			"  `weight` varchar(10) DEFAULT ' ',\n" + 
			"  `eye_color` varchar(100) DEFAULT NULL,\n" + 
			"  `hair_color` varchar(100) DEFAULT NULL,\n" + 
			"  `scars` varchar(50) DEFAULT ' ',\n" + 
			"  `religion` varchar(100) DEFAULT NULL,\n" + 
			"  `emp_status` varchar(10) DEFAULT NULL,\n" + 
			"  `emp_where` varchar(100) DEFAULT ' ',\n" + 
			"  `immediate_needs` varchar(100) DEFAULT ' ',\n" + 
			"  `living_arrangements` varchar(100) DEFAULT NULL,\n" + 
			"  `school_attended_last` varchar(50) DEFAULT ' ',\n" + 
			"  `school_attended_city` varchar(50) DEFAULT ' ',\n" + 
			"  `school_attended_state` varchar(45) DEFAULT NULL,\n" + 
			"  `school_attended_zip` varchar(15) DEFAULT ' ',\n" + 
			"  `current_grade` varchar(5) DEFAULT ' ',\n" + 
			"  `special_ed` varchar(10) DEFAULT NULL,\n" + 
			"  `school_attendance` varchar(10) DEFAULT NULL,\n" + 
			"  `school_placement` varchar(100) DEFAULT NULL,\n" + 
			"  `years_school_completed` int(2) DEFAULT 0,\n" + 
			"  `input_date` date DEFAULT NULL,\n" + 
			"  `input_user` varchar(20) DEFAULT ' ',\n" + 
			"  `protection_case` varchar(10) DEFAULT NULL,\n" + 
			"  `modified_date` date DEFAULT NULL,\n" + 
			"  `cell_phone` varchar(20) DEFAULT ' ',\n" + 
			"  `isclosed` varchar(10) DEFAULT NULL,\n" + 
			"  `closing_reason` varchar(100) DEFAULT NULL,\n" + 
			"  `closing_date` date DEFAULT NULL,\n" + 
			"  `disability` varchar(10) DEFAULT ' ',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=28709 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createCasesTable();
	
	@SqlQuery("select * from cases")
	List<Case> getAll();
	
	@SqlQuery("select * from cases where did = :did")
	Case findByDid(@Bind("did") String did);
	
	@SqlQuery("select * from cases where id = :id")
	Case findById(@Bind("id") int id);
	
	@SqlQuery("select * from cases where youthid = :youthid")
	Case findByYouthId(@Bind("youthid") int youthid);
	
	@SqlUpdate("delete from cases where did = :did")
	void deleteByDid(@Bind("did") String did);
	
	@SqlUpdate("delete from cases where id = :id")
	void deleteById(@Bind("id") int id);
	
	@SqlUpdate("delete from cases where youthid = :youthid")
	void deleteByYouthId(@Bind("youthid") int youthid);
	
	@SqlUpdate("UPDATE `sword-test`.`cases`\n" + 
			"SET\n" + 
			"`did` = <{did: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`youthid` = <{youthid: }>,\n" + 
			"`lastname` = <{lastname:  }>,\n" + 
			"`firstname` = <{firstname:  }>,\n" + 
			"`middlename` = <{middlename:  }>,\n" + 
			"`suffix` = <{suffix:  }>,\n" + 
			"`alias_monikers` = <{alias_monikers:  }>,\n" + 
			"`street` = <{street:  }>,\n" + 
			"`city` = <{city:  }>,\n" + 
			"`county` = <{county: }>,\n" + 
			"`state` = <{state: }>,\n" + 
			"`zip` = <{zip:  }>,\n" + 
			"`home_phone` = <{home_phone:  }>,\n" + 
			"`length_of_residence_in_county` = <{length_of_residence_in_county: }>,\n" + 
			"`location_of_residence` = <{location_of_residence: }>,\n" + 
			"`height_feet` = <{height_feet: 0}>,\n" + 
			"`height_inch` = <{height_inch: 0}>,\n" + 
			"`weight` = <{weight:  }>,\n" + 
			"`eye_color` = <{eye_color: }>,\n" + 
			"`hair_color` = <{hair_color: }>,\n" + 
			"`scars` = <{scars:  }>,\n" + 
			"`religion` = <{religion: }>,\n" + 
			"`emp_status` = <{emp_status: }>,\n" + 
			"`emp_where` = <{emp_where:  }>,\n" + 
			"`immediate_needs` = <{immediate_needs:  }>,\n" + 
			"`living_arrangements` = <{living_arrangements: }>,\n" + 
			"`school_attended_last` = <{school_attended_last:  }>,\n" + 
			"`school_attended_city` = <{school_attended_city:  }>,\n" + 
			"`school_attended_state` = <{school_attended_state: }>,\n" + 
			"`school_attended_zip` = <{school_attended_zip:  }>,\n" + 
			"`current_grade` = <{current_grade:  }>,\n" + 
			"`special_ed` = <{special_ed: }>,\n" + 
			"`school_attendance` = <{school_attendance: }>,\n" + 
			"`school_placement` = <{school_placement: }>,\n" + 
			"`years_school_completed` = <{years_school_completed: 0}>,\n" + 
			"`input_date` = <{input_date: }>,\n" + 
			"`input_user` = <{input_user:  }>,\n" + 
			"`protection_case` = <{protection_case: }>,\n" + 
			"`modified_date` = <{modified_date: }>,\n" + 
			"`cell_phone` = <{cell_phone:  }>,\n" + 
			"`isclosed` = <{isclosed: }>,\n" + 
			"`closing_reason` = <{closing_reason: }>,\n" + 
			"`closing_date` = <{closing_date: }>,\n" + 
			"`disability` = <{disability:  }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByDid(@BindBean Case Case);
	
	@SqlUpdate("UPDATE `sword-test`.`cases`\n" + 
			"SET\n" + 
			"`did` = <{did: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`youthid` = <{youthid: }>,\n" + 
			"`lastname` = <{lastname:  }>,\n" + 
			"`firstname` = <{firstname:  }>,\n" + 
			"`middlename` = <{middlename:  }>,\n" + 
			"`suffix` = <{suffix:  }>,\n" + 
			"`alias_monikers` = <{alias_monikers:  }>,\n" + 
			"`street` = <{street:  }>,\n" + 
			"`city` = <{city:  }>,\n" + 
			"`county` = <{county: }>,\n" + 
			"`state` = <{state: }>,\n" + 
			"`zip` = <{zip:  }>,\n" + 
			"`home_phone` = <{home_phone:  }>,\n" + 
			"`length_of_residence_in_county` = <{length_of_residence_in_county: }>,\n" + 
			"`location_of_residence` = <{location_of_residence: }>,\n" + 
			"`height_feet` = <{height_feet: 0}>,\n" + 
			"`height_inch` = <{height_inch: 0}>,\n" + 
			"`weight` = <{weight:  }>,\n" + 
			"`eye_color` = <{eye_color: }>,\n" + 
			"`hair_color` = <{hair_color: }>,\n" + 
			"`scars` = <{scars:  }>,\n" + 
			"`religion` = <{religion: }>,\n" + 
			"`emp_status` = <{emp_status: }>,\n" + 
			"`emp_where` = <{emp_where:  }>,\n" + 
			"`immediate_needs` = <{immediate_needs:  }>,\n" + 
			"`living_arrangements` = <{living_arrangements: }>,\n" + 
			"`school_attended_last` = <{school_attended_last:  }>,\n" + 
			"`school_attended_city` = <{school_attended_city:  }>,\n" + 
			"`school_attended_state` = <{school_attended_state: }>,\n" + 
			"`school_attended_zip` = <{school_attended_zip:  }>,\n" + 
			"`current_grade` = <{current_grade:  }>,\n" + 
			"`special_ed` = <{special_ed: }>,\n" + 
			"`school_attendance` = <{school_attendance: }>,\n" + 
			"`school_placement` = <{school_placement: }>,\n" + 
			"`years_school_completed` = <{years_school_completed: 0}>,\n" + 
			"`input_date` = <{input_date: }>,\n" + 
			"`input_user` = <{input_user:  }>,\n" + 
			"`protection_case` = <{protection_case: }>,\n" + 
			"`modified_date` = <{modified_date: }>,\n" + 
			"`cell_phone` = <{cell_phone:  }>,\n" + 
			"`isclosed` = <{isclosed: }>,\n" + 
			"`closing_reason` = <{closing_reason: }>,\n" + 
			"`closing_date` = <{closing_date: }>,\n" + 
			"`disability` = <{disability:  }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Case Case);

	@SqlUpdate("UPDATE `sword-test`.`cases`\n" + 
			"SET\n" + 
			"`did` = <{did: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`youthid` = <{youthid: }>,\n" + 
			"`lastname` = <{lastname:  }>,\n" + 
			"`firstname` = <{firstname:  }>,\n" + 
			"`middlename` = <{middlename:  }>,\n" + 
			"`suffix` = <{suffix:  }>,\n" + 
			"`alias_monikers` = <{alias_monikers:  }>,\n" + 
			"`street` = <{street:  }>,\n" + 
			"`city` = <{city:  }>,\n" + 
			"`county` = <{county: }>,\n" + 
			"`state` = <{state: }>,\n" + 
			"`zip` = <{zip:  }>,\n" + 
			"`home_phone` = <{home_phone:  }>,\n" + 
			"`length_of_residence_in_county` = <{length_of_residence_in_county: }>,\n" + 
			"`location_of_residence` = <{location_of_residence: }>,\n" + 
			"`height_feet` = <{height_feet: 0}>,\n" + 
			"`height_inch` = <{height_inch: 0}>,\n" + 
			"`weight` = <{weight:  }>,\n" + 
			"`eye_color` = <{eye_color: }>,\n" + 
			"`hair_color` = <{hair_color: }>,\n" + 
			"`scars` = <{scars:  }>,\n" + 
			"`religion` = <{religion: }>,\n" + 
			"`emp_status` = <{emp_status: }>,\n" + 
			"`emp_where` = <{emp_where:  }>,\n" + 
			"`immediate_needs` = <{immediate_needs:  }>,\n" + 
			"`living_arrangements` = <{living_arrangements: }>,\n" + 
			"`school_attended_last` = <{school_attended_last:  }>,\n" + 
			"`school_attended_city` = <{school_attended_city:  }>,\n" + 
			"`school_attended_state` = <{school_attended_state: }>,\n" + 
			"`school_attended_zip` = <{school_attended_zip:  }>,\n" + 
			"`current_grade` = <{current_grade:  }>,\n" + 
			"`special_ed` = <{special_ed: }>,\n" + 
			"`school_attendance` = <{school_attendance: }>,\n" + 
			"`school_placement` = <{school_placement: }>,\n" + 
			"`years_school_completed` = <{years_school_completed: 0}>,\n" + 
			"`input_date` = <{input_date: }>,\n" + 
			"`input_user` = <{input_user:  }>,\n" + 
			"`protection_case` = <{protection_case: }>,\n" + 
			"`modified_date` = <{modified_date: }>,\n" + 
			"`cell_phone` = <{cell_phone:  }>,\n" + 
			"`isclosed` = <{isclosed: }>,\n" + 
			"`closing_reason` = <{closing_reason: }>,\n" + 
			"`closing_date` = <{closing_date: }>,\n" + 
			"`disability` = <{disability:  }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByYouthId(@BindBean Case Case);
	
	@GetGeneratedKeys // Allows us to return the auto generated id to our client
	@SqlUpdate("INSERT INTO `sword-test`.`cases`\n" + 
			"(`did`,\n" + 
			"`id`,\n" + 
			"`youthid`,\n" + 
			"`lastname`,\n" + 
			"`firstname`,\n" + 
			"`middlename`,\n" + 
			"`suffix`,\n" + 
			"`alias_monikers`,\n" + 
			"`street`,\n" + 
			"`city`,\n" + 
			"`county`,\n" + 
			"`state`,\n" + 
			"`zip`,\n" + 
			"`home_phone`,\n" + 
			"`length_of_residence_in_county`,\n" + 
			"`location_of_residence`,\n" + 
			"`height_feet`,\n" + 
			"`height_inch`,\n" + 
			"`weight`,\n" + 
			"`eye_color`,\n" + 
			"`hair_color`,\n" + 
			"`scars`,\n" + 
			"`religion`,\n" + 
			"`emp_status`,\n" + 
			"`emp_where`,\n" + 
			"`immediate_needs`,\n" + 
			"`living_arrangements`,\n" + 
			"`school_attended_last`,\n" + 
			"`school_attended_city`,\n" + 
			"`school_attended_state`,\n" + 
			"`school_attended_zip`,\n" + 
			"`current_grade`,\n" + 
			"`special_ed`,\n" + 
			"`school_attendance`,\n" + 
			"`school_placement`,\n" + 
			"`years_school_completed`,\n" + 
			"`input_date`,\n" + 
			"`input_user`,\n" + 
			"`protection_case`,\n" + 
			"`modified_date`,\n" + 
			"`cell_phone`,\n" + 
			"`isclosed`,\n" + 
			"`closing_reason`,\n" + 
			"`closing_date`,\n" + 
			"`disability`)\n" + 
			"VALUES\n" + 
			"(<{did: }>,\n" + 
			"<{id: }>,\n" + 
			"<{youthid: }>,\n" + 
			"<{lastname:  }>,\n" + 
			"<{firstname:  }>,\n" + 
			"<{middlename:  }>,\n" + 
			"<{suffix:  }>,\n" + 
			"<{alias_monikers:  }>,\n" + 
			"<{street:  }>,\n" + 
			"<{city:  }>,\n" + 
			"<{county: }>,\n" + 
			"<{state: }>,\n" + 
			"<{zip:  }>,\n" + 
			"<{home_phone:  }>,\n" + 
			"<{length_of_residence_in_county: }>,\n" + 
			"<{location_of_residence: }>,\n" + 
			"<{height_feet: 0}>,\n" + 
			"<{height_inch: 0}>,\n" + 
			"<{weight:  }>,\n" + 
			"<{eye_color: }>,\n" + 
			"<{hair_color: }>,\n" + 
			"<{scars:  }>,\n" + 
			"<{religion: }>,\n" + 
			"<{emp_status: }>,\n" + 
			"<{emp_where:  }>,\n" + 
			"<{immediate_needs:  }>,\n" + 
			"<{living_arrangements: }>,\n" + 
			"<{school_attended_last:  }>,\n" + 
			"<{school_attended_city:  }>,\n" + 
			"<{school_attended_state: }>,\n" + 
			"<{school_attended_zip:  }>,\n" + 
			"<{current_grade:  }>,\n" + 
			"<{special_ed: }>,\n" + 
			"<{school_attendance: }>,\n" + 
			"<{school_placement: }>,\n" + 
			"<{years_school_completed: 0}>,\n" + 
			"<{input_date: }>,\n" + 
			"<{input_user:  }>,\n" + 
			"<{protection_case: }>,\n" + 
			"<{modified_date: }>,\n" + 
			"<{cell_phone:  }>,\n" + 
			"<{isclosed: }>,\n" + 
			"<{closing_reason: }>,\n" + 
			"<{closing_date: }>,\n" + 
			"<{disability:  }>);\n" + 
			"")
	int insert(@BindBean Case Case);
	
	void close();
}