package com.example.serieservice.controller;

import com.example.serieservice.model.Serie;
import com.example.serieservice.queue.SerieSender;
import com.example.serieservice.service.SerieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vaninagodoy
 */

@RestController
@RequestMapping("/api/v1/series")
@AllArgsConstructor
public class SerieController {

    private final SerieService serieService;
    private final SerieSender serieSender;



    @GetMapping
    public List<Serie> getAll() {
        return serieService.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping("/save")
    public ResponseEntity<Serie> create(@RequestBody Serie serie) {
        serieSender.send(serie);
        return ResponseEntity.ok().body(serieService.create(serie));
    }
}
