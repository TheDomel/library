package com.WebApp.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class Controller {

    @Autowired
    private MovieService movieService;

    @GetMapping("")
        public List<Movie> getAll() {
            return movieService.get();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") int id){
        Movie movieObj = movieService.get(id);
        if(movieObj == null){
            throw new RuntimeException("Movie with id: " + id + "is not found");
        }
        return movieObj;
    }

    @PostMapping("")
    public Movie save(@RequestBody Movie movieObj){
        movieService.save(movieObj);
        return movieObj;
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Movie movieObj){
        Movie movie = movieService.get(id);

        if (movie != null){
            movie.setName(movieObj.getName());
            movie.setRating(movieObj.getRating());

            movieService.save(movie);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Movie movieObj){
        Movie movie = movieService.get(id);

        if (movie != null){
            if (movieObj.getName() != null) movie.setName(movieObj.getName());
            if (movieObj.getRating() > 0) movie.setRating(movieObj.getRating());

            movieService.save(movie);
            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        movieService.delete(id);
        return "Movie has been deleated";
    }
}
