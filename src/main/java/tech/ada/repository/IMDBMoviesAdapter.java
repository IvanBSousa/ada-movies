package tech.ada.repository;

import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import tech.ada.client.TMDBMoviesClient;
import tech.ada.dto.MovieDTO;

import java.util.List;

@ApplicationScoped
@IfBuildProfile("api")
public class IMDBMoviesAdapter implements MovieDataSource {

    @RestClient
    TMDBMoviesClient imdbMoviesClient;

    @ConfigProperty(name = "tmdb-api.api-token")
    String apiToken;

    @Override
    public List<MovieDTO> getMovies() {
        return imdbMoviesClient.findAll(
                "Bearer ".concat(apiToken)
        ).getResults();
    }
}
