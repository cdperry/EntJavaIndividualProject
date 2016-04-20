package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.persistence.OriginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display all of the origins in the database
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OriginListActionServlet",
        urlPatterns = { "/listOrigins" }
)
public class OriginListActionServlet extends HttpServlet {

    private OriginDao dao;

    public OriginListActionServlet() {
        super();
        dao = new OriginDao();
    }

    /**
     *  This method handles HTTP GET requests.
     *
     *  @param  request                   the HttpServletRequest object
     *  @param  response                   the HttpServletResponse object
     *  @exception  ServletException  if there is a Servlet failure
     *  @exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/jsp/listOrigins.jsp";

        request.setAttribute("origins", dao.getAllOrigins());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }


}
