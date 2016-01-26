package com.olegchir.jac.services.core.impl;

import com.olegchir.jac.entities.Category;
import com.olegchir.jac.services.core.CategoryService;
import com.olegchir.jac.services.framework.BaseServiceImpl;
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
