package com.olegchir.jac.config;

import org.springframework.boot.SpringApplication;

import java.util.logging.Logger;

/**
 * Created by olegchir on 25/01/16.
 */

public class AppStarter {
    protected Logger log = java.util.logging.Logger.getLogger(AppStarter.class.getName());

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application.yml");
        SpringApplication.run(App.class, args);
    }
}
