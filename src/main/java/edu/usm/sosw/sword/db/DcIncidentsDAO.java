package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.DcIncidents;
import edu.usm.sosw.sword.mappers.DcIncidentsMapper;
import edu.usm.sosw.sword.resources.DcIncidentsResource;

/** 
 * This interface exists to provide proper access to the <code>DcIncidents</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>DcIncidentsDAO</code> interface is used by the <code>DcIncidentsResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>DcIncidentsMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>DcIncidents Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see DcIncidents 
 * @see DcIncidentsMapper 
 * @see DcIncidentsResource
 */
@RegisterMapper(DcIncidentsMapper.class)
public interface DcIncidentsDAO {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `dc_incidents` (\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
			"  `doa` date DEFAULT NULL,\n" + 
			"  `doa_time` varchar(20) DEFAULT ' ',\n" + 
			"  `cell` varchar(45) DEFAULT NULL,\n" + 
			"  `booking_officer` varchar(100) DEFAULT NULL,\n" + 
			"  `arresting_officer` varchar(100) DEFAULT ' ',\n" + 
			"  `arresting_agency` varchar(100) DEFAULT NULL,\n" + 
			"  `attorney` varchar(100) DEFAULT ' ',\n" + 
			"  `docket` varchar(10) DEFAULT NULL,\n" + 
			"  `hold_for` varchar(255) DEFAULT ' ',\n" + 
			"  `hold_released_by` varchar(255) DEFAULT ' ',\n" + 
			"  `hold_released_date` date DEFAULT NULL,\n" + 
			"  `intake_notes` varchar(1000) DEFAULT ' ',\n" + 
			"  `releasing_date` date DEFAULT '0000-00-00',\n" + 
			"  `releasing_time` varchar(20) DEFAULT ' ',\n" + 
			"  `releasing_officer` varchar(100) DEFAULT NULL,\n" + 
			"  `releasing_how` varchar(255) DEFAULT ' ',\n" + 
			"  `releasing_authority` varchar(100) DEFAULT ' ',\n" + 
			"  `releasing_to` varchar(255) DEFAULT ' ',\n" + 
			"  `ordering_county` varchar(100) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=15740 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createDcIncidentsTable();
	
	@SqlQuery("select * from dc_incidents")
	List<DcIncidents> getAll();
	
	@SqlQuery("select * from dc_incidents where id = :id")
	DcIncidents findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from dc_incidents where caseid = :caseid")
	DcIncidents findByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("delete from dc_incidents where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from dc_incidents where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("UPDATE `sword-test`.`dc_incidents`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`doa` = <{doa: }>,\n" + 
			"`doa_time` = <{doa_time:  }>,\n" + 
			"`cell` = <{cell: }>,\n" + 
			"`booking_officer` = <{booking_officer: }>,\n" + 
			"`arresting_officer` = <{arresting_officer:  }>,\n" + 
			"`arresting_agency` = <{arresting_agency: }>,\n" + 
			"`attorney` = <{attorney:  }>,\n" + 
			"`docket` = <{docket: }>,\n" + 
			"`hold_for` = <{hold_for:  }>,\n" + 
			"`hold_released_by` = <{hold_released_by:  }>,\n" + 
			"`hold_released_date` = <{hold_released_date: }>,\n" + 
			"`intake_notes` = <{intake_notes:  }>,\n" + 
			"`releasing_date` = <{releasing_date: 0000-00-00}>,\n" + 
			"`releasing_time` = <{releasing_time:  }>,\n" + 
			"`releasing_officer` = <{releasing_officer: }>,\n" + 
			"`releasing_how` = <{releasing_how:  }>,\n" + 
			"`releasing_authority` = <{releasing_authority:  }>,\n" + 
			"`releasing_to` = <{releasing_to:  }>,\n" + 
			"`ordering_county` = <{ordering_county: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean DcIncidents DcIncidents);
	
	@SqlUpdate("UPDATE `sword-test`.`dc_incidents`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`doa` = <{doa: }>,\n" + 
			"`doa_time` = <{doa_time:  }>,\n" + 
			"`cell` = <{cell: }>,\n" + 
			"`booking_officer` = <{booking_officer: }>,\n" + 
			"`arresting_officer` = <{arresting_officer:  }>,\n" + 
			"`arresting_agency` = <{arresting_agency: }>,\n" + 
			"`attorney` = <{attorney:  }>,\n" + 
			"`docket` = <{docket: }>,\n" + 
			"`hold_for` = <{hold_for:  }>,\n" + 
			"`hold_released_by` = <{hold_released_by:  }>,\n" + 
			"`hold_released_date` = <{hold_released_date: }>,\n" + 
			"`intake_notes` = <{intake_notes:  }>,\n" + 
			"`releasing_date` = <{releasing_date: 0000-00-00}>,\n" + 
			"`releasing_time` = <{releasing_time:  }>,\n" + 
			"`releasing_officer` = <{releasing_officer: }>,\n" + 
			"`releasing_how` = <{releasing_how:  }>,\n" + 
			"`releasing_authority` = <{releasing_authority:  }>,\n" + 
			"`releasing_to` = <{releasing_to:  }>,\n" + 
			"`ordering_county` = <{ordering_county: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean DcIncidents DcIncidents);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`dc_incidents`\n" + 
			"(`caseid`,\n" + 
			"`id`,\n" + 
			"`doa`,\n" + 
			"`doa_time`,\n" + 
			"`cell`,\n" + 
			"`booking_officer`,\n" + 
			"`arresting_officer`,\n" + 
			"`arresting_agency`,\n" + 
			"`attorney`,\n" + 
			"`docket`,\n" + 
			"`hold_for`,\n" + 
			"`hold_released_by`,\n" + 
			"`hold_released_date`,\n" + 
			"`intake_notes`,\n" + 
			"`releasing_date`,\n" + 
			"`releasing_time`,\n" + 
			"`releasing_officer`,\n" + 
			"`releasing_how`,\n" + 
			"`releasing_authority`,\n" + 
			"`releasing_to`,\n" + 
			"`ordering_county`)\n" + 
			"VALUES\n" + 
			"(<{caseid: }>,\n" + 
			"<{id: }>,\n" + 
			"<{doa: }>,\n" + 
			"<{doa_time:  }>,\n" + 
			"<{cell: }>,\n" + 
			"<{booking_officer: }>,\n" + 
			"<{arresting_officer:  }>,\n" + 
			"<{arresting_agency: }>,\n" + 
			"<{attorney:  }>,\n" + 
			"<{docket: }>,\n" + 
			"<{hold_for:  }>,\n" + 
			"<{hold_released_by:  }>,\n" + 
			"<{hold_released_date: }>,\n" + 
			"<{intake_notes:  }>,\n" + 
			"<{releasing_date: 0000-00-00}>,\n" + 
			"<{releasing_time:  }>,\n" + 
			"<{releasing_officer: }>,\n" + 
			"<{releasing_how:  }>,\n" + 
			"<{releasing_authority:  }>,\n" + 
			"<{releasing_to:  }>,\n" + 
			"<{ordering_county: }>);\n" + 
			"")
	int insert(@BindBean DcIncidents DcIncidents);
	
	void close();
}
