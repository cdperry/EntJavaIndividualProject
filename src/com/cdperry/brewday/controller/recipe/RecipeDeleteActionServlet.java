package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.persistence.RecipeDao;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  <p>
 *  This servlet is used to delete a grain type and then display the list of remaining grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeDeleteActionServlet",
        urlPatterns = { "/deleteRecipe" }
)
public class RecipeDeleteActionServlet extends HttpServlet {

    private RecipeDao recipeDao;

    public RecipeDeleteActionServlet() {
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
