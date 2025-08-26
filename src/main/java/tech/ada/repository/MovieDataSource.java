package tech.ada.repository;

import tech.ada.dto.MovieDTO;

import java.util.List;

public interface MovieDataSource {

    List<MovieDTO> getMovies();

}
