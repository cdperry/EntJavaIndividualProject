package com.cdperry.brewday.controller.ingredients.grain;

import com.cdperry.brewday.persistence.*;
import com.cdperry.brewday.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the grains available for recipes
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "GrainDisplayServlet",
        urlPatterns = { "/listAllGrain" }
)
public class GrainDisplayServlet extends HttpServlet {

    private ComponentGrainDao componentGrainDao;

    public GrainDisplayServlet() {
        super();
        componentGrainDao = new ComponentGrainDao();
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

        String url = "/jsp/listGrain.jsp";

        request.setAttribute("recipes", componentGrainDao.getAllComponentGrains());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
