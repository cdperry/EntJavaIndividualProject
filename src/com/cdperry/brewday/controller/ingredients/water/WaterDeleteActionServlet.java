package com.cdperry.brewday.controller.ingredients.water;

import com.cdperry.brewday.persistence.ComponentWaterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a water type and then display the list of remaining water types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "WaterDeleteActionServlet",
        urlPatterns = { "/deleteWater" }
)
public class WaterDeleteActionServlet extends HttpServlet {

    private ComponentWaterDao componentWaterDao;

    public WaterDeleteActionServlet() {
        super();
        componentWaterDao = new ComponentWaterDao();
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

        String url = "listAllWaters";
        int componentId = Integer.parseInt(request.getParameter("componentId"));

        if (componentWaterDao.getComponentWaterEntity(componentId) != null) {
            componentWaterDao.deleteComponentWaterEntityById(componentId);
        }

        request.setAttribute("waterIngredients", componentWaterDao.getAllComponentWaters());
        response.sendRedirect(url);

    }


}
