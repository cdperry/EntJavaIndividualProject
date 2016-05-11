package com.cdperry.brewday.controller.ingredients.hops;

import com.cdperry.brewday.persistence.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a grain type and then display the list of remaining grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopDeleteActionServlet",
        urlPatterns = { "/deleteHop" }
)
public class HopDeleteActionServlet extends HttpServlet {

    private ComponentHopDao componentHopDao;

    public HopDeleteActionServlet() {
        super();
        componentHopDao = new ComponentHopDao();
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

        String url = "listAllHops";
        int componentId = Integer.parseInt(request.getParameter("componentId"));

        if (componentHopDao.getComponentHopEntity(componentId) != null) {
            componentHopDao.deleteComponentHopEntityById(componentId);
        }

        request.setAttribute("hopIngredients", componentHopDao.getAllComponentHops());
        response.sendRedirect(url);

    }


}
