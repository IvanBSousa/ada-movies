package tech.ada.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import tech.ada.model.Movie;

import java.time.LocalDate;

public class MovieDTO {


    @NotBlank(message = "title cannot be empty")
    @Size(min = 3, max = 64)
    @JsonProperty("original_title")
    private String originalTitle;
    @NotBlank
    @JsonProperty("poster_path")
    private String posterPath;
    @NotBlank
    private String overview;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @NotBlank
    private String genre;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
