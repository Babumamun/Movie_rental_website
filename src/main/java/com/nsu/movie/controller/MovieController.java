package com.nsu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsu.movie.bean.Movie;
import com.nsu.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {
    private int pageSize=20;
    Movie movie=null;
    int result=0;
    @Autowired
    private MovieService movieService;
    private List<Movie> movieList;
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }
    @GetMapping("/movies")
    public String getMoviesByTitle(Model model, @RequestParam(defaultValue = "") String title){
        if(title!=null && title!="")
            title=title.toUpperCase();
        movieList=movieService.getMovieList(title);
        model.addAttribute("movieList",movieList);
        return "movies";
    }
    @GetMapping("/movies2")
    public String getMoviesByTitlePages(Model model, @RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "1") int page){
        if(title!=null && title!="")
            title=title.toUpperCase();
        if(page<1)
            page=1;
        PageHelper.startPage(page,pageSize);
        movieList=movieService.getMovieList(title);
        PageInfo<Movie> pageInfo=new PageInfo<Movie>(movieList);
        model.addAttribute("pageInfo",pageInfo);
        return "movies2bytitle";
    }
    @GetMapping("/moviesbycategory")
    public String getMoviesByCategory(int id,Model model){
        movieList=movieService.getMovieByCategory(id);
        model.addAttribute("movies",movieList);
        return "movies";
    }
    @GetMapping("/moviesbycategory2")
    public String getMoviesByCategoryPages(int id,Model model,@RequestParam(defaultValue = "1") int page){
        if(page<1)
            page=1;
        PageHelper.startPage(page,pageSize);
        movieList=movieService.getMovieByCategory(id);
        PageInfo<Movie> pageInfo=new PageInfo<Movie>(movieList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("categoryid",id);
        return "movies2bycategory";
    }
    @GetMapping("/detail")
    public String toDetail(int id,Model model){
        System.out.println("id="+id);
        movie=movieService.getMovieById(id);
        model.addAttribute("movie",movie);
        return "moviedetail";
    }

    @RequestMapping("/order")
    public String order(){
        return "order";
    }

    @GetMapping("/redirect")
    public String redirect()
    {
        return "redirect:/index2";
    }

}