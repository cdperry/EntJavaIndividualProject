package com.cdperry.brewday.controller.types.GrainType;

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

    private GrainTypeDao grainTypeDao;

    public GrainTypeDeleteActionServlet() {
        super();
        grainTypeDao = new GrainTypeDao();
    }

    /**
     *  This method handles HTTP POST requests.
     *
     *  @param  request                   the HttpServletRequest object
     *  @param  response                   the HttpServletResponse object
     *  @exception  ServletException  if there is a Servlet failure
     *  @exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "listGrainTypes";
        int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));

        if (grainTypeDao.getGrainTypeEntity(grainTypeId) != null) {
            grainTypeDao.deleteGrainTypeEntityById(grainTypeId);
        }

        request.setAttribute("grainTypes", grainTypeDao.getAllGrainTypes());

        response.sendRedirect(url);

    }


}
