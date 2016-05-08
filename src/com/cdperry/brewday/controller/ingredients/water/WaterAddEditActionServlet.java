package com.cdperry.brewday.controller.ingredients.water;

import com.cdperry.brewday.entity.ComponentEntity;
import com.cdperry.brewday.entity.ComponentWaterEntity;
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
 *  This servlet is used to perform water type modifications and then show the user all of the
 *  current water types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "WaterAddEditActionServlet",
        urlPatterns = { "/doEditWater" }
)
public class WaterAddEditActionServlet extends HttpServlet {

    private ComponentDao componentDao;
    private ComponentWaterDao componentWaterDao;
    private ComponentTypeDao componentTypeDao;
    private UomTypeDao uomTypeDao;

    public WaterAddEditActionServlet() {
        super();
        componentDao = new ComponentDao();
        componentWaterDao = new ComponentWaterDao();
        componentTypeDao = new ComponentTypeDao();
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
        ComponentWaterEntity componentWaterEntity;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listAllWaters";

        String buttonAction = request.getParameter("buttonAction");
        String componentId = request.getParameter("componentId");
        String waterName = request.getParameter("name");
        String ph = request.getParameter("ph");
        String caPpm = request.getParameter("caPpm");
        String mgPpm = request.getParameter("mgPpm");
        String naPpm = request.getParameter("naPpm");
        String so4Ppm = request.getParameter("so4Ppm");
        String clPpm = request.getParameter("clPpm");
        String hco3Ppm = request.getParameter("hco3Ppm");
        String caso4G = request.getParameter("caso4G");
        String naclG = request.getParameter("naclG");
        String mgso4G = request.getParameter("mgso4G");
        String caclG = request.getParameter("caclG");
        String nahco3G = request.getParameter("nahco3G");
        String caco3G = request.getParameter("caco3G");
        String batchSize = request.getParameter("batchSize");
        String batchSizeUomId = request.getParameter("batchSizeUomId");
        String notes = request.getParameter("notes");

        if (ph == null || ph.isEmpty()) {
            ph = "0.0";
        }

        if (caPpm == null || caPpm.isEmpty()) {
            caPpm = "0.0";
        }

        if (mgPpm == null || mgPpm.isEmpty()) {
            mgPpm = "0.0";
        }

        if (naPpm == null || naPpm.isEmpty()) {
            naPpm = "0.0";
        }

        if (so4Ppm == null || so4Ppm.isEmpty()) {
            so4Ppm = "0.0";
        }

        if (clPpm == null || clPpm.isEmpty()) {
            clPpm = "0.0";
        }

        if (hco3Ppm == null || hco3Ppm.isEmpty()) {
            hco3Ppm = "0.0";
        }

        if (caso4G == null || caso4G.isEmpty()) {
            caso4G = "0.0";
        }

        if (naclG == null || naclG.isEmpty()) {
            naclG = "0.0";
        }

        if (mgso4G == null || mgso4G.isEmpty()) {
            mgso4G = "0.0";
        }

        if (caclG == null || caclG.isEmpty()) {
            caclG = "0.0";
        }

        if (nahco3G == null || nahco3G.isEmpty()) {
            nahco3G = "0.0";
        }

        if (caco3G == null || caco3G.isEmpty()) {
            caco3G = "0.0";
        }

        if (batchSize == null || batchSize.isEmpty()) {
            batchSize = "0.0";
        }

        // TODO: address duplicate code
        if (buttonAction.equals("submit")) {
            if (componentId == null || componentId.isEmpty()) {

                componentEntity = new ComponentEntity();
                componentWaterEntity = new ComponentWaterEntity();

                componentEntity.setUpdateDate(ts);
                componentEntity.setCreateDate(ts);

                componentWaterEntity.setUpdateDate(ts);
                componentWaterEntity.setCreateDate(ts);

                componentWaterEntity.setName(waterName);
                componentWaterEntity.setBatchSizeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(batchSizeUomId)));
                componentWaterEntity.setPh(new BigDecimal(ph));
                componentWaterEntity.setCaPpm(new BigDecimal(caPpm));
                componentWaterEntity.setMgPpm(new BigDecimal(mgPpm));
                componentWaterEntity.setNaPpm(new BigDecimal(naPpm));
                componentWaterEntity.setSo4Ppm(new BigDecimal(so4Ppm));
                componentWaterEntity.setClPpm(new BigDecimal(clPpm));
                componentWaterEntity.setHco3Ppm(new BigDecimal(hco3Ppm));
                componentWaterEntity.setCaso4G(new BigDecimal(caso4G));
                componentWaterEntity.setNaclG(new BigDecimal(naclG));
                componentWaterEntity.setMgso4G(new BigDecimal(mgso4G));
                componentWaterEntity.setCaclG(new BigDecimal(caclG));
                componentWaterEntity.setNahco3G(new BigDecimal(nahco3G));
                componentWaterEntity.setCaco3G(new BigDecimal(caco3G));
                componentWaterEntity.setBatchSize(new BigDecimal(batchSize));
                componentWaterEntity.setNotes(notes);

                // TODO: make this not hard-coded to 4 - Water
                componentEntity.setComponentType(componentTypeDao.getComponentTypeEntity(4));
                // set the relationship between the ComponentEntity object and the ComponentWaterEntity object
                componentEntity.setComponentWater(componentWaterEntity);
                componentWaterEntity.setComponentEntity(componentEntity);
                // persist the ComponentEntity object which will also persist the ComponentWaterEntity object
                componentDao.addComponentEntity(componentEntity);
            } else {

                int id = Integer.parseInt(componentId);

                componentEntity = componentDao.getComponentEntity(id);
                componentWaterEntity = componentEntity.getComponentWater();

                componentEntity.setUpdateDate(ts);
                componentWaterEntity.setUpdateDate(ts);
                componentWaterEntity.setName(waterName);
                componentWaterEntity.setBatchSizeUom(uomTypeDao.getUomTypeEntity(Integer.parseInt(batchSizeUomId)));
                componentWaterEntity.setPh(new BigDecimal(ph));
                componentWaterEntity.setCaPpm(new BigDecimal(caPpm));
                componentWaterEntity.setMgPpm(new BigDecimal(mgPpm));
                componentWaterEntity.setNaPpm(new BigDecimal(naPpm));
                componentWaterEntity.setSo4Ppm(new BigDecimal(so4Ppm));
                componentWaterEntity.setClPpm(new BigDecimal(clPpm));
                componentWaterEntity.setHco3Ppm(new BigDecimal(hco3Ppm));
                componentWaterEntity.setCaso4G(new BigDecimal(caso4G));
                componentWaterEntity.setNaclG(new BigDecimal(naclG));
                componentWaterEntity.setMgso4G(new BigDecimal(mgso4G));
                componentWaterEntity.setCaclG(new BigDecimal(caclG));
                componentWaterEntity.setNahco3G(new BigDecimal(nahco3G));
                componentWaterEntity.setCaco3G(new BigDecimal(caco3G));
                componentWaterEntity.setBatchSize(new BigDecimal(batchSize));
                componentWaterEntity.setNotes(notes);

                componentDao.updateComponentEntity(componentEntity);
                componentWaterDao.updateComponentWaterEntity(componentWaterEntity);

            }
        }

        // TODO: Is this redundant?  Doesn't the 'list' servlet also do this?
        request.setAttribute("waterIngredients", componentWaterDao.getAllComponentWaters());
        response.sendRedirect(url);

    }

}
