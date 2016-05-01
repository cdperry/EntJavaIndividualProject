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

    private RecipeDao dao;

    public RecipeDeleteActionServlet() {
        super();
        dao = new RecipeDao();
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/recipes";
        int grainTypeId = Integer.parseInt(request.getParameter("recipeId"));

        dao.deleteRecipeEntityById(grainTypeId);

        request.setAttribute("recipes", dao.getAllRecipes());

        response.sendRedirect(url);

    }


}
