package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.SerieService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SerieListener {
    @Autowired
    private SerieService serieService;



    @RabbitListener(queues = {"${queue.serie.name}"})
    public void recive(@Payload Serie serie){
        try {
            Thread.sleep(1000);
            serieService.save(serie);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
