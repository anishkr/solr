package com.test.solr.service;

import com.test.solr.model.Order;

import java.util.List;

public interface SolrService {

    Order save(Order order);

    Order findByOrderId(Long orderId);

    List<Order> getAllOrders();
}
