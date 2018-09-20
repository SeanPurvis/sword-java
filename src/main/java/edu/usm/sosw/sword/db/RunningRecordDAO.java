package edu.usm.sosw.sword.db;

import edu.usm.sosw.sword.api.RunningRecord;
import edu.usm.sosw.sword.mappers.RunningRecordMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * This interface exists to provide proper access to the <code>running_recordss</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function
 * and then rewritten and executed by JDBI.
 *
 * The <code>RunningRecordDAO</code> interface is used by the <code>RunningRecordResources</code> class in the <code>resources</code> package.
 *
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>RunningRecordMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>RunningRecord Object.</code>
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 * @see RunningRecord
 * @see RunningRecordMapper
 * @see RunningRecordResource
 */
@RegisterMapper(RunningRecordMapper.class)
public interface RunningRecordDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS `running_records` (\n" +
            "  `did` varchar(5) NOT NULL,\n" +
            "  `youthid` int(8) NOT NULL,\n" +
            "  `id` int(8) NOT NULL AUTO_INCREMENT,\n" +
            "  `noteid` int(8) NOT NULL,\n" +
            "  `notepartid` int(8) NOT NULL,\n" +
            "  `note` varchar(255) NOT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=MyISAM AUTO_INCREMENT=329998 DEFAULT CHARSET=latin1;\n")
    void createRunningRecordTable();

    @SqlQuery("select * from running_records")
    List<RunningRecord> getAll();

    @SqlQuery("select * from running_records where id = :id")
    RunningRecord findById(@Bind("id") int id);

    @SqlUpdate("delete from running_records where id = :id")
    void deleteById(@Bind("id") int id);

    @SqlUpdate("UPDATE `ms`.`running_records`\n" +
            "SET\n" +
            "`did` = <{did: }>,\n" +
            "`youthid` = <{youthid: }>,\n" +
            "`id` = <{id: }>,\n" +
            "`noteid` = <{noteid: }>,\n" +
            "`notepartid` = <{notepartid: }>,\n" +
            "`note` = <{note: }>\n" +
            "WHERE `id` = <{expr}>;\n")
    void update(@BindBean RunningRecord RunningRecord);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO `ms`.`running_records`\n" +
            "(`did`,\n" +
            "`youthid`,\n" +
            "`id`,\n" +
            "`noteid`,\n" +
            "`notepartid`,\n" +
            "`note`)\n" +
            "VALUES\n" +
            "(<{did: }>,\n" +
            "<{youthid: }>,\n" +
            "<{id: }>,\n" +
            "<{noteid: }>,\n" +
            "<{notepartid: }>,\n" +
            "<{note: }>);\n")
    int insert(@BindBean RunningRecord RunningRecord);

    void close();
}
