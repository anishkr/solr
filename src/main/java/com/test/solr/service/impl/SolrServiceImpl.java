package com.test.solr.service.impl;

import com.test.solr.dao.SolrDAO;
import com.test.solr.model.Order;
import com.test.solr.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolrServiceImpl implements SolrService {

    private final SolrDAO solrDAO;

    @Autowired
    public SolrServiceImpl(SolrDAO solrDAO) {
        this.solrDAO = solrDAO;
    }

    @Override
    public Order save(Order order) {
        return solrDAO.save(order);
    }

    @Override
    public Order findByOrderId(Long orderId) {
        return solrDAO.findByOrderid(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        solrDAO.findAll().forEach(orders::add);
        return orders;
    }
}
