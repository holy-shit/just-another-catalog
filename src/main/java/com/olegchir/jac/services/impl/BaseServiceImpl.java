package com.olegchir.jac.services.impl;

import com.google.common.collect.Lists;
import com.googlecode.genericdao.search.*;
import com.olegchir.jac.dao.Dao;
import com.olegchir.jac.dao.DaoFactory;
import com.olegchir.jac.services.BaseService;
import com.olegchir.jac.services.SearchPage;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

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
    @Transactional(readOnly = true)
    public boolean exists(boolean distinct, Filter... filters) {
        return count(distinct, filters) > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public int count(boolean distinct, Filter... filters) {
        return createDao().count(new Search().setDistinct(distinct).setFilters(Lists.newArrayList(filters)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(boolean distinct) {
        return search(distinct, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> search(boolean distinct, Optional<SearchPage> page, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders) {
        return createDao().search(createSearch(distinct, page, filters, fetches, orders));
    }

    @Override
    @Transactional(readOnly = true)
    public SearchResult<T>  searchAndCount(boolean distinct, Optional<SearchPage> page, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders) {
        return createDao().searchAndCount(createSearch(distinct, page, filters, fetches, orders));
    }

    @Override
    @Transactional(readOnly = true)
    public T searchUnique(Optional<SearchPage> page, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders) {
        return createDao().searchUnique(createSearch(true, page, filters, fetches, orders));
    }

    @Override
    @Transactional(readOnly = false)
    public void removeById(ID id) {
        createDao().removeById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(T... entity) {
        createDao().save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> refresh(T... entity) {
        createDao().refresh(entity);
        return Arrays.asList(entity);
    }

    @Override
    @Transactional
    public T refresh(T entity) {
        createDao().refresh(entity);
        return entity;
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Collection<T> entities) {
        createDao().save(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public T find(ID id) {
        return createDao().find(id);
    }

    @Override
    @Transactional(readOnly = true)
    public T find(ID id, Optional<Collection<String>> fetches) {
        List<Filter> filters = Arrays.asList(Filter.equal("id", id));
        return searchUnique(Optional.empty(), Optional.of(filters), fetches, Optional.empty());
    }

    @Override
    @Transactional(readOnly = false)
    public boolean[] mergeSave(Collection<T> entityList) {
        return createDao().mergeSave(entityList);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean[] mergeSave(T... entity) {
        return createDao().mergeSave(entity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void flush() {
        createDao().flush();
    }

    private ISearch createSearch(boolean distinct, Optional<SearchPage> page, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders){
        IMutableSearch search = new Search().setDistinct(distinct);

        page.ifPresent(item -> {
            search.setPage(item.getPage()).setMaxResults(item.getSize());
        });
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
