package com.cdperry.brewday.controller.types.GrainType;

import com.cdperry.brewday.entity.GrainTypeEntity;
import com.cdperry.brewday.persistence.GrainTypeDao;

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
        name = "GrainTypeAddEditDisplayServlet",
        urlPatterns = { "/addGrainType", "/editGrainType" }
)
public class GrainTypeAddEditDisplayServlet extends HttpServlet {

    private GrainTypeDao grainTypeDao;

    public GrainTypeAddEditDisplayServlet() {
        super();
        grainTypeDao = new GrainTypeDao();
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

        String url = "/jsp/editGrainType.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);

        if (request.getParameter("action").equals("insert")) {
            request.setAttribute("actionType", "insert");
            dispatcher.forward(request, response);
        } else {
            int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));
            GrainTypeEntity grainType = grainTypeDao.getGrainTypeEntity(grainTypeId);
            if (grainType != null) {
                request.setAttribute("grainType", grainType);
                request.setAttribute("actionType", "edit");
                dispatcher.forward(request, response);
            } else {
                url = "listGrainTypes";
                response.sendRedirect(url);
            }
        }





    }

}
