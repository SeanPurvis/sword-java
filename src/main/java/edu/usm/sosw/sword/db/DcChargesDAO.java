package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.DcCharges;
import edu.usm.sosw.sword.mappers.DcChargesMapper;
import edu.usm.sosw.sword.resources.DcChargesResource;

/** 
 * This interface exists to provide proper access to the <code>DcCharges</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>DcChargesDAO</code> interface is used by the <code>DcChargesResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>DcChargesMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>DcCharges Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see DcCharges 
 * @see DcChargesMapper 
 * @see DcChargesResource
 */
@RegisterMapper(DcChargesMapper.class)
public interface DcChargesDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `dc_charges` (\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `statute` varchar(15) DEFAULT '',\n" + 
			"  `class` varchar(1) DEFAULT '',\n" + 
			"  `offense_desc` varchar(100) DEFAULT '',\n" + 
			"  `book` int(11) DEFAULT NULL,\n" + 
			"  `page` int(11) DEFAULT NULL,\n" + 
			"  `line` int(11) DEFAULT NULL,\n" + 
			"  `offense_date` date DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=18526 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createDcChargesTable();
	
	@SqlQuery("select * from dc_charges")
	List<DcCharges> getAll();
	
	@SqlQuery("select * from dc_charges where id = :id")
	DcCharges findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from dc_charges where caseid = :caseid")
	DcCharges findByCaseid(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("delete from dc_charges where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from dc_charges where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("UPDATE `sword-test`.`dc_charges`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`statute` = <{statute: }>,\n" + 
			"`class` = <{class: }>,\n" + 
			"`offense_desc` = <{offense_desc: }>,\n" + 
			"`book` = <{book: }>,\n" + 
			"`page` = <{page: }>,\n" + 
			"`line` = <{line: }>,\n" + 
			"`offense_date` = <{offense_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean DcCharges DcCharges);
	
	@SqlUpdate("UPDATE `sword-test`.`dc_charges`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`statute` = <{statute: }>,\n" + 
			"`class` = <{class: }>,\n" + 
			"`offense_desc` = <{offense_desc: }>,\n" + 
			"`book` = <{book: }>,\n" + 
			"`page` = <{page: }>,\n" + 
			"`line` = <{line: }>,\n" + 
			"`offense_date` = <{offense_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean DcCharges DcCharges);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`dc_charges`\n" + 
			"(`caseid`,\n" + 
			"`id`,\n" + 
			"`statute`,\n" + 
			"`class`,\n" + 
			"`offense_desc`,\n" + 
			"`book`,\n" + 
			"`page`,\n" + 
			"`line`,\n" + 
			"`offense_date`)\n" + 
			"VALUES\n" + 
			"(<{caseid: }>,\n" + 
			"<{id: }>,\n" + 
			"<{statute: }>,\n" + 
			"<{class: }>,\n" + 
			"<{offense_desc: }>,\n" + 
			"<{book: }>,\n" + 
			"<{page: }>,\n" + 
			"<{line: }>,\n" + 
			"<{offense_date: }>);\n" + 
			"")
	int insert(@BindBean DcCharges DcCharges);
	
	void close();
}
