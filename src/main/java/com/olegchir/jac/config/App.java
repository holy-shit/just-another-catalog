package com.olegchir.jac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;

/**
 * Created by olegchir on 25/01/16.
 */
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Import(AppConfig.class)
public class App {
    protected Logger log = java.util.logging.Logger.getLogger(App.class.getName());
}
