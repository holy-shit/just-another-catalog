package com.olegchir.jac.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.olegchir.jac.dao.Dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by olegchir on 25/01/16.
 */
public class DaoImpl<T, ID extends Serializable> extends GenericDAOImpl<T, ID> implements Dao<T, ID> {

    public DaoImpl(){}

    public DaoImpl(Class<T> clazz){
        this.persistentClass = clazz;
    }

    @Override
    public void save(Collection<T> entities) {
        _saveOrUpdateIsNew(entities.toArray());
    }
}