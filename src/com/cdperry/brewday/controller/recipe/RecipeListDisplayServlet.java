package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.persistence.RecipeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the main page of the application
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeListDisplayServlet",
        urlPatterns = { "/recipes" }
)
public class RecipeListDisplayServlet extends HttpServlet {

    private RecipeDao dao;

    public RecipeListDisplayServlet() {
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

        String url = "/jsp/recipes.jsp";

        request.setAttribute("recipes", dao.getAllRecipes());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
