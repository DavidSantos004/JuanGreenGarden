package com.JuanGreenGarden.Gardening.persistence.entity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerSalesRepDTO {

    private String customerName;
    private String salesRepName;

    // Constructor, getters, and setters
    // Constructor, getters, and setters
    
    public CustomerSalesRepDTO() {
    }

    public CustomerSalesRepDTO(String customerName, String salesRepName) {
        this.customerName = customerName;
        this.salesRepName = salesRepName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesRepName() {
        return salesRepName;
    }

    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }

    public static List<CustomerSalesRepDTO> fromCustomers(List<Customer> customers) {
        return customers.stream()
                .map(customer -> new CustomerSalesRepDTO(customer.getCustomerName(), 
                                                          customer.getEmployeeField().getFirstName() + " " + customer.getEmployeeField().getLastName1()))
                .collect(Collectors.toList());
    }
}

