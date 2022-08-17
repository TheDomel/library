package com.WebApp.library;

import java.util.List;

public interface MovieService {
    List<Movie> get();

    Movie get(int id);
    void save(Movie movie);
    void delete(int id);

}
