package com.WebApp.library;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MovieDAOimpl implements MovieDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Movie> get() {
       Session currentSession = entityManager.unwrap(Session.class);
       Query<Movie> query = currentSession.createQuery("from Movie", Movie.class);
       List<Movie> list = query.getResultList();
       return list;
    }

    @Override
    public Movie get(int id) {
        Session cureentSession = entityManager.unwrap(Session.class);
        Movie movieObj = cureentSession.get(Movie.class, id);
        return movieObj;
    }

    @Override
    public void save(Movie movie) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(movie);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Movie movieObj = currentSession.get(Movie.class, id);
        currentSession.delete(movieObj);
    }
}
