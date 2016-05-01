package com.cdperry.brewday.controller.types.YeastFormType;

import com.cdperry.brewday.entity.YeastFormEntity;
import com.cdperry.brewday.persistence.YeastFormDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p>
 *  This servlet is used to display the Add/Edit Grain Type page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFormTypeAddEditDisplayServlet",
        urlPatterns = { "/addYeastFormType", "/editYeastFormType" }
)
public class YeastFormTypeAddEditDisplayServlet extends HttpServlet {

    private YeastFormDao yeastFormDao;

    public YeastFormTypeAddEditDisplayServlet() {
        super();
        yeastFormDao = new YeastFormDao();
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

        String url = "/jsp/editYeastFormType.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int yeastFormId = Integer.parseInt(request.getParameter("yeastFormId"));
            YeastFormEntity yeastForm = yeastFormDao.getYeastFormEntity(yeastFormId);
            if (yeastForm != null) {
                request.setAttribute("yeastForm", yeastForm);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "/listYeastFormTypes";
                response.sendRedirect(url);
            }
        }





    }

}
