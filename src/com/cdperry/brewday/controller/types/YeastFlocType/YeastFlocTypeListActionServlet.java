package com.cdperry.brewday.controller.types.YeastFlocType;

import com.cdperry.brewday.persistence.YeastFlocTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display all of the Yeast Flocculation types in the database
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFlocTypeListActionServlet",
        urlPatterns = { "/listYeastFlocTypes" }
)
public class YeastFlocTypeListActionServlet extends HttpServlet {

    private YeastFlocTypeDao dao;

    public YeastFlocTypeListActionServlet() {
        super();
        dao = new YeastFlocTypeDao();
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

        String url = "/jsp/listYeastFlocTypes.jsp";

        request.setAttribute("yeastFlocTypes", dao.getAllYeastFlocTypes());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }


}
