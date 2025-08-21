package tech.ada.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;
import tech.ada.dto.MovieDTO;
import tech.ada.model.Movie;
import tech.ada.service.MovieService;

import java.util.List;

@Path("/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MoviesController {

    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GET
    public Response getMovies() {
        List<MovieDTO> movies = movieService.getAll();
        return Response
                .status(Response.Status.OK)
                .entity(movies)
                .build();
    }

    @Path("/{id}")
    @GET
    public Response getById(@RestPath Long id) {
        return Response
                .status(Response.Status.OK)
                .entity(movieService.getById(id))
                .build();
    }

    @POST
    @Transactional
    public Response addMovie(MovieDTO movieDto) {
        Movie movie = movieService.create(movieDto);
        return Response.status(Response.Status.CREATED).entity(movie).build();
    }

    @Path("/{id}")
    @PUT
    @Transactional
    public Response updateMovie(@RestPath Long id, MovieDTO movieDto) {
        movieService.update(id, movieDto);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}")
    @DELETE
    @Transactional
    public Response deleteMovie(@RestPath Long id) {
        movieService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
