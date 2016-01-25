package com.olegchir.jac.dao;

import com.olegchir.jac.dao.impl.DaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by olegchir on 25/01/16.
 */
@Repository
public class DaoFactory {
    @Autowired
    private SessionFactory sessionFactory;

    public <T, ID extends Serializable> Dao<T, ID> getDaoForClass(Class<T> clazz){
        Dao<T, ID> genDao = new DaoImpl<>(clazz);
        ((DaoImpl)genDao).setSessionFactory(sessionFactory);
        return genDao;
    }
}
