package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.entity.YeastFlocTypeEntity;
import com.cdperry.brewday.persistence.YeastFlocTypeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Yeast Flocculation Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFlocTypeEditDisplayServlet",
        urlPatterns = { "/editYeastFlocType" }
)
public class YeastFlocTypeEditDisplayServlet extends HttpServlet {

    private YeastFlocTypeDao dao;

    public YeastFlocTypeEditDisplayServlet() {
        super();
        dao = new YeastFlocTypeDao();
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

        String url = "/jsp/editYeastFlocType.jsp";

        int yeastFlocTypeId = Integer.parseInt(request.getParameter("yeastFlocTypeId"));

        YeastFlocTypeEntity yeastFlocType = dao.getYeastFlocTypeEntity(yeastFlocTypeId);

        request.setAttribute("yeastFlocType", yeastFlocType);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}