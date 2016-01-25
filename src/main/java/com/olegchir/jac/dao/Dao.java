package com.olegchir.jac.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by olegchir on 25/01/16.
 */
public interface Dao<T, ID extends Serializable> extends GenericDAO<T,ID> {
    public void save(Collection<T> entities);
}