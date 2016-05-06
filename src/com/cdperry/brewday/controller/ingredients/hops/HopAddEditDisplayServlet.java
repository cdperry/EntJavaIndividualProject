package com.cdperry.brewday.controller.ingredients.hops;

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
 *  This servlet is used to display the Add/Edit Hop Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopAddEditDisplayServlet",
        urlPatterns = { "/addHop", "/editHop" }
)
public class HopAddEditDisplayServlet extends HttpServlet {

    private ComponentDao componentDao;
    private ComponentTypeDao componentTypeDao;
    private ComponentHopDao componentHopDao;
    private OriginDao originDao;
    private SupplierDao supplierDao;
    private HopTypeDao hopTypeDao;
    private HopFormTypeDao hopFormTypeDao;


    public HopAddEditDisplayServlet() {
        super();
        componentDao = new ComponentDao();
        componentTypeDao = new ComponentTypeDao();
        componentHopDao = new ComponentHopDao();
        originDao = new OriginDao();
        supplierDao = new SupplierDao();
        hopTypeDao = new HopTypeDao();
        hopFormTypeDao = new HopFormTypeDao();
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

        String url = "/jsp/editHop.jsp";

        ComponentEntity component;
        ComponentTypeEntity componentTypeEntity;
        ComponentHopEntity componentHop;

        List<HopTypeEntity> hopTypes;
        List<HopFormTypeEntity> hopFormTypes;
        List<OriginEntity> origins;
        List<SupplierEntity> suppliers;

        int componentId;

        // get the 'hop' component type
        // TODO: maybe change this to get by name instead of ID? This requires that the component types never change
        componentTypeEntity = componentTypeDao.getComponentTypeEntity(1);

        // get all potential hop types and attach them to the request
        hopTypes = hopTypeDao.getAllHopTypes();
        request.setAttribute("hopTypes", hopTypes);

        // get all potential hop types and attach them to the request
        hopFormTypes = hopFormTypeDao.getAllHopFormTypes();
        request.setAttribute("hopForms", hopFormTypes);

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
                request.setAttribute("hop", component.getComponentHop());
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/hops";
                response.sendRedirect(url);
            }
        }

    }

}
