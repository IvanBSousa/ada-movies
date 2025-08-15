package tech.ada.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import tech.ada.model.Movie;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {

    public Movie findByTitle(String title) {
        return find("title", title).firstResult();
    }

}
