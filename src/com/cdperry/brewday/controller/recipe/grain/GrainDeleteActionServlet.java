package com.cdperry.brewday.controller.recipe.grain;

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
        name = "RecipeGrainDeleteActionServlet",
        urlPatterns = { "/editRecipeDeleteGrain" }
)
public class GrainDeleteActionServlet extends HttpServlet {

    private RecipeDao recipeDao;

    public GrainDeleteActionServlet() {
        super();
        recipeDao = new RecipeDao();
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

        String url = "/recipes";
        int recipeId = Integer.parseInt(request.getParameter("recipeId"));

        if (recipeDao.getRecipeEntity(recipeId) != null) {
            recipeDao.deleteRecipeEntityById(recipeId);
        }

        request.setAttribute("recipes", recipeDao.getAllRecipes());

        response.sendRedirect(url);

    }


}
