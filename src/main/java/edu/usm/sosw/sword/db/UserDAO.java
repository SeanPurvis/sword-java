package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import edu.usm.sosw.sword.api.User;

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
	void createUserTable();
	
	@SqlQuery("select * from static_users limit default")
	User[] getAll();
	
	@SqlQuery("select * from static_users WHERE id = :id")
	User findById(@Bind("id") int id);
	
	@SqlUpdate("delete from static_users where id = :id")
	int deleteById(@Bind("id") int id);
	
	@SqlUpdate("update static_user set"
			+ " username = :username,"
			+ " name = :name, password = :password,"
			+ " employer = :employer,"
			+ " role = :role,"
			+ " email = :email" 
			+ "where id = :id")
	int update(@BindBean User user);
	
	@SqlUpdate("insert into static_users (id, username, name, phone, password, employer, role, email)"
			+ " values (:id, :username, :name, :phone, :password, :employer, :role, :email)")
	int insert(@BindBean User user);

	
	@SqlUpdate 
	void close();
}
