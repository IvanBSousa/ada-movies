package tech.ada.dto;

import java.util.List;

public class MovieApiResponseDTO {

    private List<MovieDTO> results;

    public MovieApiResponseDTO(List<MovieDTO> result) {
        this.results = result;
    }

    public List<MovieDTO> getResults() {
        return results;
    }

    public void setResult(List<MovieDTO> result) {
        this.results = result;
    }
}
