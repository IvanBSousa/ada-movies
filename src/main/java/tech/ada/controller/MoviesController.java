package tech.ada.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import tech.ada.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MoviesController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(
                new Movie(
                    "The Fantastic 4: First Steps",
                    "https://image.tmdb.org/t/p/w500/hlWOAWRKSno6UxaE0IXDFVvmzTf.jpg",
                    "No vibrante cenário de um mundo retrofuturista inspirado nos anos 1960, a Primeira Família da Marvel é forçada a equilibrar seus papéis como heróis com a força de seus laços familiares, enquanto defendem a Terra de um deus espacial voraz chamado Galactus e sua enigmática arauta, a Surfista Prateada.",
                        LocalDate.of(2025, 5, 15),
                        "Ação"
                )
        );
        return movies;
    }


}
