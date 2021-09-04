package com.nsu.movie.mapper;

import com.nsu.movie.bean.Movie;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieMapper {
    @Select("select * from film_list where title like concat('%',#{title},'%')")
    List<Movie> selectMovieList(String title);

    @Select("select * from film f,film_category fc,category c where f.film_id=fc.film_id and c.category_id=fc.category_id and fc.category_id=#{category_id}")
    @Results({@Result(property = "fid", column = "film_id"),
            @Result(property = "category", column = "name")})
    List<Movie> searchByCategory(int category_id);

    @Select("select * from film where film_id=#{fid}")
    @Results({@Result(property = "fid", column = "film_id"),
            @Result(property = "actors", column = "film_id",
                    many = @Many(select = "com.nsu.movie.mapper.ActorMapper.getActorsByFilmId"))})
    Movie getMovieById(int fid);

    @Select("select * from cart c,film f where customer_id=#{customer_id} and c.film_id=f.film_id")
    List<Movie> getByCustomerId(@Param("customer_id") int customer_id);



    @Select("select f.*,f.film_id as fid,c.film_count as count from film f,cart c  where customer_id=#{customer_id} and c.film_id=f.film_id")
    List<Movie> getMoviesByCustomerId(@Param("customer_id") int customer_id);

    @Select("select film_id as fid,title,rental_rate from film where film_id=#{fid}")
    Movie getMovieById2(int fid);


}