package tech.ada.service;

import jakarta.enterprise.context.ApplicationScoped;
import tech.ada.dto.MovieDTO;
import tech.ada.dto.mapper.MovieMapper;
import tech.ada.exception.TitleAlreadyExistsException;
import tech.ada.exception.TitleNotExistsException;
import tech.ada.model.GenreEnum;
import tech.ada.model.Movie;
import tech.ada.persistence.GenreRepository;
import tech.ada.persistence.MovieRepository;
import tech.ada.repository.MovieDataSource;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MovieService {

    private final MovieRepository repository;
    private final MovieDataSource movieDataSource;
    private final GenreRepository genreRepository;

    public MovieService(MovieRepository repository,
                        MovieDataSource movieDataSource,
                        GenreRepository genreRepository) {
        this.repository = repository;
        this.movieDataSource = movieDataSource;
        this.genreRepository = genreRepository;
    }

    public Movie create(MovieDTO movieDTO) {
        Optional<Movie> optionalMovie =
                repository.findByTitle(movieDTO.getOriginalTitle());

        if (optionalMovie.isPresent()) {
            throw new TitleAlreadyExistsException("The title already exists");
        }
        Movie movie = MovieMapper.toEntity(movieDTO);
        movie.setGenre(genreRepository.findById(
                GenreEnum.fromName(movieDTO.getGenre()).getId()));
        repository.persist(movie);
        return movie;
    }

    public MovieDTO getById(Long id) {
        return MovieMapper.toDTO(findById(id));
    }

    public List<MovieDTO> getAll() {
        return movieDataSource.getMovies();
    }

    public void update(Long id, MovieDTO movieDTO) {
        Movie movie = findById(id);
        MovieMapper.updateMovie(movieDTO, movie);
    }

    public void delete(Long id) {
        Movie movie = findById(id);
        repository.delete(movie);
    }

    private Movie findById(Long id) {
        Movie movie = repository.findById(id);
        if (movie == null) {
            throw new TitleNotExistsException("Title with id " + id + " not found");
        }
        return movie;
    }

}
