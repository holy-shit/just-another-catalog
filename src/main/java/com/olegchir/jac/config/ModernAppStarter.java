package com.olegchir.jac.config;

import org.springframework.boot.SpringApplication;

import java.util.logging.Logger;

/**
 * Created by olegchir on 25/01/16.
 */

public class ModernAppStarter {
    protected Logger log = java.util.logging.Logger.getLogger(ModernAppStarter.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
