package com.cdperry.brewday.controller.types;

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
        name = "SupplierTypeEditActionServlet",
        urlPatterns = { "/doEditSupplierType" }
)
public class SupplierTypeEditActionServlet extends HttpServlet {

    private SupplierTypeDao dao;

    public SupplierTypeEditActionServlet() {
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

        if (buttonAction.equals("submit")) {
            if (supplierTypeId == null || supplierTypeId.isEmpty()) {
                supplierType.setName(name);
                supplierType.setUpdateDate(ts);
                supplierType.setCreateDate(ts);
                dao.addSupplierTypeEntity(supplierType);
            } else {
                supplierType.setSupplierTypeId(Integer.parseInt(supplierTypeId));
                supplierType.setName(name);
                supplierType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                supplierType.setUpdateDate(ts);
                dao.updateSupplierTypeEntity(supplierType);
            }
        }

        request.setAttribute("supplierTypes", dao.getAllSupplierTypes());
        response.sendRedirect(url);

    }

}
