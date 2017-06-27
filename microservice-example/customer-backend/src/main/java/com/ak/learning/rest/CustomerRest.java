package com.ak.learning.rest;

import com.ak.learning.dto.Customer;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Named
@Path("/")
public class CustomerRest {
    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setNome("Customer1");
        customer1.setEmail("customer1@gmail.com");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setNome("Customer1");
        customer2.setEmail("customer1@gmail.com");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setNome("Customer1");
        customer3.setEmail("customer1@gmail.com");

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setNome("Customer1");
        customer4.setEmail("customer1@gmail.com");

        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setNome("Customer1");
        customer5.setEmail("customer1@gmail.com");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customers;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@QueryParam("id") long id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }
}
