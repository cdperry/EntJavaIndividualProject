package com.cdperry.brewday.controller.equipment;

import com.cdperry.brewday.entity.*;
import com.cdperry.brewday.persistence.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Equipment Profile page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "EquipmentProfileAddEditDisplayServlet",
        urlPatterns = { "/addEquipmentProfile", "/editEquipmentProfile" }
)
public class EquipmentAddEditDisplayServlet extends HttpServlet {

    private ProfileEquipmentDao equipmentProfileDao;
    private UomTypeDao uomTypeDao;

    public EquipmentAddEditDisplayServlet() {
        super();
        equipmentProfileDao = new ProfileEquipmentDao();
        uomTypeDao = new UomTypeDao();
    }

    /**
     *  This method handles HTTP GET requests.
     *
     *  @param  request                   the HttpServletRequest object
     *  @param  response                   the HttpServletResponse object
     *  @exception  ServletException  if there is a Servlet failure
     *  @exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/jsp/editEquipmentProfile.jsp";
        int equipmentProfileId;
        ProfileEquipmentEntity equipmentProfile;
        List<UomTypeEntity> uomTypes;

        // get all potential other types and attach them to the request
        uomTypes = uomTypeDao.getAllUomTypes();
        request.setAttribute("uomTypes", uomTypes);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            equipmentProfileId = Integer.parseInt(request.getParameter("profileEquipmentId"));
            equipmentProfile = equipmentProfileDao.getProfileEquipmentEntity(equipmentProfileId);
            if (equipmentProfile != null) {
                request.setAttribute("equipmentProfile", equipmentProfile);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "equipment";
                response.sendRedirect(url);
            }
        }





    }

}
