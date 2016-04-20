package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.entity.SupplierTypeEntity;
import com.cdperry.brewday.persistence.SupplierTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Supplier Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "SupplierTypeEditDisplayServlet",
        urlPatterns = { "/editSupplierType" }
)
public class SupplierTypeEditDisplayServlet extends HttpServlet {

    private SupplierTypeDao dao;

    public SupplierTypeEditDisplayServlet() {
        super();
        dao = new SupplierTypeDao();
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

        String url = "/jsp/editSupplierType.jsp";

        int supplierTypeId = Integer.parseInt(request.getParameter("supplierTypeId"));

        SupplierTypeEntity supplierType = dao.getSupplierTypeEntity(supplierTypeId);

        request.setAttribute("supplierType", supplierType);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
