package com.cdperry.brewday.controller.types.SupplierType;

import com.cdperry.brewday.persistence.SupplierTypeDao;

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
        name = "SupplierTypeDeleteActionServlet",
        urlPatterns = { "/deleteSupplierType" }
)
public class SupplierTypeDeleteActionServlet extends HttpServlet {

    private SupplierTypeDao dao;

    public SupplierTypeDeleteActionServlet() {
        super();
        dao = new SupplierTypeDao();
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/listSupplierTypes";
        int supplierTypeId = Integer.parseInt(request.getParameter("supplierTypeId"));

        dao.deleteSupplierTypeEntityById(supplierTypeId);

        request.setAttribute("supplierTypes", dao.getAllSupplierTypes());

        response.sendRedirect(url);

    }


}
