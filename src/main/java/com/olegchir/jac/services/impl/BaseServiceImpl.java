package com.olegchir.jac.services.impl;

import com.google.common.collect.Lists;
import com.googlecode.genericdao.search.*;
import com.olegchir.jac.dao.Dao;
import com.olegchir.jac.dao.DaoFactory;
import com.olegchir.jac.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional(readOnly = true)
    public boolean exists(Filter... filters) {
        return count(filters) > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public int count(Filter... filters) {
        return createDao().count(new Search().setDistinct(true).setFilters(Lists.newArrayList(filters)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return search(-1, -1, Optional.empty(), Optional.empty(), Optional.empty());
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> search(int page, int count, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders) {
        return createDao().search(createSearch(page, count, filters, fetches, orders));
    }

    @Override
    @Transactional(readOnly = true)
    public SearchResult<T>  searchAndCount(int page, int count, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders) {
        return createDao().searchAndCount(createSearch(page, count, filters, fetches, orders));
    }

    @Override
    @Transactional(readOnly = true)
    public T searchUnique(int page, int count, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders) {
        return createDao().searchUnique(createSearch(page, count, filters, fetches, orders));
    }

    private ISearch createSearch(int page, int size, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders){
        IMutableSearch search = new Search().setDistinct(true).setPage(page).setMaxResults(size);

        filters.ifPresent(item -> search.setFilters(Lists.newArrayList(item)));
        fetches.ifPresent(item -> search.setFetches(Lists.newArrayList(item)));
        orders.ifPresent(item -> {
            List<Sort> sorts = new ArrayList<>();
            item.forEach(order -> sorts.add(new Sort(order)));
            search.setSorts(sorts);
        });

        return search;
    }

    public Dao<T, ID> createDao() {
        return daoFactory.getDaoForClass(clazz);
    }

}
