package com.dh.catalogservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
@Data
@Document(collation = "Serie")
@RequiredArgsConstructor
public class Serie {
    @MongoId
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons = new ArrayList<>();

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Season {

        private Integer seasonNumber;
        private List<Chapter> chapters = new ArrayList<>();

        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        @Setter
        public static class Chapter {

            private String name;
            private Integer number;
            private String urlStream;


        }

    }
}
