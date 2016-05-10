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
        String buttonAction = request.getParameter("buttonAction");
        String amount = request.getParameter("amount");
        String amountUomId = request.getParameter("amountUomId");
        String url = "/editRecipe?action=edit&recipeId=" + recipeId;

        if (amount == null || amount.isEmpty()) {
            amount = "0";
        }

        // TODO: temporary- remove this
        if (amountUomId == null || amountUomId.isEmpty()) {
            amountUomId = "0";
        }

        recipeEntity = recipeDao.getRecipeEntity(Integer.parseInt(recipeId));

        recipeComponentEntity = new RecipeComponentEntity(ts, ts);
        recipeComponentEntity.setAmount(new BigDecimal(amount));
        recipeComponentEntity.setAmountUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(amountUomId)));

        // add a RecipeEntity > RecipeComponentEntity
        recipeComponentEntity.setRecipeEntity(recipeEntity);
        recipeEntity.getRecipeComponents().add(recipeComponentEntity);

        componentEntity = componentDao.getComponentEntity(Integer.parseInt(componentId));

        // add a RecipeComponentEntity <> ComponentEntity relationship
        recipeComponentEntity.setComponent(componentEntity);

        // TODO: don't allow add if no row is selected - disable the Add button with jQuery?
        if (buttonAction.equals("submit")) {
            recipeDao.updateRecipeEntity(recipeEntity);
        }

        response.sendRedirect(url);

    }

}
