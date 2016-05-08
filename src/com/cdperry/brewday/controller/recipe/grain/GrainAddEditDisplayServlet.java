package com.cdperry.brewday.controller.recipe.grain;

import com.cdperry.brewday.entity.*;
import com.cdperry.brewday.persistence.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Grain page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeGrainAddEditDisplayServlet",
        urlPatterns = { "/editRecipeAddGrain", "/editRecipeEditGrain" }
)
public class GrainAddEditDisplayServlet extends HttpServlet {

    private ComponentDao componentDao;
    private ComponentGrainDao componentGrainDao;
    private UomTypeDao uomTypeDao;

    public GrainAddEditDisplayServlet() {
        super();
        componentDao = new ComponentDao();
        componentGrainDao = new ComponentGrainDao();
        uomTypeDao = new UomTypeDao();
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

        String url = "/jsp/editRecipeEditGrain.jsp";
        List<ComponentEntity> componentEntities;
        List<ComponentGrainEntity> grainEntities;
        List<UomTypeEntity> uomTypes;

        componentEntities = componentDao.getComponentsByType("Grain");
        request.setAttribute("components", componentEntities);

        // get any unit of measure types named "lb" and attach the first
        // one to the request
        uomTypes = uomTypeDao.getUomTypeEntityByName("lb");
        request.setAttribute("grainUomTypes", uomTypes);

        // get all the grains and put them into the request
        grainEntities = componentGrainDao.getAllComponentGrains();
        request.setAttribute("grainEntities", grainEntities);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");

        } else {
            request.setAttribute("actionType", "edit");

        }

        System.out.println("Recipe: " + request.getParameter("recipeId"));
        System.out.println("Recipe Component: " + request.getParameter("recipeComponentId"));
        dispatcher.forward(request, response);

    }

}
