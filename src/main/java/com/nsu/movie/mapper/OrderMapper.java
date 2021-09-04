package com.nsu.movie.mapper;

import com.nsu.movie.bean.Order;
import com.nsu.movie.bean.OrderDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Select("select * from order_detail where order_id=#{id}")
    public List<OrderDetail> getOrderDetailsByOrderID(int id);
    @Select("select * from film_order where customer_id=#{customer_id}")
    @Results({@Result(property = "id",column = "id"),
            @Result(property = "orderDetailList", column = "id",
                    many = @Many(select = "com.nsu.movie.mapper.OrderMapper.getOrderDetailsByOrderID"))})
    public List<Order> getOrdersByCutomerId(@Param("customer_id")int customer_id);
    @Insert("insert into film_order(create_time,total_price,customer_id) values (#{create_time},#{total_price},#{customer_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insertOrder(Order order);
    @Insert("insert into order_detail(film_id,count,order_id) values (#{film_id},#{count},#{order_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insertOrderDetail(OrderDetail orderDetail);
}