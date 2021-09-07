package com.test.solr.controller;

import com.test.solr.model.Order;
import com.test.solr.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SolrController {

    private final SolrService solrService;

    @Autowired
    public SolrController(SolrService solrService) {
        this.solrService = solrService;
    }

    @PostMapping
    @RequestMapping("/{version}/save")
    public ResponseEntity<Order> createOrder(Order order) {
        return new ResponseEntity<>(solrService.save(order), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/{version}/order/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable Long orderId) {
        return new ResponseEntity<>(solrService.findByOrderId(orderId), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{version}/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(solrService.getAllOrders(), HttpStatus.OK);
    }
}
