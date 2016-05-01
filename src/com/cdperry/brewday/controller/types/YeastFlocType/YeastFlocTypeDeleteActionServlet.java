package com.cdperry.brewday.controller.types.YeastFlocType;

import com.cdperry.brewday.persistence.YeastFlocTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a Yeast Flocculation type and then display the list of
 *  remaining Yeast Flocculation types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFlocTypeDeleteActionServlet",
        urlPatterns = { "/deleteYeastFlocType" }
)
public class YeastFlocTypeDeleteActionServlet extends HttpServlet {

    private YeastFlocTypeDao dao;

    public YeastFlocTypeDeleteActionServlet() {
        super();
        dao = new YeastFlocTypeDao();
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

        String url = "/listYeastFlocTypes";
        int yeastFlocTypeId = Integer.parseInt(request.getParameter("yeastFlocTypeId"));

        dao.deleteYeastFlocTypeEntityById(yeastFlocTypeId);

        request.setAttribute("yeastFlocTypes", dao.getAllYeastFlocTypes());

        response.sendRedirect(url);

    }


}
