package edu.usm.sosw.sword;

import org.skife.jdbi.v2.DBI;

import edu.usm.sosw.sword.db.UserDAO;
import edu.usm.sosw.sword.resources.Authentication;
import edu.usm.sosw.sword.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SwordApplication extends Application<SwordConfiguration> {

	public static void main(final String[] args) throws Exception {
		new SwordApplication().run(args);
	}

	@Override
	public String getName() {
		return "Sword";
	}

	@Override
	public void initialize(final Bootstrap<SwordConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final SwordConfiguration configuration, final Environment environment) {
		// TODO: implement application
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
		final UserDAO dao = jdbi.onDemand(UserDAO.class);
		environment.jersey().register(new UserResource(dao));
		environment.jersey().register(new Authentication());
	}

}
