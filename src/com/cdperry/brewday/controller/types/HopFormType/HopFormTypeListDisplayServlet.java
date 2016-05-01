package com.cdperry.brewday.controller.types.HopFormType;

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
 *  This servlet is used to display all of the hop form types in the database
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopFormTypeListDisplayServlet",
        urlPatterns = { "/listHopFormTypes" }
)
public class HopFormTypeListDisplayServlet extends HttpServlet {

    private HopFormTypeDao hopFormTypeDao;

    public HopFormTypeListDisplayServlet() {
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

        String url = "/jsp/listHopFormTypes.jsp";

        request.setAttribute("hopFormTypes", hopFormTypeDao.getAllHopFormTypes());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }


}
