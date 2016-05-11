package com.cdperry.brewday.controller.types.YeastType;

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
        name = "YeastTypeAddEditDisplayServlet",
        urlPatterns = { "/addYeastType", "/editYeastType" }
)
public class YeastTypeAddEditDisplayServlet extends HttpServlet {

    private YeastTypeDao yeastTypeDao;

    public YeastTypeAddEditDisplayServlet() {
        super();
        yeastTypeDao = new YeastTypeDao();
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

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int yeastTypeId = Integer.parseInt(request.getParameter("yeastTypeId"));
            YeastTypeEntity yeastType = yeastTypeDao.getYeastTypeEntity(yeastTypeId);
            if (yeastType != null) {
                request.setAttribute("yeastType", yeastType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "listYeastTypes";
                response.sendRedirect(url);
            }
        }





    }

}
