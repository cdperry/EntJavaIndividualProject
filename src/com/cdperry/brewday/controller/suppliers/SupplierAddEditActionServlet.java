package com.cdperry.brewday.controller.suppliers;

import com.cdperry.brewday.entity.*;
import com.cdperry.brewday.persistence.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
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
        name = "SupplierAddEditActionServlet",
        urlPatterns = { "/doEditSupplier" }
)
public class SupplierAddEditActionServlet extends HttpServlet {

    private SupplierDao supplierDao;
    private SupplierTypeDao supplierTypeDao;

    public SupplierAddEditActionServlet() {
        super();
        supplierDao = new SupplierDao();
        supplierTypeDao = new SupplierTypeDao();
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

        SupplierEntity supplierEntity;

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "suppliers";

        String buttonAction = request.getParameter("buttonAction");
        String supplierId = request.getParameter("supplierId");
        String supplierTypeId = request.getParameter("supplierTypeId");
        String supplierName = request.getParameter("name");
        String supplierUrl = request.getParameter("url");
        String supplierEmail = request.getParameter("email");
        String supplierPhone = request.getParameter("phone");
        String supplierContact = request.getParameter("contactName");
        String notes = request.getParameter("notes");


        // TODO: address duplicate code
        if (buttonAction.equals("submit")) {
            if (supplierId == null || supplierId.isEmpty()) {

                supplierEntity = new SupplierEntity();

                supplierEntity.setUpdateDate(ts);
                supplierEntity.setCreateDate(ts);

                supplierEntity.setName(supplierName);
                supplierEntity.setSupplierType(supplierTypeDao.getSupplierTypeEntity(Integer.parseInt(supplierTypeId)));
                supplierEntity.setUrl(supplierUrl);
                supplierEntity.setEmail(supplierEmail);
                supplierEntity.setPhone(supplierPhone);
                supplierEntity.setContactName(supplierContact);
                supplierEntity.setNotes(notes);

                supplierDao.addSupplierEntity(supplierEntity);
            } else {

                int id = Integer.parseInt(supplierId);

                supplierEntity = supplierDao.getSupplierEntity(id);

                supplierEntity.setUpdateDate(ts);
                supplierEntity.setName(supplierName);
                supplierEntity.setSupplierType(supplierTypeDao.getSupplierTypeEntity(Integer.parseInt(supplierTypeId)));
                supplierEntity.setUrl(supplierUrl);
                supplierEntity.setEmail(supplierEmail);
                supplierEntity.setPhone(supplierPhone);
                supplierEntity.setContactName(supplierContact);
                supplierEntity.setNotes(notes);

                supplierDao.updateSupplierEntity(supplierEntity);

            }
        }

        // TODO: Is this redundant?  Doesn't the 'list' servlet also do this?
        request.setAttribute("suppliers", supplierDao.getAllSuppliers());
        response.sendRedirect(url);

    }

}
