package com.olegchir.jac.services.impl;

import com.olegchir.jac.entities.Category;
import com.olegchir.jac.entities.Product;
import com.olegchir.jac.services.CategoryService;
import com.olegchir.jac.services.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created by olegchir on 26/01/16.
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {
    public CategoryServiceImpl() {
        super(Category.class);
    }
}
