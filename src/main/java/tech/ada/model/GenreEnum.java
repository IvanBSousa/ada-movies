package tech.ada.model;

public enum GenreEnum {

    ACTION(28, "Action"),
    ADVENTURE(12, "Adventure"),
    ANIMATION(16, "Animation"),
    COMEDY(35, "Comedy"),
    CRIME(80, "Crime"),
    DOCUMENTARY(99, "Documentary"),
    DRAMA(18, "Drama"),
    FAMILY(10751, "Family"),
    FANTASY(14, "Fantasy"),
    HISTORY(36, "History"),
    HORROR(27, "Horror"),
    MUSIC(10402, "Music"),
    MYSTERY(9648, "Mystery"),
    ROMANCE(10749, "Romance"),
    SCIENCE_FICTION(878, "Science Fiction"),
    TV_MOVIE(10770, "TV Movie"),
    THRILLER(53, "Thriller"),
    WAR(10752, "War"),
    WESTERN(37, "Western"),
    UNKNOW(101, "Unknow");

    private final int id;
    private final String name;

    GenreEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return (long) id;
    }

    public String getName() {
        return name;
    }

    public static GenreEnum fromName(String genreName) {
        for (GenreEnum genre : values()) {
            if (genre.name.equalsIgnoreCase(genreName)) {
                return genre;
            }
        }
        return UNKNOW;
    }

}
