package com.nsu.movie.mapper;

import com.nsu.movie.bean.Cart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CartMapper {
    @Select("select * from cart where customer_id=#{customer_id} and film_id=#{film_id}")
    Cart getById(@Param("customer_id") int customer_id,@Param("film_id") int film_id);

    @Update("update cart set film_count=#{film_count} where customer_id=#{customer_id} and film_id=#{film_id}")
    int update(Cart cart);

    @Insert("insert into cart values(#{customer_id},#{film_id},#{film_count})")
    int insert(Cart cart);
    @Delete("delete from cart where film_id=#{film_id} and customer_id=#{customer_id}")
    int delete(Cart cart);

}