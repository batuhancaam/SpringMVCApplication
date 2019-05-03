package com.webcustomer.springdemo.dao;


import com.webcustomer.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    //need to injection session factory

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {

        //Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer ",Customer.class);
        //execute query and get the result list
        List<Customer> customers = theQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        //Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save the customer

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomers(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class,theId);

        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",theId);
        query.executeUpdate();
    }
}
