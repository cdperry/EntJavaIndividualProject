package com.cdperry.brewday.controller.recipe;

import com.cdperry.brewday.entity.*;
import com.cdperry.brewday.persistence.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 *  <p>
 *  This servlet is used to perform grain type modifications and then show the user all of the
 *  current grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "RecipeComponentAddEditActionServlet",
        urlPatterns = { "/doEditRecipeComponent" }
)
public class RecipeComponentAddEditActionServlet extends HttpServlet {

    private RecipeDao recipeDao;
    private ComponentDao componentDao;
    private RecipeTypeDao recipeTypeDao;
    private UomTypeDao uomTypeDao;
    private ProfileEquipmentDao profileEquipmentDao;

    public RecipeComponentAddEditActionServlet() {
        super();
        recipeDao = new RecipeDao();
        componentDao = new ComponentDao();
        uomTypeDao = new UomTypeDao();
        profileEquipmentDao = new ProfileEquipmentDao();
        recipeTypeDao = new RecipeTypeDao();
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

        RecipeEntity recipeEntity = new RecipeEntity();
        RecipeComponentEntity recipeComponentEntity;
        ComponentEntity componentEntity;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        String recipeId = request.getParameter("recipeId");
        String componentId = request.getParameter("componentId");
        System.out.println("Component: " + componentId);
        String url = "/editRecipe?action=edit&recipeId=" + recipeId;

        recipeEntity = recipeDao.getRecipeEntity(Integer.parseInt(recipeId));

        recipeComponentEntity = new RecipeComponentEntity(ts, ts);
        recipeComponentEntity.setAmount(new BigDecimal("1.0"));

        // add a RecipeEntity > RecipeComponentEntity
        recipeComponentEntity.setRecipeEntity(recipeEntity);
        recipeEntity.getRecipeComponents().add(recipeComponentEntity);

        // TODO: get this dynamically from the selected row in the table
        componentEntity = componentDao.getComponentEntity(Integer.parseInt(componentId));

        // add a RecipeComponentEntity <> ComponentEntity relationship
        recipeComponentEntity.setComponent(componentEntity);
        //componentEntity.getRecipeComponents().add(recipeComponentEntity);

        //recipeComponentDao.addRecipeComponentEntity(recipeComponentEntity);
        recipeDao.updateRecipeEntity(recipeEntity);

        /*
        if (buttonAction.equals("submit")) {
            if (recipeId == null || recipeId.isEmpty()) {
                recipe.setCreateDate(ts);
                recipeDao.addRecipeEntity(recipe);
            } else {
                recipe.setRecipeId(Integer.parseInt(recipeId));
                recipe.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                recipeDao.updateRecipeEntity(recipe);
            }
        }

        request.setAttribute("recipes", recipeDao.getAllRecipes());
        */

        response.sendRedirect(url);

    }

}
