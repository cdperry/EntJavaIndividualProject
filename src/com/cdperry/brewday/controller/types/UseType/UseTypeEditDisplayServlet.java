package com.cdperry.brewday.controller.types.UseType;

import com.cdperry.brewday.entity.UseTypeEntity;
import com.cdperry.brewday.persistence.UseTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Use Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UseTypeEditDisplayServlet",
        urlPatterns = { "/editUseType" }
)
public class UseTypeEditDisplayServlet extends HttpServlet {

    private UseTypeDao dao;

    public UseTypeEditDisplayServlet() {
        super();
        dao = new UseTypeDao();
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

        String url = "/jsp/editUseType.jsp";

        int useTypeId = Integer.parseInt(request.getParameter("useTypeId"));

        UseTypeEntity useType = dao.getUseTypeEntity(useTypeId);

        request.setAttribute("useType", useType);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
