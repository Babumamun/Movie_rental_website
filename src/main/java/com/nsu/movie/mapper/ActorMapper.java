package com.nsu.movie.mapper;

import com.nsu.movie.bean.Actor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActorMapper {
    @Select("select * from actor a,film_actor f where film_id=#{fid} and a.actor_id=f.actor_id")
    List<Actor> getActorsByFilmId(int fid);


}