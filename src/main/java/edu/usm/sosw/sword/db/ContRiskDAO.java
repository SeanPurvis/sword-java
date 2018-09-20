package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.ContRisk;
import edu.usm.sosw.sword.mappers.ContRiskMapper;
import edu.usm.sosw.sword.resources.ContRiskResource;

/** 
 * This interface exists to provide proper access to the <code>ContRisk</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>ContRiskDAO</code> interface is used by the <code>ContRiskResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>ContRiskMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>ContRisk Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see ContRisk 
 * @see ContRiskMapper 
 * @see ContRiskResource
 */
@RegisterMapper(ContRiskMapper.class)
public interface ContRiskDAO {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS`cont_risk` (\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `fullname` varchar(100) DEFAULT NULL,\n" + 
			"  `dob` varchar(25) DEFAULT NULL,\n" + 
			"  `age` int(11) DEFAULT NULL,\n" + 
			"  `gender` varchar(100) DEFAULT NULL,\n" + 
			"  `race` varchar(100) DEFAULT NULL,\n" + 
			"  `offense` varchar(100) DEFAULT NULL,\n" + 
			"  `offense_class_score` int(11) DEFAULT NULL,\n" + 
			"  `prior_court` varchar(60) DEFAULT NULL,\n" + 
			"  `prior_court_count` int(11) DEFAULT NULL,\n" + 
			"  `prior_court_score` int(11) DEFAULT NULL,\n" + 
			"  `past_findings` varchar(60) DEFAULT NULL,\n" + 
			"  `past_findings_count` int(11) DEFAULT NULL,\n" + 
			"  `past_findings_score` int(11) DEFAULT NULL,\n" + 
			"  `current_case_status` varchar(60) DEFAULT NULL,\n" + 
			"  `current_case_status_score` int(11) DEFAULT NULL,\n" + 
			"  `pending_petitions` varchar(60) DEFAULT NULL,\n" + 
			"  `pending_petitions_count` int(11) DEFAULT NULL,\n" + 
			"  `pending_petitions_score` int(11) DEFAULT NULL,\n" + 
			"  `under_home_confinement` varchar(10) DEFAULT NULL,\n" + 
			"  `under_home_confine_score` int(11) DEFAULT NULL,\n" + 
			"  `child_RA_age` varchar(30) DEFAULT NULL,\n" + 
			"  `child_RA_age_score` int(11) DEFAULT NULL,\n" + 
			"  `violations_elect_monitoring` varchar(60) DEFAULT NULL,\n" + 
			"  `violations_elect_monitoring_score` int(11) DEFAULT NULL,\n" + 
			"  `risk_FTA_reoffense` varchar(60) DEFAULT NULL,\n" + 
			"  `risk_FTA_reoffense_count` int(11) DEFAULT NULL,\n" + 
			"  `risk_FTA_reoffense_score` int(11) DEFAULT NULL,\n" + 
			"  `mitigating_stable_family` varchar(60) DEFAULT NULL,\n" + 
			"  `mitigating_stable_school_work` varchar(60) DEFAULT NULL,\n" + 
			"  `mitigating_first_offense_16` varchar(60) DEFAULT NULL,\n" + 
			"  `mitigating_reg_warrant` varchar(60) DEFAULT NULL,\n" + 
			"  `mitigating_reg_warrant_score` int(11) DEFAULT NULL,\n" + 
			"  `mitigating_reg_warrant_explain` varchar(255) DEFAULT NULL,\n" + 
			"  `mitigating_no_arrest` varchar(60) DEFAULT NULL,\n" + 
			"  `mitigating_other` varchar(60) DEFAULT NULL,\n" + 
			"  `mitigating_other_score` int(11) DEFAULT NULL,\n" + 
			"  `mitigating_other_explain` varchar(255) DEFAULT NULL,\n" + 
			"  `mitigating_total_score` int(11) DEFAULT NULL,\n" + 
			"  `RA_total_score` int(11) DEFAULT NULL,\n" + 
			"  `RA_detention_decision` varchar(60) DEFAULT NULL,\n" + 
			"  `override_reason` varchar(100) DEFAULT NULL,\n" + 
			"  `override_reason_explain` varchar(255) DEFAULT NULL,\n" + 
			"  `RA_date` varchar(20) DEFAULT NULL,\n" + 
			"  `RA_time` varchar(20) DEFAULT NULL,\n" + 
			"  `RA_counselor` varchar(60) DEFAULT NULL,\n" + 
			"  `RA_agency_name` varchar(100) DEFAULT NULL,\n" + 
			"  `RA_screener` varchar(60) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createContRiskTable();
	
	@SqlQuery("select * from cont_risk")
	List<ContRisk> getAll();
	
	@SqlQuery("select * from cont_risk where id = :id")
	ContRisk findById(@Bind("id") int id);
	
	@SqlQuery("select * from cont_risk where caseid = :caseid")
	ContRisk findByCaseId(@Bind("caseid") int caseid);
	
	@SqlUpdate("delete from cont_risk where id = :id")
	void deleteById(@Bind("id") int id);
	
	@SqlUpdate("delete from cont_risk where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") int caseid);
	
