package edu.usm.sosw.sword.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.usm.sosw.sword.api.PersonalProperty;
import edu.usm.sosw.sword.mappers.PersonalPropertyMapper;
import edu.usm.sosw.sword.resources.PersonalPropertyResource;

/** 
 * This interface exists to provide proper access to the <code>PersonalProperty</code> table.

 * SQL is written in the <code>SqlUpdate and SqlQuery</code> annotations above every function 
 * and then rewritten and executed by JDBI.
 * 
 * The <code>PersonalPropertyDAO</code> interface is used by the <code>PersonalPropertyResources</code> class in the <code>resources</code> package.
 * 
 * <code>RegisterMapper</code> annotation allows JDBI to bind the <code>PersonalPropertyMapper</code> class to this interface.
 * Without the <code>RegisterMapper</code> annotation, the SQL query results would not bind properly
 * to the </code>PersonalProperty Object.</code>
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @see PersonalProperty 
 * @see PersonalPropertyMapper 
 * @see PersonalPropertyResource
 */
@RegisterMapper(PersonalPropertyMapper.class)
public interface PersonalPropertyDAO {

		@SqlUpdate("CREATE TABLE IF NOT EXISTS `personal_property` (\n" + 
				"  `caseid` int(11) NOT NULL,\n" + 
				"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
				"  `locker_number` int(11) DEFAULT 0,\n" + 
				"  `currency` varchar(10) DEFAULT '0.00',\n" + 
				"  `belt` varchar(255) DEFAULT 'No',\n" + 
				"  `bra` varchar(255) DEFAULT 'No',\n" + 
				"  `dress` varchar(255) DEFAULT 'No',\n" + 
				"  `hat` varchar(255) DEFAULT 'No',\n" + 
				"  `jacket` varchar(255) DEFAULT 'No',\n" + 
				"  `leggings` varchar(255) DEFAULT 'No',\n" + 
				"  `pants` varchar(255) DEFAULT 'No',\n" + 
				"  `shirt` varchar(255) DEFAULT 'No',\n" + 
				"  `shoes` varchar(255) DEFAULT 'No',\n" + 
				"  `shorts` varchar(255) DEFAULT 'No',\n" + 
				"  `skirt` varchar(255) DEFAULT 'No',\n" + 
				"  `socks` varchar(255) DEFAULT 'No',\n" + 
				"  `underwear` varchar(255) DEFAULT 'No',\n" + 
				"  `bracelet` varchar(255) DEFAULT 'No',\n" + 
				"  `earrings` varchar(255) DEFAULT 'No',\n" + 
				"  `necklace` varchar(255) DEFAULT 'No',\n" + 
				"  `ring` varchar(255) DEFAULT 'No',\n" + 
				"  `watch` varchar(255) DEFAULT 'No',\n" + 
				"  `drugs` varchar(255) DEFAULT 'No',\n" + 
				"  `lighter` varchar(255) DEFAULT 'No',\n" + 
				"  `other_drugs` varchar(255) DEFAULT 'No',\n" + 
				"  `tobacco` varchar(255) DEFAULT 'No',\n" + 
				"  `weapons` varchar(255) DEFAULT 'No',\n" + 
				"  `other_property` varchar(1000) DEFAULT 'No',\n" + 
				"  `release_date` date DEFAULT '0000-00-00',\n" + 
				"  `release_to` varchar(100) DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;\n" + 
				"")
		void createPersonalPropertyTable();
		
		@SqlQuery("select * from personal_property")
		List<PersonalProperty> getAll();
		
		@SqlQuery("select * from personal_property where id = :id")
		PersonalProperty findById(@Bind("id") Integer id);
		
		@SqlQuery("select * from personal_property where caseid = :caseid")
		PersonalProperty findByCaseId(@Bind("caseid") Integer caseid);
		
		@SqlUpdate("delete from personal_property where id = :id")
		void deleteById(@Bind("id") Integer id);
		
		@SqlUpdate("delete from personal_property where caseid = :caseid")
		void deleteByCaseId(@Bind("caseid") Integer caseid);
		
		@SqlUpdate("UPDATE `sword-test`.`personal_property`\n" + 
				"SET\n" + 
				"`caseid` = <{caseid: }>,\n" + 
				"`id` = <{id: }>,\n" + 
				"`locker_number` = <{locker_number: 0}>,\n" + 
				"`currency` = <{currency: 0.00}>,\n" + 
				"`belt` = <{belt: No}>,\n" + 
				"`bra` = <{bra: No}>,\n" + 
				"`dress` = <{dress: No}>,\n" + 
				"`hat` = <{hat: No}>,\n" + 
				"`jacket` = <{jacket: No}>,\n" + 
				"`leggings` = <{leggings: No}>,\n" + 
				"`pants` = <{pants: No}>,\n" + 
				"`shirt` = <{shirt: No}>,\n" + 
				"`shoes` = <{shoes: No}>,\n" + 
				"`shorts` = <{shorts: No}>,\n" + 
				"`skirt` = <{skirt: No}>,\n" + 
				"`socks` = <{socks: No}>,\n" + 
				"`underwear` = <{underwear: No}>,\n" + 
				"`bracelet` = <{bracelet: No}>,\n" + 
				"`earrings` = <{earrings: No}>,\n" + 
				"`necklace` = <{necklace: No}>,\n" + 
				"`ring` = <{ring: No}>,\n" + 
				"`watch` = <{watch: No}>,\n" + 
				"`drugs` = <{drugs: No}>,\n" + 
				"`lighter` = <{lighter: No}>,\n" + 
				"`other_drugs` = <{other_drugs: No}>,\n" + 
				"`tobacco` = <{tobacco: No}>,\n" + 
				"`weapons` = <{weapons: No}>,\n" + 
				"`other_property` = <{other_property: No}>,\n" + 
				"`release_date` = <{release_date: 0000-00-00}>,\n" + 
				"`release_to` = <{release_to: }>\n" + 
				"WHERE `id` = <{expr}>;\n" + 
				"")
		void updateById(@BindBean PersonalProperty PersonalProperty);
		
