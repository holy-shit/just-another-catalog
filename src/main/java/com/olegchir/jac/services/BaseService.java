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
    void save(T... entity);
    List<T> search(int page, int count, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders);
    SearchResult<T> searchAndCount(int page, int count, Optional<Collection<Filter>> filters, Optional<Collection<String>> fetches, Optional<Collection<String>> orders);
    List<T> findAll();
    boolean existsForFilters(Filter... filters);
    int countForFilters(Filter... filters);
}
