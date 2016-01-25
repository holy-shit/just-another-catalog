package com.olegchir.jac.services;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by olegchir on 25/01/16.
 */
public interface BaseService<T, ID> {
    void save(T... entity);
}
