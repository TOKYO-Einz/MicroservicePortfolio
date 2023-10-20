package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.impl.MovieServiceListenerImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {
    @Autowired
    private MovieServiceListenerImpl movieService;



    @RabbitListener(queues = {"${queue.movie.name}"})
    public void recive(@Payload Movie movie){
        try {
            Thread.sleep(4000);
            movieService.save(movie);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}