package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.repository.MovieRepository;
import com.dh.catalogservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceListenerImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> findAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
