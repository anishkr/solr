package com.test.solr.dao;

import com.test.solr.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SolrDAO extends SolrCrudRepository<Order, Long> {
    Order findByOrderid(Long orderid);

    @Facet(fields = { "cname" })
    FacetPage<Order> findByNameStartsWith(Collection<String> nameFragments, Pageable pagebale);
}
