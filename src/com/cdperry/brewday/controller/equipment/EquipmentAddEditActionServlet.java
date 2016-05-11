package com.cdperry.brewday.controller.equipment;

import com.cdperry.brewday.entity.ProfileEquipmentEntity;
import com.cdperry.brewday.persistence.ProfileEquipmentDao;
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
 *  This servlet is used to perform equipment profile modifications and then show the user all of the
 *  current equipment profiles
 *  </p>
 *
 *  TODO: Add null createDate test to all servlets of this type
 *
 *  @author Chris Perry
 */
@WebServlet(
        name = "EquipmentAddEditActionServlet",
        urlPatterns = { "/doEditEquipmentProfile" }
)
public class EquipmentAddEditActionServlet extends HttpServlet {

    private ProfileEquipmentDao profileEquipmentDao;
    private UomTypeDao uomTypeDao;

    public EquipmentAddEditActionServlet() {
        super();
        profileEquipmentDao = new ProfileEquipmentDao();
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

        ProfileEquipmentEntity equipmentProfile;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "equipment";

        String profileId = request.getParameter("equipmentProfileId");
        String profileName = request.getParameter("profileName");
        String buttonAction = request.getParameter("buttonAction");
        String createDate = request.getParameter("createDate");
        String batchVol = request.getParameter("batchVol");
        String batchVolUomId = request.getParameter("batchVolUomId");
        String boilVol = request.getParameter("boilVol");
        String boilVolUomId = request.getParameter("boilVolUomId");
        String bottlingVol = request.getParameter("bottlingVol");
        String bottlingVolUomId = request.getParameter("bottlingVolUomId");
        String notes = request.getParameter("notes");

        if (batchVol == null || batchVol.isEmpty()) {
            batchVol = "0.0";
        }

        if (boilVol == null || boilVol.isEmpty()) {
            boilVol = "0.0";
        }

        if (bottlingVol == null || bottlingVol.isEmpty()) {
            bottlingVol = "0.0";
        }

        if (buttonAction.equals("submit")) {
            if (profileId == null || profileId.isEmpty()) {
                equipmentProfile = new ProfileEquipmentEntity();
                equipmentProfile.setCreateDate(ts);
                equipmentProfile.setUpdateDate(ts);
                equipmentProfile.setName(profileName);
                equipmentProfile.setFermBatchVol(new BigDecimal(batchVol));
                //equipmentProfile.setBatch(uomTypeDao.getUomTypeEntity(Integer.parseInt(batchVolUomId))));
                equipmentProfile.setBoilVol(new BigDecimal(boilVol));
                equipmentProfile.setBottlingVol(new BigDecimal(bottlingVol));
                equipmentProfile.setNotes(notes);
                profileEquipmentDao.addProfileEquipmentEntity(equipmentProfile);
            } else {
                int id = Integer.parseInt(profileId);

                equipmentProfile = profileEquipmentDao.getProfileEquipmentEntity(id);
                equipmentProfile.setName(profileName);
                equipmentProfile.setFermBatchVol(new BigDecimal(batchVol));
                //equipmentProfile.setBatch(uomTypeDao.getUomTypeEntity(Integer.parseInt(batchVolUomId))));
                equipmentProfile.setBoilVol(new BigDecimal(boilVol));
                equipmentProfile.setBottlingVol(new BigDecimal(bottlingVol));
                equipmentProfile.setUpdateDate(ts);
                equipmentProfile.setNotes(notes);

                profileEquipmentDao.updateProfileEquipmentEntity(equipmentProfile);
            }
        }

        request.setAttribute("equipmentProfiles", profileEquipmentDao.getAllProfileEquipment());
        response.sendRedirect(url);

    }

}
