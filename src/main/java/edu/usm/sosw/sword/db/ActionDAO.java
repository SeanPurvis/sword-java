package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Action;
import edu.usm.sosw.sword.mappers.ActionMapper;
import edu.usm.sosw.sword.resources.ActionResource;

/** 
 * This interface exists to provide proper access to the <code>action</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>ActionDAO</code> interface is used by the <code>ActionResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>ActionMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Action Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Action 
 * @see ActionMapper 
 * @see ActionResource
 */
@RegisterMapper(ActionMapper.class)
public interface ActionDAO {
		
	@SqlUpdate("CREATE TABLE IF NOT EXISTS`actions` (\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `courtid` int(11) DEFAULT NULL,\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `date_of_action` date DEFAULT NULL,\n" + 
			"  `action_type` varchar(10) DEFAULT NULL,\n" + 
			"  `current_risk_level` varchar(10) DEFAULT NULL,\n" + 
			"  `abused` varchar(5) DEFAULT NULL,\n" + 
			"  `adolescent_offender_program` varchar(5) DEFAULT NULL,\n" + 
			"  `adjudicated` varchar(5) DEFAULT NULL,\n" + 
			"  `certified` varchar(5) DEFAULT NULL,\n" + 
			"  `child_in_need_special_care` varchar(5) DEFAULT NULL,\n" + 
			"  `chins` varchar(5) DEFAULT NULL,\n" + 
			"  `community_care` varchar(5) DEFAULT NULL,\n" + 
			"  `community_service` varchar(5) DEFAULT NULL,\n" + 
			"  `hours` varchar(50) DEFAULT NULL,\n" + 
			"  `counselor_supervision` varchar(5) DEFAULT NULL,\n" + 
			"  `dys` varchar(5) DEFAULT NULL,\n" + 
			"  `delinquent` varchar(5) DEFAULT NULL,\n" + 
			"  `dependent` varchar(5) DEFAULT NULL,\n" + 
			"  `detention` varchar(5) DEFAULT NULL,\n" + 
			"  `dismissed` varchar(5) DEFAULT NULL,\n" + 
			"  `drug_court` varchar(5) DEFAULT NULL,\n" + 
			"  `electronic_monitor` varchar(5) DEFAULT NULL,\n" + 
			"  `fined` varchar(5) DEFAULT NULL,\n" + 
			"  `fine_amount` varchar(15) DEFAULT NULL,\n" + 
			"  `held_open` varchar(5) DEFAULT NULL,\n" + 
			"  `intensive_supervision` varchar(5) DEFAULT NULL,\n" + 
			"  `legal_custody_change` varchar(5) DEFAULT NULL,\n" + 
			"  `lcc_dhs` varchar(5) DEFAULT NULL,\n" + 
			"  `lcc_relative_or_other` varchar(25) DEFAULT NULL,\n" + 
			"  `mycc` varchar(5) DEFAULT NULL,\n" + 
			"  `neglected` varchar(5) DEFAULT NULL,\n" + 
			"  `not_adjudicated` varchar(5) DEFAULT NULL,\n" + 
			"  `other` varchar(5) DEFAULT NULL,\n" + 
			"  `other2` varchar(255) DEFAULT ' ',\n" + 
			"  `physical_custody_change` varchar(5) DEFAULT NULL,\n" + 
			"  `pcc_dhs` varchar(5) DEFAULT NULL,\n" + 
			"  `pcc_relative_or_other` varchar(25) DEFAULT NULL,\n" + 
			"  `probation` varchar(5) DEFAULT NULL,\n" + 
			"  `prob_months_amt` int(11) DEFAULT 0,\n" + 
			"  `prob_extended` varchar(5) DEFAULT NULL,\n" + 
			"  `supervision_period_from` date DEFAULT NULL,\n" + 
			"  `supervision_period_to` date DEFAULT NULL,\n" + 
			"  `restitution` varchar(5) DEFAULT NULL,\n" + 
			"  `restitution_amount` varchar(15) DEFAULT NULL,\n" + 
			"  `returned_home` varchar(5) DEFAULT NULL,\n" + 
			"  `runaway` varchar(5) DEFAULT NULL,\n" + 
			"  `runaway_returned` varchar(5) DEFAULT NULL,\n" + 
			"  `status_offense` varchar(5) DEFAULT NULL,\n" + 
			"  `suspended_commitment` varchar(5) DEFAULT NULL,\n" + 
			"  `suspended_license` varchar(5) DEFAULT NULL,\n" + 
			"  `transferred` varchar(5) DEFAULT NULL,\n" + 
			"  `date_transported` date DEFAULT NULL,\n" + 
			"  `truant` varchar(5) DEFAULT NULL,\n" + 
			"  `unsupervised_prob` varchar(5) DEFAULT NULL,\n" + 
			"  `warned_adjusted_counseled` varchar(5) DEFAULT NULL,\n" + 
			"  `action_note` varchar(255) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=8483 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createActionsTable();
	
	@SqlQuery("select * from actions")
	List<Action> getAll();
	
	@SqlQuery("select * from actions where id = :id")
	Action findById(@Bind("id") int id);
	
	@SqlQuery("select * from actions where courtid = :courtid")
	Action findByCourtId(@Bind("courtid") int courtid);
	
	@SqlQuery("select * from actions where caseid = :caseid")
	Action findByCaseId(@Bind("caseid") int caseid);
	
	@SqlUpdate("delete from actions where id = :id")
	void deleteById(@Bind("id") int id);
	
	@SqlUpdate("delete from actions where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") int caseid);
	
