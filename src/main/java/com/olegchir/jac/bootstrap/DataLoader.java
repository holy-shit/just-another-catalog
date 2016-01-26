package com.olegchir.jac.bootstrap;

import com.olegchir.jac.entities.Product;
import com.olegchir.jac.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by olegchir on 25/01/16.
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ProductService productService;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //TODO: data initialization here
        Product product = new Product();
        product.setName("name");
        product.setDescription("description");

        productService.save(product);
        Long id = product.getId();
        Product product2 = productService.find(id);
        System.out.println(product2.getName());
    }
}
