package com.olegchir.jac.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.logging.Logger;

/**
 * Created by olegchir on 25/01/16.
 */
@SpringBootApplication
@EnableJpaRepositories
@Import(AppConfig.class)
public class App {
    protected Logger log = java.util.logging.Logger.getLogger(App.class.getName());
}
