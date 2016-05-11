package com.cdperry.brewday.controller.ingredients.grain;

import com.cdperry.brewday.persistence.*;
import com.cdperry.brewday.entity.*;

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
        name = "GrainDeleteActionServlet",
        urlPatterns = { "/deleteGrain" }
)
public class GrainDeleteActionServlet extends HttpServlet {

    private ComponentGrainDao componentGrainDao;

    public GrainDeleteActionServlet() {
        super();
        componentGrainDao = new ComponentGrainDao();
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

        String url = "listAllGrains";
        int componentId = Integer.parseInt(request.getParameter("componentId"));

        if (componentGrainDao.getComponentGrainEntity(componentId) != null) {
            componentGrainDao.deleteComponentGrainEntityById(componentId);
        }

        request.setAttribute("grainIngredients", componentGrainDao.getAllComponentGrains());
        response.sendRedirect(url);

    }


}
