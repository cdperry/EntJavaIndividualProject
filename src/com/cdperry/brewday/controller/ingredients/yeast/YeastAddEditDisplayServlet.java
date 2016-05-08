package com.cdperry.brewday.controller.ingredients.yeast;

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
 *  This servlet is used to display the Add/Edit Yeast Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastAddEditDisplayServlet",
        urlPatterns = { "/addYeast", "/editYeast" }
)
public class YeastAddEditDisplayServlet extends HttpServlet {

    private ComponentDao componentDao;
    private SupplierDao supplierDao;
    private YeastTypeDao yeastTypeDao;
    private YeastFormDao yeastFormDao;
    private YeastFlocTypeDao yeastFlocTypeDao;

    public YeastAddEditDisplayServlet() {
        super();
        componentDao = new ComponentDao();
        supplierDao = new SupplierDao();
        yeastTypeDao = new YeastTypeDao();
        yeastFormDao = new YeastFormDao();
        yeastFlocTypeDao = new YeastFlocTypeDao();
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

        String url = "/jsp/editYeast.jsp";

        ComponentEntity component;
        ComponentTypeEntity componentTypeEntity;
        ComponentYeastEntity componentYeast;

        List<SupplierEntity> suppliers;
        List<SupplierEntity> laboratories;
        List<YeastTypeEntity> yeastTypes;
        List<YeastFormEntity> yeastForms;
        List<YeastFlocTypeEntity> yeastFlocTypes;

        int componentId;

        // get all potential yeast types and attach them to the request
        yeastTypes = yeastTypeDao.getAllYeastTypes();
        request.setAttribute("yeastTypes", yeastTypes);

        // get all potential yeast forms and attach them to the request
        yeastForms = yeastFormDao.getAllYeastForms();
        request.setAttribute("yeastForms", yeastForms);

        // get all potential yeast flocculation types and attach them to the request
        yeastFlocTypes = yeastFlocTypeDao.getAllYeastFlocTypes();
        request.setAttribute("yeastFlocTypes", yeastFlocTypes);

        // get all potential suppliers and add them to the request
        suppliers = supplierDao.getAllSuppliers();
        request.setAttribute("suppliers", suppliers);

        // get all potential suppliers and add them to the request
        laboratories = supplierDao.getAllSuppliers();
        request.setAttribute("laboratories", laboratories);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            componentId = Integer.parseInt(request.getParameter("componentId"));
            component = componentDao.getComponentEntity(componentId);
            if (component != null) {
                request.setAttribute("component", component);
                request.setAttribute("yeast", component.getComponentYeast());
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/listAllYeasts";
                response.sendRedirect(url);
            }
        }

    }

}
