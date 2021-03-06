package com.cdperry.brewday.controller.ingredients.water;

import com.cdperry.brewday.persistence.ComponentWaterDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the water available for recipes
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "WaterDisplayServlet",
        urlPatterns = { "/listAllWaters" }
)
public class WaterDisplayServlet extends HttpServlet {

    private ComponentWaterDao componentWaterDao;

    public WaterDisplayServlet() {
        super();
        componentWaterDao = new ComponentWaterDao();
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

        String url = "/jsp/listWaters.jsp";

        request.setAttribute("waterIngredients", componentWaterDao.getAllComponentWaters());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
