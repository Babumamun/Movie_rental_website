package com.nsu.movie.service;

import com.nsu.movie.bean.Cart;
import com.nsu.movie.mapper.CartMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    public Cart getCartById( int customer_id, int film_id){
        return cartMapper.getById(customer_id,film_id);
    }
    public int update(Cart cart){
        return cartMapper.update(cart);
    }
    public int insert(Cart cart){
        return cartMapper.insert(cart);
    }
    public int delete(Cart cart){
        return cartMapper.delete(cart);
    }
}