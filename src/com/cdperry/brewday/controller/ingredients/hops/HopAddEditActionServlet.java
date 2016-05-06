package com.cdperry.brewday.controller.ingredients.hops;

import com.cdperry.brewday.entity.*;
import com.cdperry.brewday.persistence.*;

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
 *  This servlet is used to perform hop type modifications and then show the user all of the
 *  current hop types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopAddEditActionServlet",
        urlPatterns = { "/doEditHop" }
)
public class HopAddEditActionServlet extends HttpServlet {

    private ComponentDao componentDao;
    private ComponentHopDao componentHopDao;
    private ComponentTypeDao componentTypeDao;
    private OriginDao originDao;
    private SupplierDao supplierDao;
    private HopTypeDao hopTypeDao;

    public HopAddEditActionServlet() {
        super();
        componentDao = new ComponentDao();
        componentHopDao = new ComponentHopDao();
        componentTypeDao = new ComponentTypeDao();
        originDao = new OriginDao();
        supplierDao = new SupplierDao();
        hopTypeDao = new HopTypeDao();
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

        ComponentEntity componentEntity;
        ComponentHopEntity componentHopEntity;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listAllHops";

        String buttonAction = request.getParameter("buttonAction");
        String componentId = request.getParameter("componentId");
        String hopName = request.getParameter("name");

        if (buttonAction.equals("submit")) {
            if (componentId == null || componentId.isEmpty()) {

                componentEntity = new ComponentEntity();
                componentHopEntity = new ComponentHopEntity();

                componentEntity.setUpdateDate(ts);
                componentEntity.setCreateDate(ts);

                componentHopEntity.setUpdateDate(ts);
                componentHopEntity.setCreateDate(ts);

                componentHopEntity.setName(hopName);

                // TODO: make this not hard-coded to 1 - Hop
                componentEntity.setComponentType(componentTypeDao.getComponentTypeEntity(1));
                // set the relationship between the ComponentEntity object and the ComponentHopEntity object
                componentEntity.setComponentHop(componentHopEntity);
                componentHopEntity.setComponentEntity(componentEntity);
                // persist the ComponentEntity object which will also persist the ComponentHopEntity object
                componentDao.addComponentEntity(componentEntity);
            } else {

                int id = Integer.parseInt(componentId);

                componentEntity = componentDao.getComponentEntity(id);
                componentHopEntity = componentEntity.getComponentHop();

                componentEntity.setUpdateDate(ts);
                componentHopEntity.setUpdateDate(ts);
                componentHopEntity.setName(hopName);

                componentDao.updateComponentEntity(componentEntity);
                componentHopDao.updateComponentHopEntity(componentHopEntity);

            }
        }

        // TODO: Is this redundant?  Doesn't the 'list' servlet also do this?
        request.setAttribute("hopIngredients", componentHopDao.getAllComponentHops());
        response.sendRedirect(url);

        /*
        String recipeName = request.getParameter("recipeName");
        String brewerName = request.getParameter("brewerName");

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

        */

    }

}
