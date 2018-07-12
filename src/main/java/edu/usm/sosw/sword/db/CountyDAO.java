package edu.usm.sosw.sword.db;

import edu.usm.sosw.sword.api.County;
import edu.usm.sosw.sword.mappers.CountyMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/** 
 * This interface exists to provide proper access to the <code>static_counties</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>CountyDAO</code> interface is used by the <code>CountyResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>CountyMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>County Object.</code>
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @see County & 
 * @see CountyMapper
 */
@RegisterMapper(CountyMapper.class)
public interface CountyDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_counties` (\n" + 
			"  `id` int NOT NULL AUTO_INCREMENT,\n" + 
			"  `name` varchar(100) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`),\n" + 
			"  UNIQUE KEY `countiename` (`name`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=latin1;\n" + 
			"")
	void createCountyTable();
	
	@SqlQuery("select * from static_counties")
	List<County> getAll();
	
	@SqlQuery("select * from static_counties where name = :name")
	County findByName(@Bind("name") String name);
	
	@SqlQuery("select * from static_counties where id = :id")
	County findById(@Bind("id") int id);
	
	@SqlUpdate("delete from static_counties where id = :id")
	void deleteById(@Bind("id") int id);
	
	@SqlUpdate("update static_counties set"
			+ " name = :name,"
			+ " where id = :id")
	void update(@BindBean County County);
	
	@GetGeneratedKeys // Allows us to return the auto generated id to our client.
	@SqlUpdate("insert into static_counties (name )"
			+ " values (:name)")
	int insert(@BindBean County County);

	void close();
}
