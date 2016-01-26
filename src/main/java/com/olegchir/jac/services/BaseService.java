package com.olegchir.jac.services;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.SearchResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by olegchir on 25/01/16.
 */
public interface BaseService<T, ID> {
    List<T> search(boolean distinct, Optional<SearchPage> page, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders);
    SearchResult<T>  searchAndCount(boolean distinct, Optional<SearchPage> page, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders);
    T searchUnique(Optional<SearchPage> page, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders);
    List<T> findAll(boolean distinct);
    boolean exists(boolean distinct, Filter... filters);
    int count(boolean distinct, Filter... filters);
    void removeById(ID id);
    void save(T... entity);
    List<T> refresh(T... entity);
    T refresh(T entity);
    void save(Collection<T> entities);
    T find(ID id);
}
