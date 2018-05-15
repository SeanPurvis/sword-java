package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.MyUser;
import edu.usm.sosw.sword.mappers.UserMapper;

/** 
 * This interface exists to provide proper access to the <code>static_users</code> table.
 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>UserDAO</code> interface is used by the <code>UserResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>UserMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>User Object.</code>
 * 
 * @author Sean T. Purvis
 * @version 0.0.1 
 * @see MyUser 
 * @see UserMapper
 */
@RegisterMapper(UserMapper.class)
public interface UserDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS `static_users` (\n" + 
			"  `id` int NOT NULL AUTO_INCREMENT,\n" + 
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
	public void createMyUserTable();

	@SqlQuery("select * from static_users")
	public List<MyUser> getAll();
	
	@SqlQuery("select * from static_users where username = :username")
	public MyUser findByUsername(@Bind("username") String username);
	
	@SqlQuery("select * from static_users where id = :id")
	public MyUser findById(@Bind("id") int id);
	
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
	public void update(@BindBean MyUser MyUser);
	
	@GetGeneratedKeys // Allows us to return the auto generated id to our client.
	@SqlUpdate("insert into static_users (username, name, phone, password, employer, role, email)"
			+ " values (:username, :name, :phone, :password, :employer, :role, :email)")
	public int insert(@BindBean MyUser MyUser);

	public void close();
}
