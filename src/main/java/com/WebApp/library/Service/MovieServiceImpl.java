package com.WebApp.library.Service;

import com.WebApp.library.Model.Movie;
import com.WebApp.library.Model.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDAO movieDAO;

    @Transactional
    @Override
    public List<Movie> get() {
         return movieDAO.get();
    }

    @Transactional
    @Override
    public Movie get(int id) {
        return movieDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Movie movie) {
        movieDAO.save(movie);
    }

    @Transactional
    @Override
    public void delete(int id) {
        movieDAO.delete(id);
    }
}
