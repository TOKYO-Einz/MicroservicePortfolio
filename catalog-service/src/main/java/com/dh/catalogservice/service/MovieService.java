package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> findAllByGenre(String genre);

    public Movie save(Movie movie);
}
