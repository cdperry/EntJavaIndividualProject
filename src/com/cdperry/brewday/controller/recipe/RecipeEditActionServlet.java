package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.entity.RecipeEntity;
import com.cdperry.brewday.persistence.RecipeDao;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  <p>
 *  This servlet is used to perform grain type modifications and then show the user all of the
 *  current grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeEditActionServlet",
        urlPatterns = { "/doEditRecipe" }
)
public class RecipeEditActionServlet extends HttpServlet {

    private RecipeDao dao;

    public RecipeEditActionServlet() {
        super();
        dao = new RecipeDao();
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

        RecipeEntity recipe = new RecipeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/recipes";

        String recipeName = request.getParameter("recipeName");
        String brewerName = request.getParameter("brewerName");
        String recipeId = request.getParameter("recipeId");
        String buttonAction = request.getParameter("buttonAction");

        recipe.setRecipeName(recipeName);
        recipe.setBrewerName(brewerName);
        recipe.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (recipeId == null || recipeId.isEmpty()) {
                recipe.setCreateDate(ts);
                dao.addRecipeEntity(recipe);
            } else {
                recipe.setRecipeId(Integer.parseInt(recipeId));
                recipe.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateRecipeEntity(recipe);
            }
        }

        request.setAttribute("recipes", dao.getAllRecipes());
        response.sendRedirect(url);

    }

}
