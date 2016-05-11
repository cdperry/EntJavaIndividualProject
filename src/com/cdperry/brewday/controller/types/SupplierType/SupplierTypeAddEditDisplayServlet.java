package com.cdperry.brewday.controller.types.SupplierType;

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
        name = "SupplierTypeAddEditDisplayServlet",
        urlPatterns = { "/addSupplierType", "/editSupplierType" }
)
public class SupplierTypeAddEditDisplayServlet extends HttpServlet {

    private SupplierTypeDao supplierTypeDao;

    public SupplierTypeAddEditDisplayServlet() {
        super();
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

        String url = "/jsp/editSupplierType.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int supplierTypeId = Integer.parseInt(request.getParameter("supplierTypeId"));
            SupplierTypeEntity supplierType = supplierTypeDao.getSupplierTypeEntity(supplierTypeId);
            if (supplierType != null) {
                request.setAttribute("supplierType", supplierType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "listSupplierTypes";
                response.sendRedirect(url);
            }
        }





    }

}
