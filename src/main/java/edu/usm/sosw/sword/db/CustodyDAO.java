package edu.usm.sosw.sword.db;

import edu.usm.sosw.sword.api.Custody;
import edu.usm.sosw.sword.mappers.CustodyMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 *  * This interface exists to provide proper access to the <code>custody</code> table.
 *  * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 *  * and then rewritten and executed by JDBI.
 *  * 
 *  * The <code>CustodyDAO</code> interface is used by the <code>CustodyResources</code> class in the <code>resources</code> package.
 *  * 
 *  * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>CustodyMapper</code> class to this interface.
 *  * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 *  * to the </code>Custody Object.</code>
 *  * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * @see edu.usm.sosw.sword.api.Custody
 * @see edu.usm.sosw.sword.api.CustodyMapper
 */
@RegisterMapper(CustodyMapper.class)
public interface CustodyDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS `custody` (\n" +
            "`caseid` int(8) NOT NULL,\n" +
            " `id` int(8) NOT NULL AUTO_INCREMENT,\n" +
            "`date_changed` date DEFAULT NULL,\n" +
            "`changed_to` varchar(100) DEFAULT NULL,\n" +
            "PRIMARY KEY (`id`)\n" +
            " ) ENGINE=InnoDB AUTO_INCREMENT=819 DEFAULT CHARSET=latin1;\n")
    void createCustodyTable();

    @SqlQuery("select * from custody")
    List<Custody> getAll();

    @SqlQuery("select * from custody where id = :id")
    Custody findById(@Bind("id") int id);

    @SqlUpdate("delete from custody where id = :id")
    void deleteById(@Bind("id") int id);

    @SqlUpdate("UPDATE `sword-test`.`custody`\n" +
            "SET\n" +
            "`caseid` = <{caseid: }>,\n" +
            "`id` = <{id: }>,\n"+
            "`date_changed` = <{date_changed: }>,\n" +
            "`changed_to` = <{changed_to: }>\n" +
            "WHERE `id` = <{expr}>;\n")
    void update(@BindBean Custody Custody);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO `sword-test`.`custody`\n" +
            "(`caseid`,\n" +
            "`id`,\n" +
            "`date_changed`,\n" +
            "`changed_to`)\n" +
            "VALUES\n" +
            "(<{caseid: }>,\n" +
            "<{id: }>,\n" +
            "<{date_changed: }>,\n" +
            "<{changed_to: }>);\n")
    int insert(@BindBean Custody Custody);

    void close();
}
