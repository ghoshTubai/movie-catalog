package com.ghoshtubai.movie.moviecatalog.resource;

import com.ghoshtubai.movie.moviecatalog.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies/")
public class MovieResource {
    @Autowired
    RestTemplate restTemplate;
   // @
   @Value("${api_key}")
    private String API_KEYS;
    @GetMapping("{title}")
    public Movie getMovieByTitle(@PathVariable final String title){
        String url = "http://www.omdbapi.com/?t="+title+"&apikey="+API_KEYS;
        ResponseEntity<Movie> movie = restTemplate.exchange(url, HttpMethod.GET,null,
                new ParameterizedTypeReference<Movie>() {
                });
        return movie.getBody();
    }
}
