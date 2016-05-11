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
 *  This servlet is used to delete a yeastFloc type and then display the list of remaining yeastFloc types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFlocTypeDeleteActionServlet",
        urlPatterns = { "/deleteYeastFlocType" }
)
public class YeastFlocTypeDeleteActionServlet extends HttpServlet {

    private YeastFlocTypeDao yeastFlocTypeDao;

    public YeastFlocTypeDeleteActionServlet() {
        super();
        yeastFlocTypeDao = new YeastFlocTypeDao();
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

        String url = "listYeastFlocTypes";
        int yeastFlocTypeId = Integer.parseInt(request.getParameter("yeastFlocTypeId"));

        if (yeastFlocTypeDao.getYeastFlocTypeEntity(yeastFlocTypeId) != null) {
            yeastFlocTypeDao.deleteYeastFlocTypeEntityById(yeastFlocTypeId);
        }

        request.setAttribute("yeastFlocTypes", yeastFlocTypeDao.getAllYeastFlocTypes());

        response.sendRedirect(url);

    }


}
