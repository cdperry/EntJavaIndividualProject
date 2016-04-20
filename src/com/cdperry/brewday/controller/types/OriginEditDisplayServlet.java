package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.entity.OriginEntity;
import com.cdperry.brewday.persistence.OriginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Origin page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OriginEditDisplayServlet",
        urlPatterns = { "/editOrigin" }
)
public class OriginEditDisplayServlet extends HttpServlet {

    private OriginDao dao;

    public OriginEditDisplayServlet() {
        super();
        dao = new OriginDao();
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

        String url = "/jsp/editOrigin.jsp";

        int originId = Integer.parseInt(request.getParameter("originId"));

        OriginEntity origin = dao.getOriginEntity(originId);

        request.setAttribute("origin", origin);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
