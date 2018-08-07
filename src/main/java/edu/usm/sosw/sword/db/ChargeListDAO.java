package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Charge;
import edu.usm.sosw.sword.api.ChargeList;
import edu.usm.sosw.sword.mappers.ChargeListMapper;
import edu.usm.sosw.sword.mappers.ChargeMapper;
import edu.usm.sosw.sword.resources.ChargeResource;

/** 
 * This interface exists to provide proper access to the <code>ChargeList</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>ChargeListDAO</code> interface is used by the <code>ChargeListResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>ChargeListMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>ChargeList Object.</code>
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @see ChargeList 
 * @see ChargeListMapper 
 * @see ChargeListResource
 */
@RegisterMapper(ChargeListMapper.class)
public interface ChargeListDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_charge_list` (\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `category` varchar(45) NOT NULL DEFAULT '',\n" + 
			"  `description` varchar(100) NOT NULL DEFAULT '',\n" + 
			"  `statute` varchar(15) NOT NULL DEFAULT '',\n" + 
			"  `class` varchar(3) NOT NULL DEFAULT '',\n" + 
			"  `risk_assessment_value` int(3) NOT NULL DEFAULT 0,\n" + 
			"  `petition_name` varchar(100) NOT NULL DEFAULT 'PETITION',\n" + 
			"  `petition_child_declaration` varchar(1000) NOT NULL DEFAULT '',\n" + 
			"  `petition_crime_desc_template` varchar(1000) NOT NULL DEFAULT '',\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createChargeListTable();
	
	@SqlQuery("select * from static_charge_list")
	List<ChargeList> getAll();
	
	@SqlQuery("select * from static_charge_list where id = :id")
	ChargeList findById(@Bind("id") int id);
	
	@SqlUpdate("delete from static_charge_list where id = :id")
	void deleteById(@Bind("id") int id);
	
	@SqlUpdate("UPDATE `sword-test`.`static_charge_list`\n" + 
			"SET\n" + 
			"`id` = <{id: }>,\n" + 
			"`category` = <{category: }>,\n" + 
			"`description` = <{description: }>,\n" + 
			"`statute` = <{statute: }>,\n" + 
			"`class` = <{class: }>,\n" + 
			"`risk_assessment_value` = <{risk_assessment_value: 0}>,\n" + 
			"`petition_name` = <{petition_name: PETITION}>,\n" + 
			"`petition_child_declaration` = <{petition_child_declaration: }>,\n" + 
			"`petition_crime_desc_template` = <{petition_crime_desc_template: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean ChargeList ChargeList);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`static_charge_list`\n" + 
			"(`id`,\n" + 
			"`category`,\n" + 
			"`description`,\n" + 
			"`statute`,\n" + 
			"`class`,\n" + 
			"`risk_assessment_value`,\n" + 
			"`petition_name`,\n" + 
			"`petition_child_declaration`,\n" + 
			"`petition_crime_desc_template`)\n" + 
			"VALUES\n" + 
			"(<{id: }>,\n" + 
			"<{category: }>,\n" + 
			"<{description: }>,\n" + 
			"<{statute: }>,\n" + 
			"<{class: }>,\n" + 
			"<{risk_assessment_value: 0}>,\n" + 
			"<{petition_name: PETITION}>,\n" + 
			"<{petition_child_declaration: }>,\n" + 
			"<{petition_crime_desc_template: }>);\n" + 
			"")
	int insert(@BindBean ChargeList ChargeList);
	
	void close();
	
	
}
