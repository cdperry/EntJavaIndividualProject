package com.cdperry.brewday.controller.types.ComponentType;

import com.cdperry.brewday.persistence.ComponentTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to delete a component type and then display the list of remaining component types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "ComponentTypeDeleteActionServlet",
        urlPatterns = { "/deleteComponentType" }
)
public class ComponentTypeDeleteActionServlet extends HttpServlet {

    private ComponentTypeDao componentTypeDao;

    public ComponentTypeDeleteActionServlet() {
        super();
        componentTypeDao = new ComponentTypeDao();
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

        String url = "/listComponentTypes";
        int componentTypeId = Integer.parseInt(request.getParameter("componentTypeId"));

        if (componentTypeDao.getComponentTypeEntity(componentTypeId) != null) {
            componentTypeDao.deleteComponentTypeEntityById(componentTypeId);
        }

        request.setAttribute("componentTypes", componentTypeDao.getAllComponentTypes());

        response.sendRedirect(url);

    }


}
