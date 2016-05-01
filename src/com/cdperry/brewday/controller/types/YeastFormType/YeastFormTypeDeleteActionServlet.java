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
 *  This servlet is used to delete a yeast form and then display the list of remaining yeast forms
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFormDeleteActionServlet",
        urlPatterns = { "/deleteYeastForm" }
)
public class YeastFormTypeDeleteActionServlet extends HttpServlet {

    private YeastFormDao dao;

    public YeastFormTypeDeleteActionServlet() {
        super();
        dao = new YeastFormDao();
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

        String url = "/listYeastForms";
        int yeastFormId = Integer.parseInt(request.getParameter("yeastFormId"));

        dao.deleteYeastFormEntityById(yeastFormId);

        request.setAttribute("yeastForms", dao.getAllYeastForms());

        response.sendRedirect(url);

    }


}
