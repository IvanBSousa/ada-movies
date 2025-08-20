package tech.ada.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import tech.ada.dto.MovieDTO;
import tech.ada.dto.mapper.MovieMapper;
import tech.ada.exception.TitleAlreadyExistsException;
import tech.ada.model.Movie;
import tech.ada.repository.MovieRepository;

import java.util.Optional;

@ApplicationScoped
public class CreateMovieService {

    private final MovieRepository repository;

    public CreateMovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie create(MovieDTO movieDTO) {
        Optional<Movie> optinalMovie =
                repository.findByTitle(movieDTO.getOriginalTitle());

        if (optinalMovie.isPresent()) {
            throw new TitleAlreadyExistsException("The title already exists");
        }
        Movie movie = MovieMapper.toEntity(movieDTO);
        repository.persist(movie);
        return movie;
    }

}
