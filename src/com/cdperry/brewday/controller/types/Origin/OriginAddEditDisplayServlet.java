package com.cdperry.brewday.controller.types.Origin;

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
 *  This servlet is used to display the Add/Edit Grain Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OriginAddEditDisplayServlet",
        urlPatterns = { "/addOrigin", "/editOrigin" }
)
public class OriginAddEditDisplayServlet extends HttpServlet {

    private OriginDao originDao;

    public OriginAddEditDisplayServlet() {
        super();
        originDao = new OriginDao();
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

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int originId = Integer.parseInt(request.getParameter("originId"));
            OriginEntity origin = originDao.getOriginEntity(originId);
            if (origin != null) {
                request.setAttribute("origin", origin);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/listOrigins";
                response.sendRedirect(url);
            }
        }





    }

}
