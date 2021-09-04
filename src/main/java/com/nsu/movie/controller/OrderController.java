package com.nsu.movie.controller;

import com.nsu.movie.bean.Customer;
import com.nsu.movie.bean.Movie;
import com.nsu.movie.bean.Order;
import com.nsu.movie.bean.OrderDetail;
import com.nsu.movie.service.MovieService;
import com.nsu.movie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private Order order;
    private OrderDetail orderDetail;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MovieService movieService;
    @RequestMapping("/orderlist")
    public String orderList(HttpServletRequest request, Model model){
        Customer customer=(Customer)request.getSession().getAttribute("customer");
        List<Order> orderList=orderService.getOrdersByCutomerId(customer.getCustomer_id());
        for(Order order:orderList)
            System.out.println("id="+order.getId());
        model.addAttribute("orderList",orderList);
        return "orderlist";
    }
    @RequestMapping("/addorder")
    public String addOrder(HttpServletRequest request){
        int customer_id=((Customer)request.getSession().getAttribute("customer")).getCustomer_id();
        List<Movie> movieList=(List<Movie>)request.getSession().getAttribute("movieList");
        String f="yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat sdf=new SimpleDateFormat(f);
        String strDate=sdf.format(System.currentTimeMillis());
        order=new Order();
        order.setCustomer_id(customer_id);
        order.setCreate_time(strDate);
        order.setTotal_price((double)request.getSession().getAttribute("totalPrice"));
        orderService.insertOrder(order);
        for(Movie movie:movieList){
            orderDetail=new OrderDetail();
            orderDetail.setFilm_id(movie.getFid());
            orderDetail.setCount(movie.getCount());
            orderDetail.setOrder_id(order.getId());
            orderService.insertOrderDetail(orderDetail);
        }
        return "redirect:/orderlist";
    }
    @ResponseBody
    @RequestMapping("/toorder")
    public String toOrder(@RequestBody List<Movie> movieList, HttpServletRequest request){
        List<Movie> newMovieList=new ArrayList<Movie>() ;
        Movie tempMovie;
        double totalPrice=0.0;
        int count=0;
        for(Movie movie:movieList){
            tempMovie=movieService.getMovieById2(movie.getFid());
            count=movie.getCount();
            tempMovie.setCount(count);
            totalPrice+=tempMovie.getRental_rate()*count;
            newMovieList.add(tempMovie);
        }
        DecimalFormat df=new DecimalFormat("#.00");
        totalPrice=Double.parseDouble(df.format(totalPrice));
        request.getSession().setAttribute("totalPrice",totalPrice);
        request.getSession().setAttribute("movieList",newMovieList);
        return "{}";
    }

}
