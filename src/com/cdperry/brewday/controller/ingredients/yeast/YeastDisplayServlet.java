package com.cdperry.brewday.controller.ingredients.yeast;

import com.cdperry.brewday.persistence.ComponentYeastDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the yeast available for recipes
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastDisplayServlet",
        urlPatterns = { "/listAllYeasts" }
)
public class YeastDisplayServlet extends HttpServlet {

    private ComponentYeastDao componentYeastDao;

    public YeastDisplayServlet() {
        super();
        componentYeastDao = new ComponentYeastDao();
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

        String url = "/jsp/listYeasts.jsp";

        request.setAttribute("yeastIngredients", componentYeastDao.getAllComponentYeasts());
        request.setAttribute("actionType", "list");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
