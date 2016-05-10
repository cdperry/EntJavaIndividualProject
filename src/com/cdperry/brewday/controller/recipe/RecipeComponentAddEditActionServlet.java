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
    private RecipeComponentDao recipeComponentDao;
    private ComponentDao componentDao;
    private RecipeTypeDao recipeTypeDao;
    private UomTypeDao uomTypeDao;
    private ProfileEquipmentDao profileEquipmentDao;

    public RecipeComponentAddEditActionServlet() {
        super();
        recipeDao = new RecipeDao();
        recipeComponentDao = new RecipeComponentDao();
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
        String recipeComponentId = request.getParameter("recipeComponentId");
        String componentId = request.getParameter("componentId");
        String action = request.getParameter("action");
        String buttonAction = request.getParameter("buttonAction");
        String amount = request.getParameter("amount");
        String newAmount = request.getParameter("newAmount");
        String amountUomId = request.getParameter("amountUomId");
        String time = request.getParameter("time");
        String newTime = request.getParameter("newTime");
        String timeUomId = request.getParameter("timeUomId");
        String url = "/editRecipe?action=edit&recipeId=" + recipeId;

        if (amount == null || amount.isEmpty()) {
            amount = "0";
        }

        if (newAmount == null || newAmount.isEmpty()) {
            newAmount = "0";
        }

        if (time == null || time.isEmpty()) {
            time = "0";
        }

        if (newTime == null || newTime.isEmpty()) {
            newTime = "0";
        }


        // TODO: don't allow add if no row is selected - disable the Add button with jQuery?
        if (buttonAction.equals("submit")) {
            if (action.equals("insert")) {

                // get the RecipeEntity that we're working with
                recipeEntity = recipeDao.getRecipeEntity(Integer.parseInt(recipeId));

                // create a ComponentEntity for the selected component
                componentEntity = componentDao.getComponentEntity(Integer.parseInt(componentId));

                // create a new RecipeComponentEntity
                recipeComponentEntity = new RecipeComponentEntity(ts, ts);

                // set its properties
                recipeComponentEntity.setAmount(new BigDecimal(amount));
                recipeComponentEntity.setAmountUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(amountUomId)));
                if (componentEntity.getComponentType().getName().equals("Hop")
                        || componentEntity.getComponentType().getName().equals("Hop")) {
                    recipeComponentEntity.setTime(new BigDecimal(time));
                    recipeComponentEntity.setTimeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(timeUomId)));
                }

                // add a RecipeEntity > RecipeComponentEntity relationship
                recipeComponentEntity.setRecipeEntity(recipeEntity);
                recipeEntity.getRecipeComponents().add(recipeComponentEntity);

                // add a RecipeComponentEntity <> ComponentEntity relationship
                recipeComponentEntity.setComponent(componentEntity);

                // persist the relationships
                recipeDao.updateRecipeEntity(recipeEntity);

            } else {

                // get the RecipeComponentEntity that is being modified
                recipeComponentEntity = recipeComponentDao.getRecipeComponentEntity(Integer.parseInt(recipeComponentId));

                // perform the modifications
                recipeComponentEntity.setAmount(new BigDecimal(newAmount));
                recipeComponentEntity.setAmountUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(amountUomId)));
                if (recipeComponentEntity.getComponent().getComponentType().getName().equals("Hop")
                        || recipeComponentEntity.getComponent().getComponentType().getName().equals("Hop")) {
                    recipeComponentEntity.setTime(new BigDecimal(newTime));
                    recipeComponentEntity.setTimeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(timeUomId)));
                }

                // persist the modification
                recipeComponentDao.updateRecipeComponentEntity(recipeComponentEntity);

            }

        }

        response.sendRedirect(url);

    }

}
