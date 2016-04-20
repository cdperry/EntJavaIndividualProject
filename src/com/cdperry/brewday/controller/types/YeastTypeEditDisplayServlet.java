package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.entity.YeastTypeEntity;
import com.cdperry.brewday.persistence.YeastTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Yeast Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastTypeEditDisplayServlet",
        urlPatterns = { "/editYeastType" }
)
public class YeastTypeEditDisplayServlet extends HttpServlet {

    private YeastTypeDao dao;

    public YeastTypeEditDisplayServlet() {
        super();
        dao = new YeastTypeDao();
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

        String url = "/jsp/editYeastType.jsp";

        int yeastTypeId = Integer.parseInt(request.getParameter("yeastTypeId"));

        YeastTypeEntity yeastType = dao.getYeastTypeEntity(yeastTypeId);

        request.setAttribute("yeastType", yeastType);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
