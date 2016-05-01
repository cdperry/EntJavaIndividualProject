package com.cdperry.brewday.controller.types.Origin;

import com.cdperry.brewday.persistence.OriginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a grain type and then display the list of remaining grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OriginDeleteActionServlet",
        urlPatterns = { "/deleteOrigin" }
)
public class OriginDeleteActionServlet extends HttpServlet {

    private OriginDao originDao;

    public OriginDeleteActionServlet() {
        super();
        originDao = new OriginDao();
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

        String url = "/listOrigins";
        int originId = Integer.parseInt(request.getParameter("originId"));

        if (originDao.getOriginEntity(originId) != null) {
            originDao.deleteOriginEntityById(originId);
        }

        request.setAttribute("origins", originDao.getAllOrigins());

        response.sendRedirect(url);

    }


}
