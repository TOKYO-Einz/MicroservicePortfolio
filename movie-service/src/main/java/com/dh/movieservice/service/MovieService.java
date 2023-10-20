package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.queue.MovieSender;
import com.dh.movieservice.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vaninagodoy
 */

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    private MovieSender movieSender;



    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie save(Movie movie,Boolean throwError) {
        if (throwError) {
            throw new RuntimeException();

        }else {
            movieSender.send(movie);
        }
        return movieRepository.save(movie);
    }
}
