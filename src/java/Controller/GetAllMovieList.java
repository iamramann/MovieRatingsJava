package Controller;

import Beans.MovieRatingBean;
import DAO.MovieRatingDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllMovieList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            ArrayList<MovieRatingBean> movie_list = MovieRatingDao.getAllMovieList();
            Iterator<MovieRatingBean> itr = movie_list.iterator();
            out.print("<table border='1'> <tr> <th>Movie Name</th> <th>Release year</th>  <th>IMDB ratings</th> <th>Rotten Tomatos ratings</th> </tr>");
            while(itr.hasNext()) {
                MovieRatingBean obj = itr.next();
                out.print("<tr> <td>" +obj.getMovie_name()+ "</td> <td>" +obj.getRelease_year()+ "</td> <td>" +obj.getImdb_rating()+ "</td> <td>" +obj.getTomato_rating()+ "</td> </tr>");
            }
            out.print("</table>");
        } catch (SQLException ex) {
            Logger.getLogger(GetAllMovieList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
