package com.cdperry.brewday.controller.types.SupplierType;

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
 *  This servlet is used to display all of the supplier types in the database
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "SupplierTypeListDisplayServlet",
        urlPatterns = { "/listSupplierTypes" }
)
public class SupplierTypeListDisplayServlet extends HttpServlet {

    private SupplierTypeDao supplierTypeDao;

    public SupplierTypeListDisplayServlet() {
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

        String url = "/jsp/listSupplierTypes.jsp";

        request.setAttribute("supplierTypes", supplierTypeDao.getAllSupplierTypes());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }


}
