package com.cdperry.brewday.controller.recipe.grain;

import com.cdperry.brewday.entity.RecipeEntity;
import com.cdperry.brewday.persistence.ProfileEquipmentDao;
import com.cdperry.brewday.persistence.RecipeDao;
import com.cdperry.brewday.persistence.RecipeTypeDao;
import com.cdperry.brewday.persistence.UomTypeDao;

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
        name = "RecipeGrainAddEditActionServlet",
        urlPatterns = { "/doEditRecipeEditGrain" }
)
public class GrainAddEditActionServlet extends HttpServlet {

    private RecipeDao recipeDao;
    private RecipeTypeDao recipeTypeDao;
    private UomTypeDao uomTypeDao;
    private ProfileEquipmentDao profileEquipmentDao;

    public GrainAddEditActionServlet() {
        super();
        recipeDao = new RecipeDao();
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

        RecipeEntity recipe = new RecipeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/recipes";

        String recipeName = request.getParameter("recipeName");
        String brewerName = request.getParameter("brewerName");
        String recipeId = request.getParameter("recipeId");
        String buttonAction = request.getParameter("buttonAction");
        String recipeTypeId = request.getParameter("recipeTypeId");
        String batchSize = request.getParameter("batchSize");
        String batchSizeUomId = request.getParameter("batchSizeUomId");
        String equipmentProfileId = request.getParameter("equipmentProfileId");

        recipe.setRecipeName(recipeName);
        recipe.setBrewerName(brewerName);
        recipe.setUpdateDate(ts);
        recipe.setRecipeType(recipeTypeDao.getRecipeTypeEntity(Integer.parseInt(recipeTypeId)));
        recipe.setBatchSize(new BigDecimal(batchSize));
        recipe.setBatchSizeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(batchSizeUomId)));
        recipe.setProfileEquipment(profileEquipmentDao.getProfileEquipmentEntity(Integer.parseInt(equipmentProfileId)));

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
        response.sendRedirect(url);

    }

}
