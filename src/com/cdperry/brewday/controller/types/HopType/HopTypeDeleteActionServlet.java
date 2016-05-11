package com.cdperry.brewday.controller.types.HopType;

import com.cdperry.brewday.persistence.HopTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a hop type and then display the list of remaining hop types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopTypeDeleteActionServlet",
        urlPatterns = { "/deleteHopType" }
)
public class HopTypeDeleteActionServlet extends HttpServlet {

    private HopTypeDao hopTypeDao;

    public HopTypeDeleteActionServlet() {
        super();
        hopTypeDao = new HopTypeDao();
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

        String url = "listHopTypes";
        int hopTypeId = Integer.parseInt(request.getParameter("hopTypeId"));

        if (hopTypeDao.getHopTypeEntity(hopTypeId) != null) {
            hopTypeDao.deleteHopTypeEntityById(hopTypeId);
        }

        request.setAttribute("hopTypes", hopTypeDao.getAllHopTypes());

        response.sendRedirect(url);

    }


}
