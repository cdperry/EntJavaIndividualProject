package com.cdperry.brewday.controller.equipment;

import com.cdperry.brewday.entity.ProfileEquipmentEntity;
import com.cdperry.brewday.persistence.ProfileEquipmentDao;

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

    public EquipmentAddEditActionServlet() {
        super();
        profileEquipmentDao = new ProfileEquipmentDao();
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

        ProfileEquipmentEntity equipmentProfile = new ProfileEquipmentEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/equipment";

        String profileId = request.getParameter("equipmentProfileId");
        String profileName = request.getParameter("profileName");
        String buttonAction = request.getParameter("buttonAction");
        String createDate = request.getParameter("createDate");

        equipmentProfile.setName(profileName);
        equipmentProfile.setUpdateDate(ts);
        if (createDate == null || createDate.isEmpty()) {
            createDate = "1900-01-01 00:00:00";
        }

        if (buttonAction.equals("submit")) {
            if (profileId == null || profileId.isEmpty()) {
                equipmentProfile.setCreateDate(ts);
                profileEquipmentDao.addProfileEquipmentEntity(equipmentProfile);
            } else {
                equipmentProfile.setProfileEquipmentId(Integer.parseInt(profileId));
                equipmentProfile.setCreateDate(Timestamp.valueOf(createDate));
                profileEquipmentDao.updateProfileEquipmentEntity(equipmentProfile);
            }
        }

        request.setAttribute("equipmentProfiles", profileEquipmentDao.getAllProfileEquipment());
        response.sendRedirect(url);

    }

}
