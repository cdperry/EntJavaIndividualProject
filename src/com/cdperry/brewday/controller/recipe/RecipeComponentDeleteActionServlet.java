package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.persistence.RecipeComponentDao;
import com.cdperry.brewday.persistence.RecipeDao;

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
        name = "RecipeComponentDeleteActionServlet",
        urlPatterns = { "/deleteRecipeComponent" }
)
public class RecipeComponentDeleteActionServlet extends HttpServlet {

    private RecipeDao recipeDao;
    private RecipeComponentDao recipeComponentDao;

    public RecipeComponentDeleteActionServlet() {
        super();
        recipeDao = new RecipeDao();
        recipeComponentDao = new RecipeComponentDao();
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

        int recipeId = Integer.parseInt(request.getParameter("recipeId"));
        int recipeComponentId = Integer.parseInt(request.getParameter("recipeComponentId"));
        String url = "editRecipe?action=edit&recipeId=" + recipeId;

        if (recipeComponentDao.getRecipeComponentEntity(recipeComponentId) != null) {
            recipeComponentDao.deleteRecipeComponentEntityById(recipeComponentId);
        }

        //request.setAttribute("recipes", recipeDao.getAllRecipes());

        response.sendRedirect(url);

    }


}
