package DAO;

import Beans.MovieRatingBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieRatingDao {
    final static String TABLE_NAME = "movietable";
    public static Connection getConnection() {
        final String url = "jdbc:mysql://localhost:3306/movieratingdb";
        final String user = "root";
        final String password = "";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieRatingDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieRatingDao.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return conn;
        
    }
    
    public static int saveMovieRating(MovieRatingBean obj) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO movietable VALUES(?, ?, ?, ?);");
        stmt.setString(1, obj.getMovie_name());
        stmt.setString(2, obj.getRelease_year());
        stmt.setString(3, obj.getImdb_rating());
        stmt.setString(4, obj.getTomato_rating());  
        return stmt.executeUpdate();
    }
    
    public static int updateMovieRatings(MovieRatingBean obj) throws SQLException {
         Connection conn = getConnection();
         String query = "UPDATE "+TABLE_NAME+" SET imdb_rating = ?, tomato_rating = ? WHERE movie_name = ?";
         PreparedStatement stmt = conn.prepareStatement(query);
         stmt.setString(1, obj.getImdb_rating());
         stmt.setString(2, obj.getTomato_rating());
         stmt.setString(3, obj.getMovie_name());
        return stmt.executeUpdate();        
    }
    
    public static ArrayList<MovieRatingBean> getAllMovieList() throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT * FROM "+TABLE_NAME;
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet list = stmt.executeQuery();
        ArrayList<MovieRatingBean> movie_list = new ArrayList<MovieRatingBean>();
        while(list.next()) {
            String movie_name = list.getString("movie_name");
            String release_year = list.getString("release_year");
            String imdb_rating = list.getString("imdb_rating");
            String tomato_rating = list.getString("tomato_rating");
            MovieRatingBean movie = new MovieRatingBean(movie_name, release_year, imdb_rating, tomato_rating);
            movie_list.add(movie);
        }        
        return movie_list;       
        
    }
    
    public static int deleteMovieRecord(MovieRatingBean movie) throws SQLException {
        String movie_name = movie.getMovie_name();
        Connection conn = getConnection();
        String query = "DELETE FROM "+TABLE_NAME+" WHERE movie_name = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, movie_name);
        return stmt.executeUpdate();
    }
}
