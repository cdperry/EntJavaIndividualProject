package com.cdperry.brewday.controller.suppliers;

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
 *  This servlet is used to display the Add/Edit Supplier Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "SupplierAddEditDisplayServlet",
        urlPatterns = { "/addSupplier", "/editSupplier" }
)
public class SupplierAddEditDisplayServlet extends HttpServlet {

    private SupplierDao supplierDao;
    private SupplierTypeDao supplierTypeDao;

    public SupplierAddEditDisplayServlet() {
        super();
        supplierDao = new SupplierDao();
        supplierTypeDao = new SupplierTypeDao();
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

        String url = "/jsp/editSupplier.jsp";

        SupplierEntity supplier;

        List<SupplierTypeEntity> supplierTypes;

        int supplierId;

        // get all potential supplier types and attach them to the request
        supplierTypes = supplierTypeDao.getAllSupplierTypes();
        request.setAttribute("supplierTypes", supplierTypes);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            supplierId = Integer.parseInt(request.getParameter("supplierId"));
            supplier = supplierDao.getSupplierEntity(supplierId);
            if (supplier != null) {
                request.setAttribute("supplier", supplier);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "suppliers";
                response.sendRedirect(url);
            }
        }

    }

}
