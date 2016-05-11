package com.cdperry.brewday.controller.ingredients.other;

import com.cdperry.brewday.entity.*;
import com.cdperry.brewday.persistence.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Other Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OtherAddEditDisplayServlet",
        urlPatterns = { "/addOther", "/editOther" }
)
public class OtherAddEditDisplayServlet extends HttpServlet {

    private ComponentDao componentDao;
    private UseTypeDao useTypeDao;
    private UomTypeDao uomTypeDao;

    public OtherAddEditDisplayServlet() {
        super();
        componentDao = new ComponentDao();
        useTypeDao = new UseTypeDao();
        uomTypeDao = new UomTypeDao();
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

        String url = "/jsp/editOther.jsp";

        ComponentEntity component;

        List<UseTypeEntity> useTypes;
        List<UomTypeEntity> uomTypes;

        int componentId;

        // get all potential other types and attach them to the request
        useTypes = useTypeDao.getAllUseTypes();
        request.setAttribute("useTypes", useTypes);

        // get all potential other types and attach them to the request
        uomTypes = uomTypeDao.getAllUomTypes();
        request.setAttribute("uomTypes", uomTypes);

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            componentId = Integer.parseInt(request.getParameter("componentId"));
            component = componentDao.getComponentEntity(componentId);
            if (component != null) {
                request.setAttribute("component", component);
                request.setAttribute("other", component.getComponentOther());
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "listAllOthers";
                response.sendRedirect(url);
            }
        }

    }

}
