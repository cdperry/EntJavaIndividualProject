package com.cdperry.brewday.controller.types.UseType;

import com.cdperry.brewday.persistence.UseTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a use type and then display the list of remaining use types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UseTypeDeleteActionServlet",
        urlPatterns = { "/deleteUseType" }
)
public class UseTypeDeleteActionServlet extends HttpServlet {

    private UseTypeDao useTypeDao;

    public UseTypeDeleteActionServlet() {
        super();
        useTypeDao = new UseTypeDao();
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

        String url = "/listUseTypes";
        int useTypeId = Integer.parseInt(request.getParameter("useTypeId"));

        if (useTypeDao.getUseTypeEntity(useTypeId) != null) {
            useTypeDao.deleteUseTypeEntityById(useTypeId);
        }

        request.setAttribute("useTypes", useTypeDao.getAllUseTypes());

        response.sendRedirect(url);

    }


}
