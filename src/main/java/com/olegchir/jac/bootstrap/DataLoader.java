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

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //TODO: data initialization here

        Category category = new Category();
        category.setName("catname");
        category.setDescription("catdescr");
        categoryService.save(category);
        Long categoryId = category.getId();

        Product product = new Product();
        product.setName("name");
        product.setDescription("description");
        product.setCategory(category);
        productService.save(product);
        Long productId = product.getId();

        categoryService.refresh(category);
        Set<Product> products = category.getProducts();

        for (Product item : products) {
            item.setCategory(null);
        }
        categoryService.mergeSave(category);
        categoryService.refresh(category);

        categoryService.removeById(categoryId);
        Product product2 = productService.find(productId, Optional.of(Arrays.asList("category")));
    }
}
