package tech.ada.dto.mapper;

import tech.ada.dto.MovieDTO;
import tech.ada.model.Movie;

public class MovieMapper {

    public static Movie toEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setOriginalTitle(movieDTO.getOriginalTitle());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setOverview(movieDTO.getOverview());
        movie.setGenre(movieDTO.getGenre());
        movie.setPosterPath(movieDTO.getPosterPath());
        return movie;
    }
}
