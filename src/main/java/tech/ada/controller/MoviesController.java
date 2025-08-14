package tech.ada.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.ada.model.Movie;

import java.util.List;

@Path("/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MoviesController {

    @GET
    public Response getMovies() {
        List<Movie> movies = Movie.findAll().list();
        return Response.status(Response.Status.OK).entity(movies)
                .build();
    }

    @POST
    @Transactional
    public Response addMovie(Movie movie) {
        Movie.persist(movie);
        return Response.status(Response.Status.CREATED).entity(movie).build();
    }



}
