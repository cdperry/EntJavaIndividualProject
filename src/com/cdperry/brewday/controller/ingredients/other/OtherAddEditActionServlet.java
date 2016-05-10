package com.cdperry.brewday.controller.ingredients.other;

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
 *  This servlet is used to perform other type modifications and then show the user all of the
 *  current other types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OtherAddEditActionServlet",
        urlPatterns = { "/doEditOther" }
)
public class OtherAddEditActionServlet extends HttpServlet {

    private ComponentDao componentDao;
    private ComponentOtherDao componentOtherDao;
    private ComponentTypeDao componentTypeDao;
    private UseTypeDao useTypeDao;
    private UomTypeDao uomTypeDao;

    public OtherAddEditActionServlet() {
        super();
        componentDao = new ComponentDao();
        componentOtherDao = new ComponentOtherDao();
        componentTypeDao = new ComponentTypeDao();
        useTypeDao = new UseTypeDao();
        uomTypeDao = new UomTypeDao();
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
        ComponentOtherEntity componentOtherEntity;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listAllOthers";

        String buttonAction = request.getParameter("buttonAction");
        String componentId = request.getParameter("componentId");
        String otherName = request.getParameter("name");
        String useTypeId = request.getParameter("useTypeId");
        String useFor = request.getParameter("useFor");
        String amount = request.getParameter("amount");
        String amountUomId = request.getParameter("amountUomId");
        String batchSize = request.getParameter("batchSize");
        String batchSizeUomId = request.getParameter("batchSizeUomId");
        String time = request.getParameter("time");
        String timeUomId = request.getParameter("timeUomId");
        String notes = request.getParameter("notes");

        if (amount == null || amount.isEmpty()) {
            amount = "0.0";
        }

        if (batchSize == null || batchSize.isEmpty()) {
            batchSize = "1.0";
        }

        if (time == null || time.isEmpty()) {
            time = "1.0";
        }

        // TODO: address duplicate code
        if (buttonAction.equals("submit")) {
            if (componentId == null || componentId.isEmpty()) {

                componentEntity = new ComponentEntity();
                componentOtherEntity = new ComponentOtherEntity();

                componentEntity.setUpdateDate(ts);
                componentEntity.setCreateDate(ts);

                componentOtherEntity.setUpdateDate(ts);
                componentOtherEntity.setCreateDate(ts);

                componentOtherEntity.setName(otherName);
                componentOtherEntity.setUseType(useTypeDao.getUseTypeEntity(Integer.parseInt(useTypeId)));
                componentOtherEntity.setUseFor(useFor);
                componentOtherEntity.setAmount(new BigDecimal(amount));
                componentOtherEntity.setAmountUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(amountUomId)));
                componentOtherEntity.setBatchSize(new BigDecimal(batchSize));
                componentOtherEntity.setBatchSizeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(batchSizeUomId)));
                componentOtherEntity.setTime(new BigDecimal(time));
                componentOtherEntity.setTimeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(timeUomId)));
                componentOtherEntity.setNotes(notes);

                // TODO: Perhaps put the component type for other into a property?
                componentEntity.setComponentType(componentTypeDao.getComponentTypeEntity(5));
                // set the relationship between the ComponentEntity object and the ComponentOtherEntity object
                componentEntity.setComponentOther(componentOtherEntity);
                componentOtherEntity.setComponentEntity(componentEntity);
                // persist the ComponentEntity object which will also persist the ComponentOtherEntity object
                componentDao.addComponentEntity(componentEntity);
            } else {

                int id = Integer.parseInt(componentId);

                componentEntity = componentDao.getComponentEntity(id);
                componentOtherEntity = componentEntity.getComponentOther();

                componentEntity.setUpdateDate(ts);
                componentOtherEntity.setUpdateDate(ts);

                componentOtherEntity.setName(otherName);
                componentOtherEntity.setUseType(useTypeDao.getUseTypeEntity(Integer.parseInt(useTypeId)));
                componentOtherEntity.setUseFor(useFor);
                componentOtherEntity.setAmount(new BigDecimal(amount));
                componentOtherEntity.setAmountUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(amountUomId)));
                componentOtherEntity.setBatchSize(new BigDecimal(batchSize));
                componentOtherEntity.setBatchSizeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(batchSizeUomId)));
                componentOtherEntity.setTime(new BigDecimal(time));
                componentOtherEntity.setTimeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(timeUomId)));
                componentOtherEntity.setNotes(notes);

                componentDao.updateComponentEntity(componentEntity);
                componentOtherDao.updateComponentOtherEntity(componentOtherEntity);

            }
        }

        // TODO: Is this redundant?  Doesn't the 'list' servlet also do this?
        request.setAttribute("otherIngredients", componentOtherDao.getAllComponentOthers());
        response.sendRedirect(url);

    }

}
