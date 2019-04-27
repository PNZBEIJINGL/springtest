package com.lambda;

import com.lambda.domain.Artist;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    //用于测试
    public static List<Artist> createArtistlist() {
        List<Artist> artists=new ArrayList<>();
        Artist artist1=new Artist();
        artist1.setName("Dianier Powter");
        Artist artist2=new Artist();
        artist2.setName("Linn");
        Artist artist3=new Artist();
        artist3.setName("Mcchen");
        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        return artists;
    }
}
