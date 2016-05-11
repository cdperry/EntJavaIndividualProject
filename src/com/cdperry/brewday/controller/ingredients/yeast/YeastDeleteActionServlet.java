package com.cdperry.brewday.controller.ingredients.yeast;

import com.cdperry.brewday.persistence.ComponentYeastDao;

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
        name = "YeastDeleteActionServlet",
        urlPatterns = { "/deleteYeast" }
)
public class YeastDeleteActionServlet extends HttpServlet {

    private ComponentYeastDao componentYeastDao;

    public YeastDeleteActionServlet() {
        super();
        componentYeastDao = new ComponentYeastDao();
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

        String url = "listAllYeasts";
        int componentId = Integer.parseInt(request.getParameter("componentId"));

        if (componentYeastDao.getComponentYeastEntity(componentId) != null) {
            componentYeastDao.deleteComponentYeastEntityById(componentId);
        }

        request.setAttribute("yeastIngredients", componentYeastDao.getAllComponentYeasts());
        response.sendRedirect(url);

    }


}
