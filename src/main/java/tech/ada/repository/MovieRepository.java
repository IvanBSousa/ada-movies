package tech.ada.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import tech.ada.model.Movie;

import java.util.Optional;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {

    public Optional<Movie> findByTitle(String title) {
        return find("originalTitle", title).firstResultOptional();
    }

}
