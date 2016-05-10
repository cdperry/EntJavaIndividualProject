package com.cdperry.brewday.controller.types.UomType;

import com.cdperry.brewday.persistence.UomTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a uom type and then display the list of remaining uom types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UomTypeDeleteActionServlet",
        urlPatterns = { "/deleteUomType" }
)
public class UomTypeDeleteActionServlet extends HttpServlet {

    private UomTypeDao uomTypeDao;

    public UomTypeDeleteActionServlet() {
        super();
        uomTypeDao = new UomTypeDao();
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

        String url = "/listUomTypes";
        int uomId = Integer.parseInt(request.getParameter("uomId"));

        // TODO: maybe put the '100' in a .properties file?
        // TODO: send an error message when trying to delete a system type
        if (uomTypeDao.getUomTypeEntity(uomId) != null && uomId >= 100) {
            uomTypeDao.deleteUomTypeEntityById(uomId);
        }

        request.setAttribute("uomTypes", uomTypeDao.getAllUomTypes());

        response.sendRedirect(url);

    }


}
