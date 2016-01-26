package com.olegchir.jac.bootstrap;

import com.olegchir.jac.entities.Category;
import com.olegchir.jac.entities.Product;
import com.olegchir.jac.services.CategoryService;
import com.olegchir.jac.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

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
