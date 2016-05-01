package com.cdperry.brewday.controller.types.RecipeType;

import com.cdperry.brewday.entity.RecipeTypeEntity;
import com.cdperry.brewday.persistence.RecipeTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Recipe Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeTypeAddEditDisplayServlet",
        urlPatterns = { "/addRecipeType", "/editRecipeType" }
)
public class RecipeTypeAddEditDisplayServlet extends HttpServlet {

    private RecipeTypeDao recipeTypeDao;

    public RecipeTypeAddEditDisplayServlet() {
        super();
        recipeTypeDao = new RecipeTypeDao();
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

        String url = "/jsp/editRecipeType.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int recipeTypeId = Integer.parseInt(request.getParameter("recipeTypeId"));
            RecipeTypeEntity recipeType = recipeTypeDao.getRecipeTypeEntity(recipeTypeId);
            if (recipeType != null) {
                request.setAttribute("recipeType", recipeType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/listRecipeTypes";
                response.sendRedirect(url);
            }
        }





    }

}
