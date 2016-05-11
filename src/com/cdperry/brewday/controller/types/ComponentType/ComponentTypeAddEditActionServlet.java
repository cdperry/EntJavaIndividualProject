package com.cdperry.brewday.controller.types.ComponentType;

import com.cdperry.brewday.entity.ComponentTypeEntity;
import com.cdperry.brewday.persistence.ComponentTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *  <p>
 *  This servlet is used to perform component type modifications and then show the user all of the
 *  current component types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "ComponentTypeAddEditActionServlet",
        urlPatterns = { "/doEditComponentType" }
)
public class ComponentTypeAddEditActionServlet extends HttpServlet {

    private ComponentTypeDao dao;

    public ComponentTypeAddEditActionServlet() {
        super();
        dao = new ComponentTypeDao();
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

        ComponentTypeEntity componentType = new ComponentTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "listComponentTypes";

        String name = request.getParameter("name");
        String componentTypeId = request.getParameter("componentTypeId");
        String buttonAction = request.getParameter("buttonAction");

        componentType.setName(name);
        componentType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (componentTypeId == null || componentTypeId.isEmpty()) {
                componentType.setCreateDate(ts);
                dao.addComponentTypeEntity(componentType);
            } else {
                componentType.setComponentTypeId(Integer.parseInt(componentTypeId));
                componentType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateComponentTypeEntity(componentType);
            }
        }

        request.setAttribute("componentTypes", dao.getAllComponentTypes());
        response.sendRedirect(url);

    }

}
