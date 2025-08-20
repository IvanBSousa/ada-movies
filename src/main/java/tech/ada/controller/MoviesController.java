package tech.ada.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.ada.dto.MovieDTO;
import tech.ada.dto.mapper.MovieMapper;
import tech.ada.exception.TitleAlreadyExistsException;
import tech.ada.model.Movie;
import tech.ada.repository.MovieRepository;
import tech.ada.service.CreateMovieService;

import java.util.List;

@Path("/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MoviesController {

//    @Inject
//    MovieRepository repository;

    private final MovieRepository repository;
    private final CreateMovieService createMovieService;

    public MoviesController(MovieRepository repository,
                            CreateMovieService createMovieService) {
        this.repository = repository;
        this.createMovieService = createMovieService;
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
        Movie movie = createMovieService.create(movieDto);
        return Response.status(Response.Status.CREATED).entity(movie).build();
    }

}
