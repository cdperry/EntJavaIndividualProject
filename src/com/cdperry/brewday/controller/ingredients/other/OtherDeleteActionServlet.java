package com.cdperry.brewday.controller.ingredients.other;

import com.cdperry.brewday.persistence.ComponentOtherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a other type and then display the list of remaining other types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OtherDeleteActionServlet",
        urlPatterns = { "/deleteOther" }
)
public class OtherDeleteActionServlet extends HttpServlet {

    private ComponentOtherDao componentOtherDao;

    public OtherDeleteActionServlet() {
        super();
        componentOtherDao = new ComponentOtherDao();
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

        String url = "listAllOthers";
        int componentId = Integer.parseInt(request.getParameter("componentId"));

        if (componentOtherDao.getComponentOtherEntity(componentId) != null) {
            componentOtherDao.deleteComponentOtherEntityById(componentId);
        }

        request.setAttribute("otherIngredients", componentOtherDao.getAllComponentOthers());
        response.sendRedirect(url);

    }


}
