package com.cdperry.brewday.controller.types.YeastFormType;

import com.cdperry.brewday.persistence.YeastFormDao;

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
        name = "YeastFormTypeDeleteActionServlet",
        urlPatterns = { "/deleteYeastFormType" }
)
public class YeastFormTypeDeleteActionServlet extends HttpServlet {

    private YeastFormDao yeastFormDao;

    public YeastFormTypeDeleteActionServlet() {
        super();
        yeastFormDao = new YeastFormDao();
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

        String url = "/listYeastFormTypes";
        int yeastFormId = Integer.parseInt(request.getParameter("yeastFormId"));

        if (yeastFormDao.getYeastFormEntity(yeastFormId) != null) {
            yeastFormDao.deleteYeastFormEntityById(yeastFormId);
        }

        request.setAttribute("yeastForms", yeastFormDao.getAllYeastForms());

        response.sendRedirect(url);

    }


}
