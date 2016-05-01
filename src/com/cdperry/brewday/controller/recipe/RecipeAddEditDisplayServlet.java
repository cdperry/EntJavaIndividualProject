package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.entity.RecipeEntity;
import com.cdperry.brewday.entity.RecipeTypeEntity;
import com.cdperry.brewday.entity.UomTypeEntity;
import com.cdperry.brewday.persistence.RecipeDao;
import com.cdperry.brewday.persistence.RecipeTypeDao;
import com.cdperry.brewday.persistence.UomTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    private RecipeTypeDao recipeTypeDao;
    private UomTypeDao uomTypeDao;

    public RecipeAddEditDisplayServlet() {
        super();
        recipeDao = new RecipeDao();
        recipeTypeDao = new RecipeTypeDao();
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

        String url = "/jsp/editRecipe.jsp";
        List<RecipeTypeEntity> recipeTypes;
        List<UomTypeEntity> uomTypes;
        int recipeId;
        RecipeEntity recipe;

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
        } else {
            recipeId = Integer.parseInt(request.getParameter("recipeId"));
            recipe = recipeDao.getRecipeEntity(recipeId);
            request.setAttribute("recipe", recipe);
            request.setAttribute("actionType", "edit");
        }

        recipeTypes = recipeTypeDao.getAllRecipeTypes();
        request.setAttribute("recipeTypes", recipeTypes);

        uomTypes = uomTypeDao.getAllUomTypes();
        request.setAttribute("uomTypes", uomTypes);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
