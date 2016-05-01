package com.cdperry.brewday.controller.types.YeastFormType;

import com.cdperry.brewday.persistence.YeastFormDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display all of the yeast forms in the database
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFormListActionServlet",
        urlPatterns = { "/listYeastForms" }
)
public class YeastFormTypeListActionServlet extends HttpServlet {

    private YeastFormDao dao;

    public YeastFormTypeListActionServlet() {
        super();
        dao = new YeastFormDao();
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

        String url = "/jsp/listYeastForms.jsp";

        request.setAttribute("yeastForms", dao.getAllYeastForms());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }


}
