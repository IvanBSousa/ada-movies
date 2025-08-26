package tech.ada.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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
    private String genreId;

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
        return genreId;
    }

    public void setGenre(String genreId) {
        this.genreId = genreId;
    }
}