		@SqlUpdate("UPDATE `sword-test`.`personal_property`\n" + 
				"SET\n" + 
				"`caseid` = <{caseid: }>,\n" + 
				"`id` = <{id: }>,\n" + 
				"`locker_number` = <{locker_number: 0}>,\n" + 
				"`currency` = <{currency: 0.00}>,\n" + 
				"`belt` = <{belt: No}>,\n" + 
				"`bra` = <{bra: No}>,\n" + 
				"`dress` = <{dress: No}>,\n" + 
				"`hat` = <{hat: No}>,\n" + 
				"`jacket` = <{jacket: No}>,\n" + 
				"`leggings` = <{leggings: No}>,\n" + 
				"`pants` = <{pants: No}>,\n" + 
				"`shirt` = <{shirt: No}>,\n" + 
				"`shoes` = <{shoes: No}>,\n" + 
				"`shorts` = <{shorts: No}>,\n" + 
				"`skirt` = <{skirt: No}>,\n" + 
				"`socks` = <{socks: No}>,\n" + 
				"`underwear` = <{underwear: No}>,\n" + 
				"`bracelet` = <{bracelet: No}>,\n" + 
				"`earrings` = <{earrings: No}>,\n" + 
				"`necklace` = <{necklace: No}>,\n" + 
				"`ring` = <{ring: No}>,\n" + 
				"`watch` = <{watch: No}>,\n" + 
				"`drugs` = <{drugs: No}>,\n" + 
				"`lighter` = <{lighter: No}>,\n" + 
				"`other_drugs` = <{other_drugs: No}>,\n" + 
				"`tobacco` = <{tobacco: No}>,\n" + 
				"`weapons` = <{weapons: No}>,\n" + 
				"`other_property` = <{other_property: No}>,\n" + 
				"`release_date` = <{release_date: 0000-00-00}>,\n" + 
				"`release_to` = <{release_to: }>\n" + 
				"WHERE `id` = <{expr}>;\n" + 
				"")
		void updateByCaseId(@BindBean PersonalProperty PersonalProperty);
		
		@GetGeneratedKeys
		@SqlUpdate("INSERT INTO `sword-test`.`personal_property`\n" + 
				"(`caseid`,\n" + 
				"`id`,\n" + 
				"`locker_number`,\n" + 
				"`currency`,\n" + 
				"`belt`,\n" + 
				"`bra`,\n" + 
				"`dress`,\n" + 
				"`hat`,\n" + 
				"`jacket`,\n" + 
				"`leggings`,\n" + 
				"`pants`,\n" + 
				"`shirt`,\n" + 
				"`shoes`,\n" + 
				"`shorts`,\n" + 
				"`skirt`,\n" + 
				"`socks`,\n" + 
				"`underwear`,\n" + 
				"`bracelet`,\n" + 
				"`earrings`,\n" + 
				"`necklace`,\n" + 
				"`ring`,\n" + 
				"`watch`,\n" + 
				"`drugs`,\n" + 
				"`lighter`,\n" + 
				"`other_drugs`,\n" + 
				"`tobacco`,\n" + 
				"`weapons`,\n" + 
				"`other_property`,\n" + 
				"`release_date`,\n" + 
				"`release_to`)\n" + 
				"VALUES\n" + 
				"(<{caseid: }>,\n" + 
				"<{id: }>,\n" + 
				"<{locker_number: 0}>,\n" + 
				"<{currency: 0.00}>,\n" + 
				"<{belt: No}>,\n" + 
				"<{bra: No}>,\n" + 
				"<{dress: No}>,\n" + 
				"<{hat: No}>,\n" + 
				"<{jacket: No}>,\n" + 
				"<{leggings: No}>,\n" + 
				"<{pants: No}>,\n" + 
				"<{shirt: No}>,\n" + 
				"<{shoes: No}>,\n" + 
				"<{shorts: No}>,\n" + 
				"<{skirt: No}>,\n" + 
				"<{socks: No}>,\n" + 
				"<{underwear: No}>,\n" + 
				"<{bracelet: No}>,\n" + 
				"<{earrings: No}>,\n" + 
				"<{necklace: No}>,\n" + 
				"<{ring: No}>,\n" + 
				"<{watch: No}>,\n" + 
				"<{drugs: No}>,\n" + 
				"<{lighter: No}>,\n" + 
				"<{other_drugs: No}>,\n" + 
				"<{tobacco: No}>,\n" + 
				"<{weapons: No}>,\n" + 
				"<{other_property: No}>,\n" + 
				"<{release_date: 0000-00-00}>,\n" + 
				"<{release_to: }>);\n" + 
				"")
		int insert(@BindBean PersonalProperty PersonalProperty);
		
		void close();
}
