package com.olegchir.jac.services.impl;

import com.olegchir.jac.dao.Dao;
import com.olegchir.jac.dao.DaoFactory;
import com.olegchir.jac.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by olegchir on 25/01/16.
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    protected final Class<T> clazz;

    @Autowired
    protected DaoFactory daoFactory;

    public BaseServiceImpl(Class<T> clazz) {
        this.clazz = clazz;
    }


    @Override
    @Transactional(readOnly = false)
    public void save(T... entity) {
        Dao<T, ID> dao = daoFactory.getDaoForClass(clazz);
        dao.save(entity);
    }

}
