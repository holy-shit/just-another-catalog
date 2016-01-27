package com.olegchir.jac;

import com.olegchir.jac.config.App;
import com.olegchir.jac.entities.Category;
import com.olegchir.jac.entities.Product;
import com.olegchir.jac.services.core.CategoryService;
import com.olegchir.jac.services.core.ProductService;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by olegchir on 26/01/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
// "Fix" the following error: "A ServletContext is required to configure default servlet handling"
// Inspired by: http://stackoverflow.com/questions/21516683/java-lang-illegalargumentexception-a-servletcontext-is-required-to-configure-de
@WebAppConfiguration
public class ExampleTest {


    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void contextLoads() {
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