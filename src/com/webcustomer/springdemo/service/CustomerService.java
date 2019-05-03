package com.webcustomer.springdemo.service;

import com.webcustomer.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomers(int theId);

    public void deleteCustomer(int theId);
}
