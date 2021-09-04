package com.nsu.movie.service;

import com.nsu.movie.bean.Movie;
import com.nsu.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieMapper movieMapper;
    public List<Movie> getMovieList(String title){
        return movieMapper.selectMovieList(title);
    }
    public List<Movie> getMovieByCategory(int category_id){
        return movieMapper.searchByCategory(category_id);
    }
    public Movie getMovieById(int fid){
        return movieMapper.getMovieById(fid);
    }
    public List<Movie> getBycustomer_id(int customer_id){
        return movieMapper.getByCustomerId(customer_id);
    }

    public List<Movie> getMoviesByCustomerId(int customer_id){
        return movieMapper.getMoviesByCustomerId(customer_id);
    }
    public Movie getMovieById2(int fid){
        return movieMapper.getMovieById2(fid);
    }
}