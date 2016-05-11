package com.cdperry.brewday.controller.types.UomType;

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
 *  This servlet is used to display the Add/Edit Uom Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UomTypeAddEditDisplayServlet",
        urlPatterns = { "/addUomType", "/editUomType" }
)
public class UomTypeAddEditDisplayServlet extends HttpServlet {

    private UomTypeDao uomTypeDao;

    public UomTypeAddEditDisplayServlet() {
        super();
        uomTypeDao = new UomTypeDao();
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

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int uomId = Integer.parseInt(request.getParameter("uomId"));
            UomTypeEntity uomType = uomTypeDao.getUomTypeEntity(uomId);
            if (uomType != null) {
                request.setAttribute("uomType", uomType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "listUomTypes";
                response.sendRedirect(url);
            }
        }





    }

}
