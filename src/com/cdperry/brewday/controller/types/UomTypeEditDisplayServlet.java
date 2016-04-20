package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.entity.UomTypeEntity;
import com.cdperry.brewday.persistence.UomTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit UOM Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UomTypeEditDisplayServlet",
        urlPatterns = { "/editUomType" }
)
public class UomTypeEditDisplayServlet extends HttpServlet {

    private UomTypeDao dao;

    public UomTypeEditDisplayServlet() {
        super();
        dao = new UomTypeDao();
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

        String url = "/jsp/editUomType.jsp";

        int uomTypeId = Integer.parseInt(request.getParameter("uomTypeId"));

        UomTypeEntity uomType = dao.getUomTypeEntity(uomTypeId);

        request.setAttribute("uomType", uomType);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
