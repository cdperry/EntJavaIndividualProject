package com.cdperry.brewday.controller.ingredients.hops;

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
 *  This servlet is used to display the hops available for recipes
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopsDisplayServlet",
        urlPatterns = { "/listAllHops" }
)
public class HopsDisplayServlet extends HttpServlet {

    private ComponentHopDao componentHopDao;

    public HopsDisplayServlet() {
        super();
        componentHopDao = new ComponentHopDao();
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

        String url = "/jsp/listHops.jsp";

        request.setAttribute("hopIngredients", componentHopDao.getAllComponentHops());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
