package com.olegchir.jac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.util.logging.Logger;

/**
 * Created by olegchir on 27/01/16.
 */
public class LegacyAppStarter extends SpringBootServletInitializer {
    protected Logger log = java.util.logging.Logger.getLogger(LegacyAppStarter.class.getName());

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
