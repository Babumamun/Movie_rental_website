package com.nsu.movie.mapper;

import com.nsu.movie.bean.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerMapper {
//    @Select("select * from customer where pwd=#{pwd} ")
//    Customer getCustomerById(String pwd);
@Select("select * from customer where customer_id=#{id} and pwd=#{pwd}")
Customer getCustomerById(@Param("id")int id,@Param("pwd")String pwd);


//    @Insert("insert into customer (pwd,nickname) values(#{pwd},#{nickname});")
//    int insertCustomer(String pwd,String nickname);
    @Insert("insert into customer (first_name,last_name,email,pwd) values(#{first},#{last},#{email},#{pwd});")
    int insertCustomer(String first,String last ,String email,int pwd);
}
