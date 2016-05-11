package com.cdperry.brewday.controller.ingredients.grain;

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
 *  This servlet is used to display the Add/Edit Grain Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "GrainAddEditDisplayServlet",
        urlPatterns = { "/addGrain", "/editGrain" }
)
public class GrainAddEditDisplayServlet extends HttpServlet {

    private ComponentDao componentDao;
    private OriginDao originDao;
    private SupplierDao supplierDao;
    private GrainTypeDao grainTypeDao;

    public GrainAddEditDisplayServlet() {
        super();
        componentDao = new ComponentDao();
        originDao = new OriginDao();
        supplierDao = new SupplierDao();
        grainTypeDao = new GrainTypeDao();
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

        String url = "/jsp/editGrain.jsp";

        ComponentEntity component;
        ComponentTypeEntity componentTypeEntity;
        ComponentGrainEntity componentGrain;

        List<GrainTypeEntity> grainTypes;
        List<OriginEntity> origins;
        List<SupplierEntity> suppliers;

        int componentId;

        // get all potential grain types and attach them to the request
        grainTypes = grainTypeDao.getAllGrainTypes();
        request.setAttribute("grainTypes", grainTypes);

        // get all potential origins and add them to the request
        origins = originDao.getAllOrigins();
        request.setAttribute("origins", origins);

        // get all potential suppliers and add them to the request
        suppliers = supplierDao.getAllSuppliers();
        request.setAttribute("suppliers", suppliers);

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
                request.setAttribute("grain", component.getComponentGrain());
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "listAllGrains";
                response.sendRedirect(url);
            }
        }

    }

}
