package com.olegchir.jac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by olegchir on 25/01/16.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();

        //http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#csrf
        http.csrf().disable();

        //http://docs.spring.io/spring-security/site/docs/3.2.0.CI-SNAPSHOT/reference/html/appendix-namespace.html#nsa-frame-options
        http.headers().frameOptions().disable();
    }
}