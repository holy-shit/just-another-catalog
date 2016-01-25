package com.olegchir.jac.services.impl;

import com.olegchir.jac.entities.Simple;
import com.olegchir.jac.services.SimpleService;
import org.springframework.stereotype.Service;

/**
 * Created by olegchir on 25/01/16.
 */
@Service
public class SimpleServiceImpl extends BaseServiceImpl<Simple, Long> implements SimpleService {
    public SimpleServiceImpl() {
        super(Simple.class);
    }
}
