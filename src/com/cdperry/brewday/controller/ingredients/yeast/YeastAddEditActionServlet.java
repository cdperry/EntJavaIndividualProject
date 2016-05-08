package com.cdperry.brewday.controller.ingredients.yeast;

import com.cdperry.brewday.entity.ComponentEntity;
import com.cdperry.brewday.entity.ComponentYeastEntity;
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
 *  This servlet is used to perform yeast type modifications and then show the user all of the
 *  current yeast types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastAddEditActionServlet",
        urlPatterns = { "/doEditYeast" }
)
public class YeastAddEditActionServlet extends HttpServlet {

    private ComponentDao componentDao;
    private ComponentYeastDao componentYeastDao;
    private ComponentTypeDao componentTypeDao;
    private OriginDao originDao;
    private SupplierDao supplierDao;
    private YeastTypeDao yeastTypeDao;
    private YeastFormDao yeastFormDao;
    private YeastFlocTypeDao yeastFlocTypeDao;

    public YeastAddEditActionServlet() {
        super();
        componentDao = new ComponentDao();
        componentYeastDao = new ComponentYeastDao();
        componentTypeDao = new ComponentTypeDao();
        originDao = new OriginDao();
        supplierDao = new SupplierDao();
        yeastTypeDao = new YeastTypeDao();
        yeastFormDao = new YeastFormDao();
        yeastFlocTypeDao = new YeastFlocTypeDao();
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
        ComponentYeastEntity componentYeastEntity;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listAllYeasts";

        String buttonAction = request.getParameter("buttonAction");
        String componentId = request.getParameter("componentId");
        String yeastName = request.getParameter("name");
        String laboratoryId = request.getParameter("laboratoryId");
        String supplierId = request.getParameter("supplierId");
        String yeastTypeId = request.getParameter("yeastTypeId");
        String yeastFormId = request.getParameter("yeastFormId");
        String yeastFlocTypeId = request.getParameter("yeastFlocTypeId");
        String attenuationMin = request.getParameter("attenuationMin");
        String attenuationMax = request.getParameter("attenuationMax");
        String temperatureMin = request.getParameter("temperatureMin");
        String temperatureMax = request.getParameter("temperatureMax");
        String cellsPerPack = request.getParameter("cellsPerPack");
        String notes = request.getParameter("notes");

        if (attenuationMin == null || attenuationMin.isEmpty()) {
            attenuationMin = "0.0";
        }

        if (attenuationMax == null || attenuationMax.isEmpty()) {
            attenuationMax = "0.0";
        }

        if (temperatureMin == null || temperatureMin.isEmpty()) {
            temperatureMin = "0.0";
        }

        if (temperatureMax == null || temperatureMax.isEmpty()) {
            temperatureMax = "0.0";
        }

        if (cellsPerPack == null || cellsPerPack.isEmpty()) {
            cellsPerPack = "0.0";
        }

        // TODO: address duplicate code
        if (buttonAction.equals("submit")) {
            if (componentId == null || componentId.isEmpty()) {

                componentEntity = new ComponentEntity();
                componentYeastEntity = new ComponentYeastEntity();

                componentEntity.setUpdateDate(ts);
                componentEntity.setCreateDate(ts);

                componentYeastEntity.setUpdateDate(ts);
                componentYeastEntity.setCreateDate(ts);

                componentYeastEntity.setName(yeastName);
                componentYeastEntity.setLab(supplierDao.getSupplierEntity(Integer.parseInt(laboratoryId)));
                componentYeastEntity.setSupplier(supplierDao.getSupplierEntity(Integer.parseInt(supplierId)));
                componentYeastEntity.setYeastType(yeastTypeDao.getYeastTypeEntity(Integer.parseInt(yeastTypeId)));
                componentYeastEntity.setYeastForm(yeastFormDao.getYeastFormEntity(Integer.parseInt(yeastFormId)));
                componentYeastEntity.setYeastFlocType(yeastFlocTypeDao.getYeastFlocTypeEntity(Integer.parseInt(yeastFlocTypeId)));
                componentYeastEntity.setAttenuationMin(new BigDecimal(attenuationMin));
                componentYeastEntity.setAttenuationMax(new BigDecimal(attenuationMax));
                componentYeastEntity.setTemperatureMin(new BigDecimal(temperatureMin));
                componentYeastEntity.setTemperatureMax(new BigDecimal(temperatureMax));
                componentYeastEntity.setCellsPerPack(new BigDecimal(cellsPerPack));
                componentYeastEntity.setNotes(notes);

                // TODO: make this not hard-coded to 3 - Yeast
                componentEntity.setComponentType(componentTypeDao.getComponentTypeEntity(3));
                // set the relationship between the ComponentEntity object and the ComponentYeastEntity object
                componentEntity.setComponentYeast(componentYeastEntity);
                componentYeastEntity.setComponentEntity(componentEntity);
                // persist the ComponentEntity object which will also persist the ComponentYeastEntity object
                componentDao.addComponentEntity(componentEntity);
            } else {

                int id = Integer.parseInt(componentId);

                componentEntity = componentDao.getComponentEntity(id);
                componentYeastEntity = componentEntity.getComponentYeast();

                componentEntity.setUpdateDate(ts);
                componentYeastEntity.setUpdateDate(ts);

                componentYeastEntity.setName(yeastName);
                componentYeastEntity.setLab(supplierDao.getSupplierEntity(Integer.parseInt(laboratoryId)));
                componentYeastEntity.setSupplier(supplierDao.getSupplierEntity(Integer.parseInt(supplierId)));
                componentYeastEntity.setYeastType(yeastTypeDao.getYeastTypeEntity(Integer.parseInt(yeastTypeId)));
                componentYeastEntity.setYeastForm(yeastFormDao.getYeastFormEntity(Integer.parseInt(yeastFormId)));
                componentYeastEntity.setYeastFlocType(yeastFlocTypeDao.getYeastFlocTypeEntity(Integer.parseInt(yeastFlocTypeId)));
                componentYeastEntity.setAttenuationMin(new BigDecimal(attenuationMin));
                componentYeastEntity.setAttenuationMax(new BigDecimal(attenuationMax));
                componentYeastEntity.setTemperatureMin(new BigDecimal(temperatureMin));
                componentYeastEntity.setTemperatureMax(new BigDecimal(temperatureMax));
                componentYeastEntity.setCellsPerPack(new BigDecimal(cellsPerPack));
                componentYeastEntity.setNotes(notes);

                componentDao.updateComponentEntity(componentEntity);
                componentYeastDao.updateComponentYeastEntity(componentYeastEntity);

            }
        }

        // TODO: Is this redundant?  Doesn't the 'list' servlet also do this?
        request.setAttribute("yeastIngredients", componentYeastDao.getAllComponentYeasts());
        response.sendRedirect(url);

    }

}
