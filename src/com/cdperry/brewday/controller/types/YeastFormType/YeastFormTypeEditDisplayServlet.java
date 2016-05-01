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
 *  This servlet is used to display the Add/Edit Yeast Form page
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFormEditDisplayServlet",
        urlPatterns = { "/editYeastForm" }
)
public class YeastFormTypeEditDisplayServlet extends HttpServlet {

    private YeastFormDao dao;

    public YeastFormTypeEditDisplayServlet() {
        super();
        dao = new YeastFormDao();
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

        String url = "/jsp/editYeastForm.jsp";

        int yeastFormId = Integer.parseInt(request.getParameter("yeastFormId"));

        YeastFormEntity yeastForm = dao.getYeastFormEntity(yeastFormId);

        request.setAttribute("yeastForm", yeastForm);
        request.setAttribute("actionType", "edit");

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}
