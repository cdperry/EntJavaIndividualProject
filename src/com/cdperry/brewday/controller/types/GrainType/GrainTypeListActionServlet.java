package com.cdperry.brewday.controller.types.GrainType;

import com.cdperry.brewday.persistence.GrainTypeDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  <p>
 *  This servlet is used to display all of the grain types in the database
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "GrainTypeListActionServlet",
        urlPatterns = { "/listGrainTypes" }
)
public class GrainTypeListActionServlet extends HttpServlet {

    private GrainTypeDao dao;

    public GrainTypeListActionServlet() {
        super();
        dao = new GrainTypeDao();
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

        String url = "/jsp/listGrainTypes.jsp";

        request.setAttribute("grainTypes", dao.getAllGrainTypes());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }


}