	@SqlUpdate("UPDATE `sword-test`.`cont_risk`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`fullname` = <{fullname: }>,\n" + 
			"`dob` = <{dob: }>,\n" + 
			"`age` = <{age: }>,\n" + 
			"`gender` = <{gender: }>,\n" + 
			"`race` = <{race: }>,\n" + 
			"`offense` = <{offense: }>,\n" + 
			"`offense_class_score` = <{offense_class_score: }>,\n" + 
			"`prior_court` = <{prior_court: }>,\n" + 
			"`prior_court_count` = <{prior_court_count: }>,\n" + 
			"`prior_court_score` = <{prior_court_score: }>,\n" + 
			"`past_findings` = <{past_findings: }>,\n" + 
			"`past_findings_count` = <{past_findings_count: }>,\n" + 
			"`past_findings_score` = <{past_findings_score: }>,\n" + 
			"`current_case_status` = <{current_case_status: }>,\n" + 
			"`current_case_status_score` = <{current_case_status_score: }>,\n" + 
			"`pending_petitions` = <{pending_petitions: }>,\n" + 
			"`pending_petitions_count` = <{pending_petitions_count: }>,\n" + 
			"`pending_petitions_score` = <{pending_petitions_score: }>,\n" + 
			"`under_home_confinement` = <{under_home_confinement: }>,\n" + 
			"`under_home_confine_score` = <{under_home_confine_score: }>,\n" + 
			"`child_RA_age` = <{child_RA_age: }>,\n" + 
			"`child_RA_age_score` = <{child_RA_age_score: }>,\n" + 
			"`violations_elect_monitoring` = <{violations_elect_monitoring: }>,\n" + 
			"`violations_elect_monitoring_score` = <{violations_elect_monitoring_score: }>,\n" + 
			"`risk_FTA_reoffense` = <{risk_FTA_reoffense: }>,\n" + 
			"`risk_FTA_reoffense_count` = <{risk_FTA_reoffense_count: }>,\n" + 
			"`risk_FTA_reoffense_score` = <{risk_FTA_reoffense_score: }>,\n" + 
			"`mitigating_stable_family` = <{mitigating_stable_family: }>,\n" + 
			"`mitigating_stable_school_work` = <{mitigating_stable_school_work: }>,\n" + 
			"`mitigating_first_offense_16` = <{mitigating_first_offense_16: }>,\n" + 
			"`mitigating_reg_warrant` = <{mitigating_reg_warrant: }>,\n" + 
			"`mitigating_reg_warrant_score` = <{mitigating_reg_warrant_score: }>,\n" + 
			"`mitigating_reg_warrant_explain` = <{mitigating_reg_warrant_explain: }>,\n" + 
			"`mitigating_no_arrest` = <{mitigating_no_arrest: }>,\n" + 
			"`mitigating_other` = <{mitigating_other: }>,\n" + 
			"`mitigating_other_score` = <{mitigating_other_score: }>,\n" + 
			"`mitigating_other_explain` = <{mitigating_other_explain: }>,\n" + 
			"`mitigating_total_score` = <{mitigating_total_score: }>,\n" + 
			"`RA_total_score` = <{RA_total_score: }>,\n" + 
			"`RA_detention_decision` = <{RA_detention_decision: }>,\n" + 
			"`override_reason` = <{override_reason: }>,\n" + 
			"`override_reason_explain` = <{override_reason_explain: }>,\n" + 
			"`RA_date` = <{RA_date: }>,\n" + 
			"`RA_time` = <{RA_time: }>,\n" + 
			"`RA_counselor` = <{RA_counselor: }>,\n" + 
			"`RA_agency_name` = <{RA_agency_name: }>,\n" + 
			"`RA_screener` = <{RA_screener: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean ContRisk ContRisk);
	
	@SqlUpdate("UPDATE `sword-test`.`cont_risk`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`fullname` = <{fullname: }>,\n" + 
			"`dob` = <{dob: }>,\n" + 
			"`age` = <{age: }>,\n" + 
			"`gender` = <{gender: }>,\n" + 
			"`race` = <{race: }>,\n" + 
			"`offense` = <{offense: }>,\n" + 
			"`offense_class_score` = <{offense_class_score: }>,\n" + 
			"`prior_court` = <{prior_court: }>,\n" + 
			"`prior_court_count` = <{prior_court_count: }>,\n" + 
			"`prior_court_score` = <{prior_court_score: }>,\n" + 
			"`past_findings` = <{past_findings: }>,\n" + 
			"`past_findings_count` = <{past_findings_count: }>,\n" + 
			"`past_findings_score` = <{past_findings_score: }>,\n" + 
			"`current_case_status` = <{current_case_status: }>,\n" + 
			"`current_case_status_score` = <{current_case_status_score: }>,\n" + 
			"`pending_petitions` = <{pending_petitions: }>,\n" + 
			"`pending_petitions_count` = <{pending_petitions_count: }>,\n" + 
			"`pending_petitions_score` = <{pending_petitions_score: }>,\n" + 
			"`under_home_confinement` = <{under_home_confinement: }>,\n" + 
			"`under_home_confine_score` = <{under_home_confine_score: }>,\n" + 
			"`child_RA_age` = <{child_RA_age: }>,\n" + 
			"`child_RA_age_score` = <{child_RA_age_score: }>,\n" + 
			"`violations_elect_monitoring` = <{violations_elect_monitoring: }>,\n" + 
			"`violations_elect_monitoring_score` = <{violations_elect_monitoring_score: }>,\n" + 
			"`risk_FTA_reoffense` = <{risk_FTA_reoffense: }>,\n" + 
			"`risk_FTA_reoffense_count` = <{risk_FTA_reoffense_count: }>,\n" + 
			"`risk_FTA_reoffense_score` = <{risk_FTA_reoffense_score: }>,\n" + 
			"`mitigating_stable_family` = <{mitigating_stable_family: }>,\n" + 
			"`mitigating_stable_school_work` = <{mitigating_stable_school_work: }>,\n" + 
			"`mitigating_first_offense_16` = <{mitigating_first_offense_16: }>,\n" + 
			"`mitigating_reg_warrant` = <{mitigating_reg_warrant: }>,\n" + 
			"`mitigating_reg_warrant_score` = <{mitigating_reg_warrant_score: }>,\n" + 
			"`mitigating_reg_warrant_explain` = <{mitigating_reg_warrant_explain: }>,\n" + 
			"`mitigating_no_arrest` = <{mitigating_no_arrest: }>,\n" + 
			"`mitigating_other` = <{mitigating_other: }>,\n" + 
			"`mitigating_other_score` = <{mitigating_other_score: }>,\n" + 
			"`mitigating_other_explain` = <{mitigating_other_explain: }>,\n" + 
			"`mitigating_total_score` = <{mitigating_total_score: }>,\n" + 
			"`RA_total_score` = <{RA_total_score: }>,\n" + 
			"`RA_detention_decision` = <{RA_detention_decision: }>,\n" + 
			"`override_reason` = <{override_reason: }>,\n" + 
			"`override_reason_explain` = <{override_reason_explain: }>,\n" + 
			"`RA_date` = <{RA_date: }>,\n" + 
			"`RA_time` = <{RA_time: }>,\n" + 
			"`RA_counselor` = <{RA_counselor: }>,\n" + 
			"`RA_agency_name` = <{RA_agency_name: }>,\n" + 
			"`RA_screener` = <{RA_screener: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean ContRisk ContRisk);
	
	@GetGeneratedKeys // Allows us to return the auto generated id to our client
	@SqlUpdate("INSERT INTO `sword-test`.`cont_risk`\n" + 
			"(`id`,\n" + 
			"`caseid`,\n" + 
			"`fullname`,\n" + 
			"`dob`,\n" + 
			"`age`,\n" + 
			"`gender`,\n" + 
			"`race`,\n" + 
			"`offense`,\n" + 
			"`offense_class_score`,\n" + 
			"`prior_court`,\n" + 
			"`prior_court_count`,\n" + 
			"`prior_court_score`,\n" + 
			"`past_findings`,\n" + 
			"`past_findings_count`,\n" + 
			"`past_findings_score`,\n" + 
			"`current_case_status`,\n" + 
			"`current_case_status_score`,\n" + 
			"`pending_petitions`,\n" + 
			"`pending_petitions_count`,\n" + 
			"`pending_petitions_score`,\n" + 
			"`under_home_confinement`,\n" + 
			"`under_home_confine_score`,\n" + 
			"`child_RA_age`,\n" + 
			"`child_RA_age_score`,\n" + 
			"`violations_elect_monitoring`,\n" + 
			"`violations_elect_monitoring_score`,\n" + 
			"`risk_FTA_reoffense`,\n" + 
			"`risk_FTA_reoffense_count`,\n" + 
			"`risk_FTA_reoffense_score`,\n" + 
			"`mitigating_stable_family`,\n" + 
			"`mitigating_stable_school_work`,\n" + 
			"`mitigating_first_offense_16`,\n" + 
			"`mitigating_reg_warrant`,\n" + 
			"`mitigating_reg_warrant_score`,\n" + 
			"`mitigating_reg_warrant_explain`,\n" + 
			"`mitigating_no_arrest`,\n" + 
			"`mitigating_other`,\n" + 
			"`mitigating_other_score`,\n" + 
			"`mitigating_other_explain`,\n" + 
			"`mitigating_total_score`,\n" + 
			"`RA_total_score`,\n" + 
			"`RA_detention_decision`,\n" + 
			"`override_reason`,\n" + 
			"`override_reason_explain`,\n" + 
			"`RA_date`,\n" + 
			"`RA_time`,\n" + 
			"`RA_counselor`,\n" + 
			"`RA_agency_name`,\n" + 
			"`RA_screener`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{caseid: }>,\n" + 
			"<{fullname: }>,\n" + 
			"<{dob: }>,\n" + 
			"<{age: }>,\n" + 
			"<{gender: }>,\n" + 
			"<{race: }>,\n" + 
			"<{offense: }>,\n" + 
			"<{offense_class_score: }>,\n" + 
			"<{prior_court: }>,\n" + 
			"<{prior_court_count: }>,\n" + 
			"<{prior_court_score: }>,\n" + 
			"<{past_findings: }>,\n" + 
			"<{past_findings_count: }>,\n" + 
			"<{past_findings_score: }>,\n" + 
			"<{current_case_status: }>,\n" + 
			"<{current_case_status_score: }>,\n" + 
			"<{pending_petitions: }>,\n" + 
			"<{pending_petitions_count: }>,\n" + 
			"<{pending_petitions_score: }>,\n" + 
			"<{under_home_confinement: }>,\n" + 
			"<{under_home_confine_score: }>,\n" + 
			"<{child_RA_age: }>,\n" + 
			"<{child_RA_age_score: }>,\n" + 
			"<{violations_elect_monitoring: }>,\n" + 
			"<{violations_elect_monitoring_score: }>,\n" + 
			"<{risk_FTA_reoffense: }>,\n" + 
			"<{risk_FTA_reoffense_count: }>,\n" + 
			"<{risk_FTA_reoffense_score: }>,\n" + 
			"<{mitigating_stable_family: }>,\n" + 
			"<{mitigating_stable_school_work: }>,\n" + 
			"<{mitigating_first_offense_16: }>,\n" + 
			"<{mitigating_reg_warrant: }>,\n" + 
			"<{mitigating_reg_warrant_score: }>,\n" + 
			"<{mitigating_reg_warrant_explain: }>,\n" + 
			"<{mitigating_no_arrest: }>,\n" + 
			"<{mitigating_other: }>,\n" + 
			"<{mitigating_other_score: }>,\n" + 
			"<{mitigating_other_explain: }>,\n" + 
			"<{mitigating_total_score: }>,\n" + 
			"<{RA_total_score: }>,\n" + 
			"<{RA_detention_decision: }>,\n" + 
			"<{override_reason: }>,\n" + 
			"<{override_reason_explain: }>,\n" + 
			"<{RA_date: }>,\n" + 
			"<{RA_time: }>,\n" + 
			"<{RA_counselor: }>,\n" + 
			"<{RA_agency_name: }>,\n" + 
			"<{RA_screener: }>);\n" + 
			"")
	int insert(@BindBean ContRisk ContRisk);
	
	void close();
}
