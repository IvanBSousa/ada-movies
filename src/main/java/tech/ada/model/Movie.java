package tech.ada.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "movie")
public class Movie extends PanacheEntity {

    @Column(name = "original_title", nullable = false)
    @JsonProperty("original_title")
    private String originalTitle;
    @Column(name = "poster_path", nullable = false)
    @JsonProperty("poster_path")
    private String posterPath;
    @Column(name = "overview", nullable = false, length = 1000)
    private String overview;
    @Column(name = "release_date", nullable = false)
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @Column(name = "genre", nullable = false)
    private String genre;

    public Movie(String originalTitle,
                 String posterPath,
                 String overview,
                 LocalDate releaseDate,
                 String genre) {
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie() {}

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
