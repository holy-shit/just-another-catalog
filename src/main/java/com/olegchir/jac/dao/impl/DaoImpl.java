package com.olegchir.jac.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.olegchir.jac.dao.Dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by olegchir on 25/01/16.
 */
public class DaoImpl<T, ID extends Serializable> extends GenericDAOImpl<T, ID> implements Dao<T, ID> {

    public DaoImpl(){}

    public DaoImpl(Class<T> clazz){
        this.persistentClass = clazz;
    }

    @Override
    public boolean[] save(Collection<T> entities) {
        return _saveOrUpdateIsNew(entities.toArray());
    }



    @Override
    public boolean[] mergeSave(Collection<T> entityList) {
        return save(entityList.stream().map(this::_merge).collect(Collectors.toList()));
    }

    @Override
    public boolean[] mergeSave(T[] entityArray) {
        return mergeSave(Arrays.asList(entityArray));
    }

    @Override
    public boolean mergeSave(T enity) {
        return save(_merge(enity));
    }
}