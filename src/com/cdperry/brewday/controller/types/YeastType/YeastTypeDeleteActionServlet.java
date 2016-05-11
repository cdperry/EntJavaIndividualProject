package com.cdperry.brewday.controller.types.YeastType;

import com.cdperry.brewday.persistence.YeastTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a yeast type and then display the list of remaining yeast types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastTypeDeleteActionServlet",
        urlPatterns = { "/deleteYeastType" }
)
public class YeastTypeDeleteActionServlet extends HttpServlet {

    private YeastTypeDao yeastTypeDao;

    public YeastTypeDeleteActionServlet() {
        super();
        yeastTypeDao = new YeastTypeDao();
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

        String url = "listYeastTypes";
        int yeastTypeId = Integer.parseInt(request.getParameter("yeastTypeId"));

        if (yeastTypeDao.getYeastTypeEntity(yeastTypeId) != null) {
            yeastTypeDao.deleteYeastTypeEntityById(yeastTypeId);
        }

        request.setAttribute("yeastTypes", yeastTypeDao.getAllYeastTypes());

        response.sendRedirect(url);

    }


}
