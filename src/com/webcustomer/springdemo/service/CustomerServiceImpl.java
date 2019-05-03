package com.webcustomer.springdemo.service;

import com.webcustomer.springdemo.dao.CustomerDAO;
import com.webcustomer.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    //need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomers(int theId) {
        return customerDAO.getCustomers(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
         customerDAO.deleteCustomer(theId);
    }
}
