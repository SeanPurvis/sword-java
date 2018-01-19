package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import edu.usm.sosw.sword.api.User;
import edu.usm.sosw.sword.mappers.UserMapper;

/**
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * 
 * This interface exists to provide proper access to the static_users table.
 * SQL is written in the SqlUpdate and SqlQuery annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The UserDAO interface is used by the UserResources class in the resources package.
 * 
 * RegisterMapper annotation allows JDBI to bind the UserMapper class to this interface.
 * Without the RegisterMapper annotation, the SQL query results would not bind properly
 * to the User Object. 
 */

@RegisterMapper(UserMapper.class)
public interface UserDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_users` (\n" + 
			"  `id` int(6) NOT NULL AUTO_INCREMENT,\n" + 
			"  `username` varchar(20) NOT NULL,\n" + 
			"  `name` varchar(100) DEFAULT NULL,\n" + 
			"  `phone` varchar(20) DEFAULT NULL,\n" + 
			"  `password` varchar(512) NOT NULL,\n" + 
			"  `employer` varchar(150) DEFAULT NULL,\n" + 
			"  `role` varchar(32) DEFAULT NULL,\n" + 
			"  `email` varchar(200) NOT NULL DEFAULT '',\n" + 
			"  PRIMARY KEY (`id`),\n" + 
			"  UNIQUE KEY `username` (`username`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=latin1;\n" + 
			"")
	public void createUserTable();

	@SqlQuery("select * from static_users")
	public List<User> getAll();
	
	@SqlQuery("select * from static_users where username = :username")
	public User findByUsername(@Bind("username") String username);
	
	@SqlQuery("select * from static_users where id = :id")
	public User findById(@Bind("id") int id);
	
	@SqlUpdate("delete from static_users where id = :id")
	public void deleteById(@Bind("id") int id);
	
	@SqlUpdate("update static_users set"
			+ " username = :username,"
			+ " name = :name,"
			+ " password = :password,"
			+ " phone = :phone,"
			+ " employer = :employer,"
			+ " role = :role,"
			+ " email = :email" 
			+ " where id = :id")
	public void update(@BindBean User user);
	
	@GetGeneratedKeys // Allows us to return the auto generated id to our client.
	@SqlUpdate("insert into static_users (username, name, phone, password, employer, role, email)"
			+ " values (:username, :name, :phone, :password, :employer, :role, :email)")
	public int insert(@BindBean User user);

	public void close();
}
