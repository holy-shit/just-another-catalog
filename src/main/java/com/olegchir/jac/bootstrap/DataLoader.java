package com.olegchir.jac.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by olegchir on 25/01/16.
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private Logger log = Logger.getLogger(DataLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
