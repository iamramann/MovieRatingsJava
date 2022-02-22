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

public class DeleteMovie extends HttpServlet {

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
            MovieRatingBean movie = new MovieRatingBean();
            movie.setMovie_name(movie_name);
            int delete_movie = MovieRatingDao.deleteMovieRecord(movie);
            if (delete_movie > 0) {
                out.println("Movie record successfully deleted");
            } else {
                out.println("Movie record deletion failed");
            }

        } catch (SQLException ex) {
            out.println("server error " + ex);
            Logger.getLogger(DeleteMovie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
