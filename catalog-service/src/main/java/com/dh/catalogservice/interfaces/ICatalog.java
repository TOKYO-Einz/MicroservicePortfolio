package com.dh.catalogservice.interfaces;


import com.dh.catalogservice.LoadBalancer.LoadBalancerConfiguration;
import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "movie-service")
@LoadBalancerClient(name = "movie-service", configuration = LoadBalancerConfiguration.class)
public interface ICatalog {
    @GetMapping("/api/v1/movies/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre);

    @PostMapping("/api/v1/movies/save")
    public Movie createMovie(@RequestBody Movie movie);
}
