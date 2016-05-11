package com.cdperry.brewday.controller.types.RecipeType;

import com.cdperry.brewday.entity.RecipeTypeEntity;
import com.cdperry.brewday.persistence.RecipeTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *  <p>
 *  This servlet is used to perform recipe type modifications and then show the user all of the
 *  current recipe types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeTypeAddEditActionServlet",
        urlPatterns = { "/doEditRecipeType" }
)
public class RecipeTypeAddEditActionServlet extends HttpServlet {

    private RecipeTypeDao dao;

    public RecipeTypeAddEditActionServlet() {
        super();
        dao = new RecipeTypeDao();
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

        RecipeTypeEntity recipeType = new RecipeTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "listRecipeTypes";

        String name = request.getParameter("name");
        String recipeTypeId = request.getParameter("recipeTypeId");
        String buttonAction = request.getParameter("buttonAction");

        recipeType.setName(name);
        recipeType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (recipeTypeId == null || recipeTypeId.isEmpty()) {
                recipeType.setCreateDate(ts);
                dao.addRecipeTypeEntity(recipeType);
            } else {
                recipeType.setRecipeTypeId(Integer.parseInt(recipeTypeId));
                recipeType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateRecipeTypeEntity(recipeType);
            }
        }

        request.setAttribute("recipeTypes", dao.getAllRecipeTypes());
        response.sendRedirect(url);

    }

}
