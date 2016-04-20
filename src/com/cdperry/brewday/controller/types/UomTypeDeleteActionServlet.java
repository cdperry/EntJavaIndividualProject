package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.persistence.UomTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a UOM type and then display the list of remaining UOM types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UomTypeDeleteActionServlet",
        urlPatterns = { "/deleteUomType" }
)
public class UomTypeDeleteActionServlet extends HttpServlet {

    private UomTypeDao dao;

    public UomTypeDeleteActionServlet() {
        super();
        dao = new UomTypeDao();
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

        String url = "/listUomTypes";
        int uomTypeId = Integer.parseInt(request.getParameter("uomTypeId"));

        dao.deleteUomTypeEntityById(uomTypeId);

        request.setAttribute("uomTypes", dao.getAllUomTypes());

        response.sendRedirect(url);

    }


}
