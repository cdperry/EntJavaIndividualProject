package com.cdperry.brewday.controller;

import com.cdperry.brewday.helpers.chucknorris.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the main page of the application
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "MainDisplayServlet",
        urlPatterns = { "/main" }
)
public class MainDisplayServlet extends HttpServlet {

    /**
     *  This method handles HTTP GET requests.
     *
     *  @param  request                   the HttpServletRequest object
     *  @param  response                   the HttpServletResponse object
     *  @exception  ServletException  if there is a Servlet failure
     *  @exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ChuckNorrisJoke joke = new ChuckNorrisJoke();
        String url = "/jsp/main.jsp";

        request.setAttribute("chuckNorrisJoke", joke);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
