package com.cdperry.brewday.controller.ingredients.other;

import com.cdperry.brewday.persistence.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the other available for recipes
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OtherDisplayServlet",
        urlPatterns = { "/listAllOthers" }
)
public class OtherDisplayServlet extends HttpServlet {

    private ComponentOtherDao componentOtherDao;

    public OtherDisplayServlet() {
        super();
        componentOtherDao = new ComponentOtherDao();
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

        String url = "/jsp/listMiscs.jsp";

        request.setAttribute("otherIngredients", componentOtherDao.getAllComponentOthers());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
