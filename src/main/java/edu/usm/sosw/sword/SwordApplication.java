package com.sosw.sword;

import io.dropwizard.Application;
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
    public void run(final SwordConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
