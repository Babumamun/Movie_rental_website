package com.nsu.movie.service;

import com.nsu.movie.bean.Customer;
import com.nsu.movie.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    public Customer getCustomerById(int id,String pwd){
        return customerMapper.getCustomerById(id,pwd);
    }
//    public Customer getCustomerById(String pwd){
//        return customerMapper.getCustomerById(pwd);
//    }
    public int insertCustomer(String first, String last,String email,int pwd ){

        return customerMapper.insertCustomer(first,last,email,pwd);
    }
}