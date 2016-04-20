package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.persistence.RecipeTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a recipe type and then display the list of remaining recipe types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeTypeDeleteActionServlet",
        urlPatterns = { "/deleteRecipeType" }
)
public class RecipeTypeDeleteActionServlet extends HttpServlet {

    private RecipeTypeDao dao;

    public RecipeTypeDeleteActionServlet() {
        super();
        dao = new RecipeTypeDao();
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

        String url = "/listRecipeTypes";
        int recipeTypeId = Integer.parseInt(request.getParameter("recipeTypeId"));

        dao.deleteRecipeTypeEntityById(recipeTypeId);

        request.setAttribute("recipeTypes", dao.getAllRecipeTypes());

        response.sendRedirect(url);

    }


}
