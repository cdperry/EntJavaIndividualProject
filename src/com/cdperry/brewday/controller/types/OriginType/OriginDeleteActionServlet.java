package com.cdperry.brewday.controller.types.OriginType;

import com.cdperry.brewday.persistence.OriginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a origin and then display the list of remaining origins
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OriginDeleteActionServlet",
        urlPatterns = { "/deleteOrigin" }
)
public class OriginDeleteActionServlet extends HttpServlet {

    private OriginDao dao;

    public OriginDeleteActionServlet() {
        super();
        dao = new OriginDao();
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

        String url = "/listOrigins";
        int originId = Integer.parseInt(request.getParameter("originId"));

        dao.deleteOriginEntityById(originId);

        request.setAttribute("origins", dao.getAllOrigins());

        response.sendRedirect(url);

    }


}
