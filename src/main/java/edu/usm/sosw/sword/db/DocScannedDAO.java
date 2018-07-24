package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.DocScanned;
import edu.usm.sosw.sword.mappers.DocScannedMapper;
import edu.usm.sosw.sword.resources.DocScannedResource;

/** 
 * This interface exists to provide proper access to the <code>DocScanned</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>DocScannedDAO</code> interface is used by the <code>DocScannedResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>DocScannedMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>DocScanned Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see DocScanned 
 * @see DocScannedMapper 
 * @see DocScannedResource
 */
@RegisterMapper(DocScannedMapper.class)
public interface DocScannedDAO {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `docscanned` (\n" + 
			"  `caseid` int(8) NOT NULL,\n" + 
			"  `id` int(7) NOT NULL AUTO_INCREMENT,\n" + 
			"  `doc_name` varchar(255) DEFAULT NULL,\n" + 
			"  `text` longblob DEFAULT NULL,\n" + 
			"  `order_date` date DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createDocScannedTable();
	
	@SqlQuery("select * from docscanned")
	List<DocScanned> getAll();
	
	@SqlQuery("select * from docscanned where caseid = :caseid")
	DocScanned findByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlQuery("select * from docscanned where id = :id")
	DocScanned findById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from docscanned where caseid = :caseid")
	void deleteByCaseId(@Bind("caseid") Integer caseid);
	
	@SqlUpdate("delete form docscanned where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("UPDATE `sword-test`.`docscanned`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`doc_name` = <{doc_name: }>,\n" + 
			"`text` = <{text: }>,\n" + 
			"`order_date` = <{order_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByCaseId(@BindBean DocScanned DocScanned);
	
	@SqlUpdate("UPDATE `sword-test`.`docscanned`\n" + 
			"SET\n" + 
			"`caseid` = <{caseid: }>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`doc_name` = <{doc_name: }>,\n" + 
			"`text` = <{text: }>,\n" + 
			"`order_date` = <{order_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean DocScanned DocScanned);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`docscanned`\n" + 
			"(`caseid`,\n" + 
			"`id`,\n" + 
			"`doc_name`,\n" + 
			"`text`,\n" + 
			"`order_date`)\n" + 
			"VALUES\n" + 
			"(<{caseid: }>,\n" + 
			"<{id: }>,\n" + 
			"<{doc_name: }>,\n" + 
			"<{text: }>,\n" + 
			"<{order_date: }>);\n" + 
			"")
	int insert(@BindBean DocScanned DocScanned);
	
	void close();
}