	@SqlUpdate("delete from actions where courtid = :courtid")
	void deleteByCourtId(@Bind("courtid") int courtid);
	
	@SqlUpdate("UPDATE `sword-test`.`actions`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`courtid` = <{courtid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`date_of_action` = <{date_of_action: }>,\n" + 
			"`action_type` = <{action_type: }>,\n" + 
			"`current_risk_level` = <{current_risk_level: }>,\n" + 
			"`abused` = <{abused: }>,\n" + 
			"`adolescent_offender_program` = <{adolescent_offender_program: }>,\n" + 
			"`adjudicated` = <{adjudicated: }>,\n" + 
			"`certified` = <{certified: }>,\n" + 
			"`child_in_need_special_care` = <{child_in_need_special_care: }>,\n" + 
			"`chins` = <{chins: }>,\n" + 
			"`community_care` = <{community_care: }>,\n" + 
			"`community_service` = <{community_service: }>,\n" + 
			"`hours` = <{hours: }>,\n" + 
			"`counselor_supervision` = <{counselor_supervision: }>,\n" + 
			"`dys` = <{dys: }>,\n" + 
			"`delinquent` = <{delinquent: }>,\n" + 
			"`dependent` = <{dependent: }>,\n" + 
			"`detention` = <{detention: }>,\n" + 
			"`dismissed` = <{dismissed: }>,\n" + 
			"`drug_court` = <{drug_court: }>,\n" + 
			"`electronic_monitor` = <{electronic_monitor: }>,\n" + 
			"`fined` = <{fined: }>,\n" + 
			"`fine_amount` = <{fine_amount: }>,\n" + 
			"`held_open` = <{held_open: }>,\n" + 
			"`intensive_supervision` = <{intensive_supervision: }>,\n" + 
			"`legal_custody_change` = <{legal_custody_change: }>,\n" + 
			"`lcc_dhs` = <{lcc_dhs: }>,\n" + 
			"`lcc_relative_or_other` = <{lcc_relative_or_other: }>,\n" + 
			"`mycc` = <{mycc: }>,\n" + 
			"`neglected` = <{neglected: }>,\n" + 
			"`not_adjudicated` = <{not_adjudicated: }>,\n" + 
			"`other` = <{other: }>,\n" + 
			"`other2` = <{other2:  }>,\n" + 
			"`physical_custody_change` = <{physical_custody_change: }>,\n" + 
			"`pcc_dhs` = <{pcc_dhs: }>,\n" + 
			"`pcc_relative_or_other` = <{pcc_relative_or_other: }>,\n" + 
			"`probation` = <{probation: }>,\n" + 
			"`prob_months_amt` = <{prob_months_amt: 0}>,\n" + 
			"`prob_extended` = <{prob_extended: }>,\n" + 
			"`supervision_period_from` = <{supervision_period_from: }>,\n" + 
			"`supervision_period_to` = <{supervision_period_to: }>,\n" + 
			"`restitution` = <{restitution: }>,\n" + 
			"`restitution_amount` = <{restitution_amount: }>,\n" + 
			"`returned_home` = <{returned_home: }>,\n" + 
			"`runaway` = <{runaway: }>,\n" + 
			"`runaway_returned` = <{runaway_returned: }>,\n" + 
			"`status_offense` = <{status_offense: }>,\n" + 
			"`suspended_commitment` = <{suspended_commitment: }>,\n" + 
			"`suspended_license` = <{suspended_license: }>,\n" + 
			"`transferred` = <{transferred: }>,\n" + 
			"`date_transported` = <{date_transported: }>,\n" + 
			"`truant` = <{truant: }>,\n" + 
			"`unsupervised_prob` = <{unsupervised_prob: }>,\n" + 
			"`warned_adjusted_counseled` = <{warned_adjusted_counseled: }>,\n" + 
			"`action_note` = <{action_note: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Action Action);
	
	@SqlUpdate("UPDATE `sword-test`.`actions`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`courtid` = <{courtid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`date_of_action` = <{date_of_action: }>,\n" + 
			"`action_type` = <{action_type: }>,\n" + 
			"`current_risk_level` = <{current_risk_level: }>,\n" + 
			"`abused` = <{abused: }>,\n" + 
			"`adolescent_offender_program` = <{adolescent_offender_program: }>,\n" + 
			"`adjudicated` = <{adjudicated: }>,\n" + 
			"`certified` = <{certified: }>,\n" + 
			"`child_in_need_special_care` = <{child_in_need_special_care: }>,\n" + 
			"`chins` = <{chins: }>,\n" + 
			"`community_care` = <{community_care: }>,\n" + 
			"`community_service` = <{community_service: }>,\n" + 
			"`hours` = <{hours: }>,\n" + 
			"`counselor_supervision` = <{counselor_supervision: }>,\n" + 
			"`dys` = <{dys: }>,\n" + 
			"`delinquent` = <{delinquent: }>,\n" + 
			"`dependent` = <{dependent: }>,\n" + 
			"`detention` = <{detention: }>,\n" + 
			"`dismissed` = <{dismissed: }>,\n" + 
			"`drug_court` = <{drug_court: }>,\n" + 
			"`electronic_monitor` = <{electronic_monitor: }>,\n" + 
			"`fined` = <{fined: }>,\n" + 
			"`fine_amount` = <{fine_amount: }>,\n" + 
			"`held_open` = <{held_open: }>,\n" + 
			"`intensive_supervision` = <{intensive_supervision: }>,\n" + 
			"`legal_custody_change` = <{legal_custody_change: }>,\n" + 
			"`lcc_dhs` = <{lcc_dhs: }>,\n" + 
			"`lcc_relative_or_other` = <{lcc_relative_or_other: }>,\n" + 
			"`mycc` = <{mycc: }>,\n" + 
			"`neglected` = <{neglected: }>,\n" + 
			"`not_adjudicated` = <{not_adjudicated: }>,\n" + 
			"`other` = <{other: }>,\n" + 
			"`other2` = <{other2:  }>,\n" + 
			"`physical_custody_change` = <{physical_custody_change: }>,\n" + 
			"`pcc_dhs` = <{pcc_dhs: }>,\n" + 
			"`pcc_relative_or_other` = <{pcc_relative_or_other: }>,\n" + 
			"`probation` = <{probation: }>,\n" + 
			"`prob_months_amt` = <{prob_months_amt: 0}>,\n" + 
			"`prob_extended` = <{prob_extended: }>,\n" + 
			"`supervision_period_from` = <{supervision_period_from: }>,\n" + 
			"`supervision_period_to` = <{supervision_period_to: }>,\n" + 
			"`restitution` = <{restitution: }>,\n" + 
			"`restitution_amount` = <{restitution_amount: }>,\n" + 
			"`returned_home` = <{returned_home: }>,\n" + 
			"`runaway` = <{runaway: }>,\n" + 
			"`runaway_returned` = <{runaway_returned: }>,\n" + 
			"`status_offense` = <{status_offense: }>,\n" + 
			"`suspended_commitment` = <{suspended_commitment: }>,\n" + 
			"`suspended_license` = <{suspended_license: }>,\n" + 
			"`transferred` = <{transferred: }>,\n" + 
			"`date_transported` = <{date_transported: }>,\n" + 
			"`truant` = <{truant: }>,\n" + 
			"`unsupervised_prob` = <{unsupervised_prob: }>,\n" + 
			"`warned_adjusted_counseled` = <{warned_adjusted_counseled: }>,\n" + 
			"`action_note` = <{action_note: }>\n" + 
			"WHERE `caseid` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean Action Action);
	
	@SqlUpdate("UPDATE `sword-test`.`actions`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`courtid` = <{courtid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`date_of_action` = <{date_of_action: }>,\n" + 
			"`action_type` = <{action_type: }>,\n" + 
			"`current_risk_level` = <{current_risk_level: }>,\n" + 
			"`abused` = <{abused: }>,\n" + 
			"`adolescent_offender_program` = <{adolescent_offender_program: }>,\n" + 
			"`adjudicated` = <{adjudicated: }>,\n" + 
			"`certified` = <{certified: }>,\n" + 
			"`child_in_need_special_care` = <{child_in_need_special_care: }>,\n" + 
			"`chins` = <{chins: }>,\n" + 
			"`community_care` = <{community_care: }>,\n" + 
			"`community_service` = <{community_service: }>,\n" + 
			"`hours` = <{hours: }>,\n" + 
			"`counselor_supervision` = <{counselor_supervision: }>,\n" + 
			"`dys` = <{dys: }>,\n" + 
			"`delinquent` = <{delinquent: }>,\n" + 
			"`dependent` = <{dependent: }>,\n" + 
			"`detention` = <{detention: }>,\n" + 
			"`dismissed` = <{dismissed: }>,\n" + 
			"`drug_court` = <{drug_court: }>,\n" + 
			"`electronic_monitor` = <{electronic_monitor: }>,\n" + 
			"`fined` = <{fined: }>,\n" + 
			"`fine_amount` = <{fine_amount: }>,\n" + 
			"`held_open` = <{held_open: }>,\n" + 
			"`intensive_supervision` = <{intensive_supervision: }>,\n" + 
			"`legal_custody_change` = <{legal_custody_change: }>,\n" + 
			"`lcc_dhs` = <{lcc_dhs: }>,\n" + 
			"`lcc_relative_or_other` = <{lcc_relative_or_other: }>,\n" + 
			"`mycc` = <{mycc: }>,\n" + 
			"`neglected` = <{neglected: }>,\n" + 
			"`not_adjudicated` = <{not_adjudicated: }>,\n" + 
			"`other` = <{other: }>,\n" + 
			"`other2` = <{other2:  }>,\n" + 
			"`physical_custody_change` = <{physical_custody_change: }>,\n" + 
			"`pcc_dhs` = <{pcc_dhs: }>,\n" + 
			"`pcc_relative_or_other` = <{pcc_relative_or_other: }>,\n" + 
			"`probation` = <{probation: }>,\n" + 
			"`prob_months_amt` = <{prob_months_amt: 0}>,\n" + 
			"`prob_extended` = <{prob_extended: }>,\n" + 
			"`supervision_period_from` = <{supervision_period_from: }>,\n" + 
			"`supervision_period_to` = <{supervision_period_to: }>,\n" + 
			"`restitution` = <{restitution: }>,\n" + 
			"`restitution_amount` = <{restitution_amount: }>,\n" + 
			"`returned_home` = <{returned_home: }>,\n" + 
			"`runaway` = <{runaway: }>,\n" + 
			"`runaway_returned` = <{runaway_returned: }>,\n" + 
			"`status_offense` = <{status_offense: }>,\n" + 
			"`suspended_commitment` = <{suspended_commitment: }>,\n" + 
			"`suspended_license` = <{suspended_license: }>,\n" + 
			"`transferred` = <{transferred: }>,\n" + 
			"`date_transported` = <{date_transported: }>,\n" + 
			"`truant` = <{truant: }>,\n" + 
			"`unsupervised_prob` = <{unsupervised_prob: }>,\n" + 
			"`warned_adjusted_counseled` = <{warned_adjusted_counseled: }>,\n" + 
			"`action_note` = <{action_note: }>\n" + 
			"WHERE `courtid` = <{expr}>;\n" + 
			"")
	void updateByCourtId(@BindBean Action Action);
	
	@GetGeneratedKeys // Allows us to return the auto generated id to our client
	@SqlUpdate("INSERT INTO `sword-test`.`actions`\n" + 
			"(`caseid`,\n" + 
			"`courtid`,\n" + 
			"`id`,\n" + 
			"`date_of_action`,\n" + 
			"`action_type`,\n" + 
			"`current_risk_level`,\n" + 
			"`abused`,\n" + 
			"`adolescent_offender_program`,\n" + 
			"`adjudicated`,\n" + 
			"`certified`,\n" + 
			"`child_in_need_special_care`,\n" + 
			"`chins`,\n" + 
			"`community_care`,\n" + 
			"`community_service`,\n" + 
			"`hours`,\n" + 
			"`counselor_supervision`,\n" + 
			"`dys`,\n" + 
			"`delinquent`,\n" + 
			"`dependent`,\n" + 
			"`detention`,\n" + 
			"`dismissed`,\n" + 
			"`drug_court`,\n" + 
			"`electronic_monitor`,\n" + 
			"`fined`,\n" + 
			"`fine_amount`,\n" + 
			"`held_open`,\n" + 
			"`intensive_supervision`,\n" + 
			"`legal_custody_change`,\n" + 
			"`lcc_dhs`,\n" + 
			"`lcc_relative_or_other`,\n" + 
			"`mycc`,\n" + 
			"`neglected`,\n" + 
			"`not_adjudicated`,\n" + 
			"`other`,\n" + 
			"`other2`,\n" + 
			"`physical_custody_change`,\n" + 
			"`pcc_dhs`,\n" + 
			"`pcc_relative_or_other`,\n" + 
			"`probation`,\n" + 
			"`prob_months_amt`,\n" + 
			"`prob_extended`,\n" + 
			"`supervision_period_from`,\n" + 
			"`supervision_period_to`,\n" + 
			"`restitution`,\n" + 
			"`restitution_amount`,\n" + 
			"`returned_home`,\n" + 
			"`runaway`,\n" + 
			"`runaway_returned`,\n" + 
			"`status_offense`,\n" + 
			"`suspended_commitment`,\n" + 
			"`suspended_license`,\n" + 
			"`transferred`,\n" + 
			"`date_transported`,\n" + 
			"`truant`,\n" + 
			"`unsupervised_prob`,\n" + 
			"`warned_adjusted_counseled`,\n" + 
			"`action_note`)\n" + 
			"VALUES\n" + 
			"(<{caseid: }>,\n" + 
			"<{courtid: }>,\n" + 
			"<{id: }>,\n" + 
			"<{date_of_action: }>,\n" + 
			"<{action_type: }>,\n" + 
			"<{current_risk_level: }>,\n" + 
			"<{abused: }>,\n" + 
			"<{adolescent_offender_program: }>,\n" + 
			"<{adjudicated: }>,\n" + 
			"<{certified: }>,\n" + 
			"<{child_in_need_special_care: }>,\n" + 
			"<{chins: }>,\n" + 
			"<{community_care: }>,\n" + 
			"<{community_service: }>,\n" + 
			"<{hours: }>,\n" + 
			"<{counselor_supervision: }>,\n" + 
			"<{dys: }>,\n" + 
			"<{delinquent: }>,\n" + 
			"<{dependent: }>,\n" + 
			"<{detention: }>,\n" + 
			"<{dismissed: }>,\n" + 
			"<{drug_court: }>,\n" + 
			"<{electronic_monitor: }>,\n" + 
			"<{fined: }>,\n" + 
			"<{fine_amount: }>,\n" + 
			"<{held_open: }>,\n" + 
			"<{intensive_supervision: }>,\n" + 
			"<{legal_custody_change: }>,\n" + 
			"<{lcc_dhs: }>,\n" + 
			"<{lcc_relative_or_other: }>,\n" + 
			"<{mycc: }>,\n" + 
			"<{neglected: }>,\n" + 
			"<{not_adjudicated: }>,\n" + 
			"<{other: }>,\n" + 
			"<{other2:  }>,\n" + 
			"<{physical_custody_change: }>,\n" + 
			"<{pcc_dhs: }>,\n" + 
			"<{pcc_relative_or_other: }>,\n" + 
			"<{probation: }>,\n" + 
			"<{prob_months_amt: 0}>,\n" + 
			"<{prob_extended: }>,\n" + 
			"<{supervision_period_from: }>,\n" + 
			"<{supervision_period_to: }>,\n" + 
			"<{restitution: }>,\n" + 
			"<{restitution_amount: }>,\n" + 
			"<{returned_home: }>,\n" + 
			"<{runaway: }>,\n" + 
			"<{runaway_returned: }>,\n" + 
			"<{status_offense: }>,\n" + 
			"<{suspended_commitment: }>,\n" + 
			"<{suspended_license: }>,\n" + 
			"<{transferred: }>,\n" + 
			"<{date_transported: }>,\n" + 
			"<{truant: }>,\n" + 
			"<{unsupervised_prob: }>,\n" + 
			"<{warned_adjusted_counseled: }>,\n" + 
			"<{action_note: }>);\n" + 
			"")
	int insert(@BindBean Action Action);
	
	void close();
}
