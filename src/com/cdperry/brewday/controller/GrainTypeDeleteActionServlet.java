package com.cdperry.brewday.controller;

import com.cdperry.brewday.persistence.GrainTypeDao;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  <p>
 *  This servlet is used to delete a grain type and then display the list of remaining grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "GrainTypeDeleteActionServlet",
        urlPatterns = { "/deleteGrainType" }
)
public class GrainTypeDeleteActionServlet extends HttpServlet {

    private GrainTypeDao dao;

    public GrainTypeDeleteActionServlet() {
        super();
        dao = new GrainTypeDao();
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/listGrainTypes";
        int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));

        dao.deleteGrainTypeEntityById(grainTypeId);

        request.setAttribute("grainTypes", dao.getAllGrainTypes());

        response.sendRedirect(url);

    }


}
