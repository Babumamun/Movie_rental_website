package com.nsu.movie.controller;

import com.nsu.movie.bean.Cart;
import com.nsu.movie.bean.Customer;
import com.nsu.movie.bean.Movie;
import com.nsu.movie.service.CartService;
import com.nsu.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private MovieService movieService;
    private List<Movie> movieList;
    @RequestMapping("/addtocart")
    @ResponseBody
    public String addToCart(int fid, HttpServletRequest request){
        int result=0;
        Customer customer=(Customer)request.getSession().getAttribute("customer");
        String msg="";
        int customer_id=customer.getCustomer_id();
        int film_count=1;
        Cart cart=cartService.getCartById(customer_id,fid);
        if(cart!=null){
            cart.setFilm_count(cart.getFilm_count()+1);
            result=cartService.update(cart);
        }else{
            Cart tempCart=new Cart();
            tempCart.setCustomer_id(customer_id);
            tempCart.setFilm_id(fid);
            tempCart.setFilm_count(1);
            result=cartService.insert(tempCart);
        }
        if(result>0)
            msg="Add to cart Successfully!";
        else
            msg="Add to cart Failed!";
        return msg;
    }
    @RequestMapping("/tocart")
    public String toCart(HttpServletRequest request, Model model){
        Customer customer=(Customer)request.getSession().getAttribute("customer");
        movieList=(List<Movie>) movieService.getMoviesByCustomerId(customer.getCustomer_id());
        model.addAttribute("movieList",movieList);
        return "cart";
    }
    @GetMapping("/delcart")
    public String delete(int fid,HttpServletRequest request,Model model){
        Customer customer=(Customer)request.getSession().getAttribute("customer");
        Cart cart=new Cart();
        cart.setCustomer_id(customer.getCustomer_id());
        cart.setFilm_id(fid);
        int result=0;
        result=cartService.delete(cart);
        movieList=(List<Movie>) movieService.getMoviesByCustomerId(customer.getCustomer_id());
        model.addAttribute("movieList",movieList);
        return "cartdata";
    }
}