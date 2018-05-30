package edu.usm.sosw.sword.db;

import edu.usm.sosw.sword.api.CourtRelated;
import edu.usm.sosw.sword.mappers.CourtRelatedMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * This interface exists to provide proper access to the <code>static_court_related</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function
 * and then rewritten and executed by JDBI.
 *
 * The <code>CourtRelatedDAO</code> interface is used by the <code>CourtRelatedResource</code> class in the <code>resources</code> package.
 *
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>CourtRelatedMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>CourtRelated Object.</code>
 *
 * @author Sean T. Purvis
 * @version 0.0.1
 * @see CourtRelated &
 * @see CourtRelatedMapper
 */
@RegisterMapper(CourtRelatedMapper.class)
public interface CourtRelatedDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS `static_court_related` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `category` varchar(45) DEFAULT '',\n" +
            "  `description` varchar(100) DEFAULT '',\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;\n")
    void createCourtRelatedTable();

    @SqlQuery("select * from static_court_related")
    List<CourtRelated> getAll();

    @SqlQuery("select * from static_court_related where id = :id")
    CourtRelated findById(@Bind("id") int id);

    @SqlUpdate("delete from static_court_related where id = :id")
    void deleteById(@Bind("id") int id);

    @SqlUpdate("update static_court_related set"
             + "category = :category," +
            "description = :description," +
            "where id = :id")
    void update(@BindBean CourtRelated CourtRelated);

    @GetGeneratedKeys // Allows us to return the auto generated id to our client
    @SqlUpdate("insert into static_court_related (category, description)"
            + " values (:category, :description)")
    int insert(@BindBean CourtRelated CourtRelated);

    void close();

}
