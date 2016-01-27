package com.olegchir.jac.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by olegchir on 27/01/16.
 */
@Configuration
/**
 * "Fix" the follwing error: "Cannot forward to error page for request as the response has already been committed"
 * Seems to be Spring Boot configuration bug, when it's deployed using traditional deployment method
 * Therefore we should errors manually
 * Inspired by
 * http://stackoverflow.com/questions/30170586/how-to-disable-errorpagefilter-in-spring-boot
 * http://stackoverflow.com/questions/30459558/errorpagefilter-conflicting-with-responseentityexceptionhandler
 */
public class DisableErrorFilter {
    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

}
