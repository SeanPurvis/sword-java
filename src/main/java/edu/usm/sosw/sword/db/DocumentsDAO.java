package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.Documents;
import edu.usm.sosw.sword.mappers.DocumentsMapper;
import edu.usm.sosw.sword.resources.DocumentsResource;

/** 
 * This interface exists to provide proper access to the <code>Documents</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>DocumentsDAO</code> interface is used by the <code>DocumentsResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>DocumentsMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Documents Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see Documents 
 * @see DocumentsMapper 
 * @see DocumentsResource
 */
@RegisterMapper(DocumentsMapper.class)
public interface DocumentsDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS`documents` (\n" + 
			"  `chargeid` int(8) DEFAULT 0,\n" + 
			"  `id` int(8) NOT NULL AUTO_INCREMENT,\n" + 
			"  `doc_name` varchar(255) DEFAULT NULL,\n" + 
			"  `text` longblob DEFAULT NULL,\n" + 
			"  `order_date` date DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=323 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createDocumentsTable();
	
	@SqlQuery("select * from documents")
	List<Documents> getAll();
	
	@SqlQuery("select * from documents where id =:id")
	Documents findById(@Bind("id") Integer id);
	
	@SqlQuery("select * from documents where chargeid = :chargeid")
	Documents findByChargeId(@Bind("chargeid") Integer chargeid);
	
	@SqlUpdate("delete from documents where id = :id")
	void deleteById(@Bind("id") Integer id);
	
	@SqlUpdate("delete from documents where chargeid = :chargeid")
	void deleteByChargeId(@Bind("chargeid") Integer chargeid);
	
	@SqlUpdate("UPDATE `sword-test`.`documents`\n" + 
			"SET\n" + 
			"`chargeid` = <{chargeid: 0}>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`doc_name` = <{doc_name: }>,\n" + 
			"`text` = <{text: }>,\n" + 
			"`order_date` = <{order_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateById(@BindBean Documents Documents);
	
	@SqlUpdate("UPDATE `sword-test`.`documents`\n" + 
			"SET\n" + 
			"`chargeid` = <{chargeid: 0}>,\n" + 
			"`id` = <{id: }>,\n" + 
			"`doc_name` = <{doc_name: }>,\n" + 
			"`text` = <{text: }>,\n" + 
			"`order_date` = <{order_date: }>\n" + 
			"WHERE `id` = <{expr}>;\n" + 
			"")
	void updateByChargeId(@BindBean Documents Documents);
	
	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO `sword-test`.`documents`\n" + 
			"(`chargeid`,\n" + 
			"`id`,\n" + 
			"`doc_name`,\n" + 
			"`text`,\n" + 
			"`order_date`)\n" + 
			"VALUES\n" + 
			"(<{chargeid: 0}>,\n" + 
			"<{id: }>,\n" + 
			"<{doc_name: }>,\n" + 
			"<{text: }>,\n" + 
			"<{order_date: }>);\n" + 
			"")
	int insert(@BindBean Documents Documents);
	
	void close();
}
