package com.cdperry.brewday.controller.ingredients.grain;

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
        name = "GrainAddEditActionServlet",
        urlPatterns = { "/doEditGrain" }
)
public class GrainAddEditActionServlet extends HttpServlet {

    private ComponentDao componentDao;
    private ComponentGrainDao componentGrainDao;
    private ComponentTypeDao componentTypeDao;
    private OriginDao originDao;
    private SupplierDao supplierDao;
    private GrainTypeDao grainTypeDao;

    public GrainAddEditActionServlet() {
        super();
        componentDao = new ComponentDao();
        componentGrainDao = new ComponentGrainDao();
        componentTypeDao = new ComponentTypeDao();
        originDao = new OriginDao();
        supplierDao = new SupplierDao();
        grainTypeDao = new GrainTypeDao();
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
        ComponentGrainEntity componentGrainEntity;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listAllGrains";

        String buttonAction = request.getParameter("buttonAction");
        String componentId = request.getParameter("componentId");
        String grainName = request.getParameter("name");
        String originId = request.getParameter("originId");
        String supplierId = request.getParameter("supplierId");
        String grainTypeId = request.getParameter("grainTypeId");
        String color = request.getParameter("color");
        String potential = request.getParameter("potential");
        String notes = request.getParameter("notes");

        if (color == null || color.isEmpty()) {
            color = "0.0";
        }

        if (potential == null || potential.isEmpty()) {
            potential = "1.0";
        }

        // TODO: address duplicate code
        if (buttonAction.equals("submit")) {
            if (componentId == null || componentId.isEmpty()) {

                componentEntity = new ComponentEntity();
                componentGrainEntity = new ComponentGrainEntity();

                componentEntity.setUpdateDate(ts);
                componentEntity.setCreateDate(ts);

                componentGrainEntity.setUpdateDate(ts);
                componentGrainEntity.setCreateDate(ts);

                componentGrainEntity.setName(grainName);
                componentGrainEntity.setOrigin(originDao.getOriginEntity(Integer.parseInt(originId)));
                componentGrainEntity.setSupplier(supplierDao.getSupplierEntity(Integer.parseInt(supplierId)));
                componentGrainEntity.setGrainType(grainTypeDao.getGrainTypeEntity(Integer.parseInt(grainTypeId)));
                componentGrainEntity.setColor(new BigDecimal(color));
                componentGrainEntity.setPotential(new BigDecimal(potential));
                componentGrainEntity.setNotes(notes);

                // TODO: Perhaps put the component type for grain into a property?
                componentEntity.setComponentType(componentTypeDao.getComponentTypeEntity(2));
                // set the relationship between the ComponentEntity object and the ComponentGrainEntity object
                componentEntity.setComponentGrain(componentGrainEntity);
                componentGrainEntity.setComponentEntity(componentEntity);
                // persist the ComponentEntity object which will also persist the ComponentGrainEntity object
                componentDao.addComponentEntity(componentEntity);
            } else {

                int id = Integer.parseInt(componentId);

                componentEntity = componentDao.getComponentEntity(id);
                componentGrainEntity = componentEntity.getComponentGrain();

                componentEntity.setUpdateDate(ts);
                componentGrainEntity.setUpdateDate(ts);
                componentGrainEntity.setName(grainName);
                componentGrainEntity.setOrigin(originDao.getOriginEntity(Integer.parseInt(originId)));
                componentGrainEntity.setSupplier(supplierDao.getSupplierEntity(Integer.parseInt(supplierId)));
                componentGrainEntity.setGrainType(grainTypeDao.getGrainTypeEntity(Integer.parseInt(grainTypeId)));
                componentGrainEntity.setColor(new BigDecimal(color));
                componentGrainEntity.setPotential(new BigDecimal(potential));
                componentGrainEntity.setNotes(notes);

                componentDao.updateComponentEntity(componentEntity);
                componentGrainDao.updateComponentGrainEntity(componentGrainEntity);

            }
        }

        // TODO: Is this redundant?  Doesn't the 'list' servlet also do this?
        request.setAttribute("grainIngredients", componentGrainDao.getAllComponentGrains());
        response.sendRedirect(url);

    }

}
