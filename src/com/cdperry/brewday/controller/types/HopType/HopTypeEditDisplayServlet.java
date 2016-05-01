package com.cdperry.brewday.controller.types.HopType;

import com.cdperry.brewday.entity.HopTypeEntity;
import com.cdperry.brewday.persistence.HopTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Hop Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopTypeEditDisplayServlet",
        urlPatterns = { "/editHopTypez" }
)
public class HopTypeEditDisplayServlet extends HttpServlet {

    private HopTypeDao dao;

    public HopTypeEditDisplayServlet() {
        super();
        dao = new HopTypeDao();
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

        String url = "/jsp/editHopType.jsp";

        int hopTypeId = Integer.parseInt(request.getParameter("hopTypeId"));

        HopTypeEntity hopType = dao.getHopTypeEntity(hopTypeId);

        request.setAttribute("hopType", hopType);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
