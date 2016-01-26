package com.olegchir.jac.services.core.impl;

import com.olegchir.jac.entities.Product;
import com.olegchir.jac.services.core.ProductService;
import com.olegchir.jac.services.framework.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by olegchir on 26/01/16.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {
    public ProductServiceImpl() {
        super(Product.class);
    }
}
