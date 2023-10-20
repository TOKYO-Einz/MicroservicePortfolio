package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> findAllByGenre(String genre){return serieRepository.findAllByGenre(genre);}
    public Serie save(Serie serie){return serieRepository.save(serie);}

}
