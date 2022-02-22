package Controller;

import Beans.MovieRatingBean;
import DAO.MovieRatingDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMovieRating extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String movie_name = request.getParameter("movie_name");
            String imdb_rating = request.getParameter("imdb_rating");
            String tomato_rating = request.getParameter("tomato_rating");
            MovieRatingBean movie_details = new MovieRatingBean();
            movie_details.setImdb_rating(imdb_rating);
            movie_details.setMovie_name(movie_name);
            movie_details.setTomato_rating(tomato_rating);
            int status= MovieRatingDao.updateMovieRatings(movie_details);
            if(status > 0) {
                out.println("Movie updated success");
            } else {
                out.println("Movie updated failed");
            }
        } catch (SQLException ex) {
            out.println("server error"+ ex);
            Logger.getLogger(UpdateMovieRating.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
