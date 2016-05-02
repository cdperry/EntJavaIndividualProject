package com.cdperry.brewday.controller.equipment;

import com.cdperry.brewday.persistence.ProfileEquipmentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a grain type and then display the list of remaining grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "EquipmentDeleteActionServlet",
        urlPatterns = { "/deleteEquipmentProfile" }
)
public class EquipmentDeleteActionServlet extends HttpServlet {

    private ProfileEquipmentDao equipmentProfileDao;

    public EquipmentDeleteActionServlet() {
        super();
        equipmentProfileDao = new ProfileEquipmentDao();
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

        String url = "/equipment";
        int equipmentProfileId = Integer.parseInt(request.getParameter("profileEquipmentId"));

        if (equipmentProfileDao.getProfileEquipmentEntity(equipmentProfileId) != null) {
            equipmentProfileDao.deleteProfileEquipmentEntityById(equipmentProfileId);
        }

        request.setAttribute("equipmentProfiles", equipmentProfileDao.getAllProfileEquipment());

        response.sendRedirect(url);

    }


}
