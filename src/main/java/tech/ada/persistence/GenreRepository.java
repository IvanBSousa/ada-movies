package tech.ada.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import tech.ada.model.Genre;

@ApplicationScoped
public class GenreRepository implements PanacheRepository<Genre> { }
