package tech.ada.repository;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.arc.profile.UnlessBuildProfile;
import jakarta.enterprise.context.ApplicationScoped;
import tech.ada.dto.MovieDTO;
import tech.ada.dto.mapper.MovieMapper;
import tech.ada.persistence.MovieRepository;

import java.util.List;

@ApplicationScoped
@UnlessBuildProfile("api")
public class MovieDatabaseAdapter implements MovieDataSource {

    private final MovieRepository repository;

    public MovieDatabaseAdapter(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MovieDTO> getMovies() {
        return repository
                .findAll()
                .list()
                .stream()
                .map(MovieMapper::toDTO)
                .toList();
    }
}
