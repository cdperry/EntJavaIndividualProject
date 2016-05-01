package com.cdperry.brewday.controller.types.HopFormType;

import com.cdperry.brewday.entity.HopFormTypeEntity;
import com.cdperry.brewday.persistence.HopFormTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Hop Form Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopFormTypeAddEditDisplayServlet",
        urlPatterns = { "/addHopFormType", "/editHopFormType" }
)
public class HopFormTypeAddEditDisplayServlet extends HttpServlet {

    private HopFormTypeDao hopFormTypeDao;

    public HopFormTypeAddEditDisplayServlet() {
        super();
        hopFormTypeDao = new HopFormTypeDao();
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

        String url = "/jsp/editHopFormType.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int hopFormTypeId = Integer.parseInt(request.getParameter("hopFormTypeId"));
            HopFormTypeEntity hopFormType = hopFormTypeDao.getHopFormTypeEntity(hopFormTypeId);
            if (hopFormType != null) {
                request.setAttribute("hopFormType", hopFormType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/listHopFormTypes";
                response.sendRedirect(url);
            }
        }

    }

}
