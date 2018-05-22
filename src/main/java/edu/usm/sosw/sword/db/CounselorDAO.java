package edu.usm.sosw.sword.db;

import java.util.List;

import edu.usm.sosw.sword.api.Counselor;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.mappers.CounselorMapper;

/** 
 * This interface exists to provide proper access to the <code>counselors</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>CounselorDAO</code> interface is used by the <code>CounselorResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>CounselorMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>Counselor Object.</code>
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @see Counselor 
 * @see CounselorMapper 
 * @see CounselorResource
 */
@RegisterMapper(CounselorMapper.class)
public interface CounselorDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS`counselors` (\n" +
            "  `id` int(4) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(100) DEFAULT NULL,\n" +
            "  `email` varchar(200) DEFAULT NULL,\n" +
            "  `status` int(1) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;\n")
    void createCounselorsTable();

    @SqlQuery("select * from counselors")
    List<Counselor> getAll();

    @SqlQuery("select * from counselors where name = :name")
    Counselor findByName(@Bind("name") String name);

    @SqlQuery("select * from counselors where id = :id")
    Counselor findById(@Bind("id") int id);

    @SqlUpdate("delete from counselors where id = :id")
    void deleteById(@Bind("id") int id);

    @SqlUpdate("update counselors set"
            + " name = :name,"
            + " email = :email,"
            + " status = :status,"
            + " where id = :id")
    void update(@BindBean Counselor Counselor);

    @GetGeneratedKeys // Allows us to return the auto generated id to our client.
    @SqlUpdate("insert into counselors (name )"
            + " values (:name)")
    int insert(@BindBean Counselor Counselor);

    void close();
}
