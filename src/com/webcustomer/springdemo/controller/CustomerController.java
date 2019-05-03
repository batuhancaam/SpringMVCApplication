package com.webcustomer.springdemo.controller;

import com.webcustomer.springdemo.dao.CustomerDAO;
import com.webcustomer.springdemo.entity.Customer;
import com.webcustomer.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //need to inject the customer service

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model model){

        //get customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();
        //add the customer to the model
        model.addAttribute("customers",theCustomers);

        return "list-customers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "addcustomer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        //savve the customer using our service
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";

    }
    @GetMapping("/showFormForUpdate")
    public String  showFormForUpdate(@RequestParam("customerId") int theId, Model model){
        //get the customer from database

        Customer customer = customerService.getCustomers(theId);

        model.addAttribute("customer",customer);


        return"addcustomer-form";
    }

    @GetMapping("/delete")
    public String customerDelete(@RequestParam("customerId") int theId,Model model){

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }
}
