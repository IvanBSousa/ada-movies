package tech.ada.dto.mapper;

import tech.ada.dto.MovieDTO;
import tech.ada.model.Movie;

public class MovieMapper {

    public static Movie toEntity(MovieDTO movieDTO) {
        if (movieDTO == null) {
            return null;
        }
        Movie movie = new Movie();
        movie.setOriginalTitle(movieDTO.getOriginalTitle());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setOverview(movieDTO.getOverview());
        movie.setGenre(movieDTO.getGenre());
        movie.setPosterPath(movieDTO.getPosterPath());
        return movie;
    }

    public static Movie updateMovie(MovieDTO movieDTO, Movie movie) {
        if (movieDTO == null) {
            return null;
        }
        movie.setOriginalTitle(movieDTO.getOriginalTitle());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setOverview(movieDTO.getOverview());
        movie.setGenre(movieDTO.getGenre());
        movie.setPosterPath(movieDTO.getPosterPath());
        return movie;
    }

    public static MovieDTO toDTO(Movie movie) {
        if (movie == null) {
            return null;
        }
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setOriginalTitle(movie.getOriginalTitle());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setOverview(movie.getOverview());
        movieDTO.setGenre(movie.getGenre());
        movieDTO.setPosterPath(movie.getPosterPath());
        return movieDTO;
    }
}
