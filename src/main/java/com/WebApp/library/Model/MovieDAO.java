package com.WebApp.library.Model;

import com.WebApp.library.Model.Movie;

import java.util.List;

public interface MovieDAO {

    List<Movie> get();
    Movie get(int id);
    void save(Movie movie);
    void delete (int id);
}
