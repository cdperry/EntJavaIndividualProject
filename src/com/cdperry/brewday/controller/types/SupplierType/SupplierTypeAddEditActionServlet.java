package com.cdperry.brewday.controller.types.SupplierType;

import com.cdperry.brewday.entity.SupplierTypeEntity;
import com.cdperry.brewday.persistence.SupplierTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *  <p>
 *  This servlet is used to perform supplier type modifications and then show the user all of the
 *  current supplier types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "SupplierTypeAddEditActionServlet",
        urlPatterns = { "/doEditSupplierType" }
)
public class SupplierTypeAddEditActionServlet extends HttpServlet {

    private SupplierTypeDao dao;

    public SupplierTypeAddEditActionServlet() {
        super();
        dao = new SupplierTypeDao();
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

        SupplierTypeEntity supplierType = new SupplierTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listSupplierTypes";

        String name = request.getParameter("name");
        String supplierTypeId = request.getParameter("supplierTypeId");
        String buttonAction = request.getParameter("buttonAction");

        supplierType.setName(name);
        supplierType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (supplierTypeId == null || supplierTypeId.isEmpty()) {
                supplierType.setCreateDate(ts);
                dao.addSupplierTypeEntity(supplierType);
            } else {
                supplierType.setSupplierTypeId(Integer.parseInt(supplierTypeId));
                supplierType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateSupplierTypeEntity(supplierType);
            }
        }

        request.setAttribute("supplierTypes", dao.getAllSupplierTypes());
        response.sendRedirect(url);

    }

}
