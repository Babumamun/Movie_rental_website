package com.nsu.movie.bean;


public class Cart {
    private int customer_id;
    private int film_id;
    private int film_count;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getFilm_count() {
        return film_count;
    }

    public void setFilm_count(int film_count) {
        this.film_count = film_count;
    }
}