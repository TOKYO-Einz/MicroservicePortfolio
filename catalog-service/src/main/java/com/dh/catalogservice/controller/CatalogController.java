package com.dh.catalogservice.controller;

import com.dh.catalogservice.interfaces.ICatalog;
import com.dh.catalogservice.interfaces.ISerie;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.SerieService;
import com.dh.catalogservice.service.impl.MovieServiceListenerImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RefreshScope
@RestController
public class CatalogController {
    @Autowired
    private  ICatalog icatalog;
    @Autowired
    private  ISerie iSerie;
    @Autowired
    private  MovieServiceListenerImpl movieServiceListener;
    @Autowired
    private  SerieService serieService;


    @Value("${idRandom}")
    private String idRandom;


    @GetMapping("/catalog/{genre}")
    public ResponseEntity<Object> getMoviesByGenre(@PathVariable String genre){
        List<Object> Respuesta = new ArrayList<>();
        Respuesta.add(movieServiceListener.findAllByGenre(genre));
        Respuesta.add(serieService.findAllByGenre(genre));
        Map<String, Object> map = new HashMap<>();
        map.put(genre, Respuesta);
        return ResponseEntity.ok(map);
    }

    @PostMapping("/catalog/movie/save")
    public Movie createMovie(@RequestBody Movie movie){
        return icatalog.createMovie(movie);
    }

    @PostMapping("/catalog/serie/save")
    public ResponseEntity <Serie> createSerie(@RequestBody Serie serie, HttpServletResponse response){
        response.addHeader("instance id:", idRandom);
        return  ResponseEntity.ok().body(iSerie.saveSerie(serie));
    }


}
