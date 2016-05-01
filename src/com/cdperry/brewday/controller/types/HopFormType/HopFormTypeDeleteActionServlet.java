package com.cdperry.brewday.controller.types.HopFormType;

import com.cdperry.brewday.persistence.HopFormTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a hop form type and then display the list of remaining hop form types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopFormTypeDeleteActionServlet",
        urlPatterns = { "/deleteHopFormType" }
)
public class HopFormTypeDeleteActionServlet extends HttpServlet {

    private HopFormTypeDao hopFormTypeDao;

    public HopFormTypeDeleteActionServlet() {
        super();
        hopFormTypeDao = new HopFormTypeDao();
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

        String url = "/listHopFormTypes";
        int hopFormTypeId = Integer.parseInt(request.getParameter("hopFormTypeId"));

        if (hopFormTypeDao.getHopFormTypeEntity(hopFormTypeId) != null) {
            hopFormTypeDao.deleteHopFormTypeEntityById(hopFormTypeId);
        }

        request.setAttribute("hopFormTypes", hopFormTypeDao.getAllHopFormTypes());

        response.sendRedirect(url);

    }


}
