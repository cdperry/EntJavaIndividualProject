package com.cdperry.brewday.controller.suppliers;

import com.cdperry.brewday.persistence.*;
import com.cdperry.brewday.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a supplier type and then display the list of remaining supplier types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "SupplierDeleteActionServlet",
        urlPatterns = { "/deleteSupplier" }
)
public class SupplierDeleteActionServlet extends HttpServlet {

    private SupplierDao supplierDao;

    public SupplierDeleteActionServlet() {
        super();
        supplierDao = new SupplierDao();
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

        String url = "suppliers";
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));

        if (supplierDao.getSupplierEntity(supplierId) != null) {
            supplierDao.deleteSupplierEntityById(supplierId);
        }

        request.setAttribute("suppliers", supplierDao.getAllSuppliers());
        response.sendRedirect(url);

    }


}
