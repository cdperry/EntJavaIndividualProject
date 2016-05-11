package com.cdperry.brewday.controller.ingredients.hops;

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
    private HopFormTypeDao hopFormTypeDao;

    public HopAddEditActionServlet() {
        super();
        componentDao = new ComponentDao();
        componentHopDao = new ComponentHopDao();
        componentTypeDao = new ComponentTypeDao();
        originDao = new OriginDao();
        supplierDao = new SupplierDao();
        hopTypeDao = new HopTypeDao();
        hopFormTypeDao = new HopFormTypeDao();
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
        String url = "listAllHops";

        String buttonAction = request.getParameter("buttonAction");
        String componentId = request.getParameter("componentId");
        String hopName = request.getParameter("name");
        String originId = request.getParameter("originId");
        String supplierId = request.getParameter("supplierId");
        String hopFormTypeId = request.getParameter("hopFormTypeId");
        String hopTypeId = request.getParameter("hopTypeId");
        String alphaPct = request.getParameter("alphaPct");
        String betaPct = request.getParameter("betaPct");
        String notes = request.getParameter("notes");

        if (alphaPct == null || alphaPct.isEmpty()) {
            alphaPct = "0.0";
        }

        if (betaPct == null || betaPct.isEmpty()) {
            betaPct = "0.0";
        }

        // TODO: address duplicate code
        if (buttonAction.equals("submit")) {
            if (componentId == null || componentId.isEmpty()) {

                componentEntity = new ComponentEntity();
                componentHopEntity = new ComponentHopEntity();

                componentEntity.setUpdateDate(ts);
                componentEntity.setCreateDate(ts);

                componentHopEntity.setUpdateDate(ts);
                componentHopEntity.setCreateDate(ts);

                componentHopEntity.setName(hopName);
                componentHopEntity.setOrigin(originDao.getOriginEntity(Integer.parseInt(originId)));
                componentHopEntity.setSupplier(supplierDao.getSupplierEntity(Integer.parseInt(supplierId)));
                componentHopEntity.setHopForm(hopFormTypeDao.getHopFormTypeEntity(Integer.parseInt(hopFormTypeId)));
                componentHopEntity.setHopType(hopTypeDao.getHopTypeEntity(Integer.parseInt(hopTypeId)));
                componentHopEntity.setAlphaPct(new BigDecimal(alphaPct));
                componentHopEntity.setBetaPct(new BigDecimal(betaPct));
                componentHopEntity.setNotes(notes);

                // TODO: Perhaps put the component type for hop into a property?
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
                componentHopEntity.setOrigin(originDao.getOriginEntity(Integer.parseInt(originId)));
                componentHopEntity.setSupplier(supplierDao.getSupplierEntity(Integer.parseInt(supplierId)));
                componentHopEntity.setHopForm(hopFormTypeDao.getHopFormTypeEntity(Integer.parseInt(hopFormTypeId)));
                componentHopEntity.setHopType(hopTypeDao.getHopTypeEntity(Integer.parseInt(hopTypeId)));
                componentHopEntity.setAlphaPct(new BigDecimal(alphaPct));
                componentHopEntity.setBetaPct(new BigDecimal(betaPct));
                componentHopEntity.setNotes(notes);

                componentDao.updateComponentEntity(componentEntity);
                componentHopDao.updateComponentHopEntity(componentHopEntity);

            }
        }

        // TODO: Is this redundant?  Doesn't the 'list' servlet also do this?
        request.setAttribute("hopIngredients", componentHopDao.getAllComponentHops());
        response.sendRedirect(url);

    }

}
