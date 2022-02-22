package Controller;

import Beans.MovieRatingBean;
import DAO.MovieRatingDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveMovieRating extends HttpServlet {

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
            String release_year = request.getParameter("release_year");
            String imdb_rating = request.getParameter("imdb_rating");
            String tomato_rating = request.getParameter("tomato_rating");
            MovieRatingBean movie = new MovieRatingBean(movie_name, release_year, imdb_rating, tomato_rating);
            int status = MovieRatingDao.saveMovieRating(movie);
            ServletContext context = getServletContext();
//            String dbname =context.getInitParameter("dbname");
            if (status > 0) {
                out.println("Movie ratings saved successfully");
            } else {
                
                out.println("Movie ratings saved failed"); 
            }
        } catch (Exception e) {
            out.println("server error "+ e);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
