package com.cdperry.brewday.controller.types.YeastFlocType;

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
 *  This servlet is used to display the Add/Edit YeastFloc Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFlocTypeAddEditDisplayServlet",
        urlPatterns = { "/addYeastFlocType", "/editYeastFlocType" }
)
public class YeastFlocTypeAddEditDisplayServlet extends HttpServlet {

    private YeastFlocTypeDao yeastFlocTypeDao;

    public YeastFlocTypeAddEditDisplayServlet() {
        super();
        yeastFlocTypeDao = new YeastFlocTypeDao();
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

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int yeastFlocTypeId = Integer.parseInt(request.getParameter("yeastFlocTypeId"));
            YeastFlocTypeEntity yeastFlocType = yeastFlocTypeDao.getYeastFlocTypeEntity(yeastFlocTypeId);
            if (yeastFlocType != null) {
                request.setAttribute("yeastFlocType", yeastFlocType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "listYeastFlocTypes";
                response.sendRedirect(url);
            }
        }





    }

}
