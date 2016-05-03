package com.cdperry.brewday.controller.types.ComponentType;

import com.cdperry.brewday.entity.ComponentTypeEntity;
import com.cdperry.brewday.persistence.ComponentTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Component Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "ComponentTypeAddEditDisplayServlet",
        urlPatterns = { "/addComponentType", "/editComponentType" }
)
public class ComponentTypeAddEditDisplayServlet extends HttpServlet {

    private ComponentTypeDao componentTypeDao;

    public ComponentTypeAddEditDisplayServlet() {
        super();
        componentTypeDao = new ComponentTypeDao();
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

        String url = "/jsp/editComponentType.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int componentTypeId = Integer.parseInt(request.getParameter("componentTypeId"));
            ComponentTypeEntity componentType = componentTypeDao.getComponentTypeEntity(componentTypeId);
            if (componentType != null) {
                request.setAttribute("componentType", componentType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/listComponentTypes";
                response.sendRedirect(url);
            }
        }

    }

}
