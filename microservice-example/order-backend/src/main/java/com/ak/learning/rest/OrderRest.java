package com.ak.learning.rest;

import com.ak.learning.dto.Customer;
import com.ak.learning.dto.Order;
import com.ak.learning.dto.Product;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Named
@Path("/")
public class OrderRest {
    private long id = 1;

    @Inject
    private RestTemplate restTemplate;

    public Order submitOrder (
            @QueryParam("customerId") long customerId
            , @QueryParam("productId") long productId
            , @QueryParam("amount") long amount) {
        Order order = new Order();
        Customer customer = restTemplate.getForObject("http://localhost:8081/customer?id={id}", Customer.class, customerId);
        Product product = restTemplate.getForObject("http://localhost:8081/product?id={id}", Product.class, productId);

        order.setCustomer(customer);
        order.setProduct(product);
        order.setId(id);

        return order;
    }
}
