package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.entity.RecipeEntity;
import com.cdperry.brewday.persistence.RecipeDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Grain Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeEditDisplayServlet",
        urlPatterns = { "/editRecipe" }
)
public class RecipeEditDisplayServlet extends HttpServlet {

    private RecipeDao dao;

    public RecipeEditDisplayServlet() {
        super();
        dao = new RecipeDao();
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

        int recipeId = Integer.parseInt(request.getParameter("recipeId"));

        RecipeEntity recipe = dao.getRecipeEntity(recipeId);

        request.setAttribute("recipe", recipe);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
