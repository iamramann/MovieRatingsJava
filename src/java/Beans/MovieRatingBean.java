package Beans;
public class MovieRatingBean {
    private String movie_name;
    private String release_year;
    private String imdb_rating;
    private String tomato_rating;

    public MovieRatingBean() {
    }

    public MovieRatingBean(String movie_name, String release_year, String imdb_rating, String tomato_rating) {
        this.movie_name = movie_name;
        this.release_year = release_year;
        this.imdb_rating = imdb_rating;
        this.tomato_rating = tomato_rating;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(String imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public String getTomato_rating() {
        return tomato_rating;
    }

    public void setTomato_rating(String tomato_rating) {
        this.tomato_rating = tomato_rating;
    }
    
    
    
}
