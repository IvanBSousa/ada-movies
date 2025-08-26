package tech.ada.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import tech.ada.dto.MovieApiResponseDTO;

@Path("/movie")
@RegisterRestClient(configKey = "tmdb-api")
public interface TMDBMoviesClient {

    @GET
    MovieApiResponseDTO findAll(
            @HeaderParam("Authorization") String accessToken);

}
