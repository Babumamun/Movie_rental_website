package com.nsu.movie.service;

import com.nsu.movie.bean.Order;
import com.nsu.movie.bean.OrderDetail;
import com.nsu.movie.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public int insertOrder(Order order){
        return orderMapper.insertOrder(order);
    }
    public int insertOrderDetail(OrderDetail orderDetail){
        return orderMapper.insertOrderDetail(orderDetail);
    }
    public List<Order> getOrdersByCutomerId(int customer_id){
        return orderMapper.getOrdersByCutomerId(customer_id);
    }
}