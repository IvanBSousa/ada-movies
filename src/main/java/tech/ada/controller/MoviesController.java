package tech.ada.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.ada.dto.MovieDTO;
import tech.ada.dto.mapper.MovieMapper;
import tech.ada.model.Movie;
import tech.ada.repository.MovieRepository;

import java.util.List;

@Path("/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MoviesController {

//    @Inject
//    MovieRepository repository;

    private final MovieRepository repository;

    public MoviesController(MovieRepository repository) {
        this.repository = repository;
    }

    @GET
    public Response getMovies() {
        List<Movie> movies = repository.findAll().list();
        return Response.status(Response.Status.OK).entity(movies)
                .build();
    }

    @POST
    @Transactional
    public Response addMovie(MovieDTO movieDto) {
        repository.persist(MovieMapper.toEntity(movieDto));
        return Response.status(Response.Status.CREATED).entity(movieDto).build();
    }

}
