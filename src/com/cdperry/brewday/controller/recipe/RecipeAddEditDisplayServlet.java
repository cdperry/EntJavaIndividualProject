package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.entity.*;
import com.cdperry.brewday.persistence.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Grain Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeAddEditDisplayServlet",
        urlPatterns = { "/addRecipe", "/editRecipe" }
)
public class RecipeAddEditDisplayServlet extends HttpServlet {

    private RecipeDao recipeDao;
    private RecipeComponentDao recipeComponentDao;
    private ComponentDao componentDao;
    private RecipeTypeDao recipeTypeDao;
    private UomTypeDao uomTypeDao;
    private ProfileEquipmentDao profileEquipmentDao;

    public RecipeAddEditDisplayServlet() {
        super();
        recipeDao = new RecipeDao();
        recipeComponentDao = new RecipeComponentDao();
        componentDao = new ComponentDao();
        recipeTypeDao = new RecipeTypeDao();
        uomTypeDao = new UomTypeDao();
        profileEquipmentDao = new ProfileEquipmentDao();
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

        String url = "/jsp/editRecipe.jsp";
        List<RecipeTypeEntity> recipeTypes;
        List<UomTypeEntity> uomTypes;
        List<ProfileEquipmentEntity> equipmentProfiles;
        List<ComponentEntity> componentEntities;

        Set<RecipeComponentEntity> recipeComponents;
        int recipeId;
        RecipeEntity recipe;

        componentEntities = null;
        componentEntities = componentDao.getComponentsByType("Grain");
        request.setAttribute("grains", componentEntities);

        componentEntities = null;
        componentEntities = componentDao.getComponentsByType("Hop");
        request.setAttribute("hops", componentEntities);

        componentEntities = null;
        componentEntities = componentDao.getComponentsByType("Yeast");
        request.setAttribute("yeasts", componentEntities);

        componentEntities = null;
        componentEntities = componentDao.getComponentsByType("Water");
        request.setAttribute("waters", componentEntities);

        componentEntities = null;
        componentEntities = componentDao.getComponentsByType("Other");
        request.setAttribute("others", componentEntities);

        // get all potential recipe types and attach them to the request
        recipeTypes = recipeTypeDao.getAllRecipeTypes();
        request.setAttribute("recipeTypes", recipeTypes);

        // get all equipment profiles and attach them to the request
        equipmentProfiles = profileEquipmentDao.getAllProfileEquipment();
        request.setAttribute("equipmentProfiles", equipmentProfiles);

        // get any unit of measure types named "gal" and attach the first
        // one to the request
        uomTypes = uomTypeDao.getUomTypeEntityByName("gal");
        request.setAttribute("uomTypes", uomTypes);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            recipeId = Integer.parseInt(request.getParameter("recipeId"));
            recipe = recipeDao.getRecipeEntity(recipeId);
            recipeComponents = recipe.getRecipeComponents();
            request.setAttribute("recipeComponents", recipeComponents);
            if (recipe != null) {
                request.setAttribute("recipe", recipe);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/recipes";
                response.sendRedirect(url);
            }
        }

    }

}
