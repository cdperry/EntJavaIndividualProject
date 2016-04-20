package com.cdperry.brewday.controller;

import com.cdperry.brewday.entity.GrainTypeEntity;
import com.cdperry.brewday.persistence.GrainTypeDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Grain Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "GrainTypeEditDisplayServlet",
        urlPatterns = { "/editGrainType" }
)
public class GrainTypeEditDisplayServlet extends HttpServlet {

    private GrainTypeDao dao;

    public GrainTypeEditDisplayServlet() {
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

        String url = "/jsp/editGrainType.jsp";

        int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));

        GrainTypeEntity grainType = dao.getGrainTypeEntity(grainTypeId);

        request.setAttribute("grainType", grainType);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
