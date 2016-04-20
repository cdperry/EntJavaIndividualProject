package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.entity.OriginEntity;
import com.cdperry.brewday.persistence.OriginDao;

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
 *  This servlet is used to perform origin modifications and then show the user all of the
 *  current origins
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OriginEditActionServlet",
        urlPatterns = { "/doEditOrigin" }
)
public class OriginEditActionServlet extends HttpServlet {

    private OriginDao dao;

    public OriginEditActionServlet() {
        super();
        dao = new OriginDao();
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

        OriginEntity origin = new OriginEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listOrigins";

        String name = request.getParameter("name");
        String originId = request.getParameter("originId");
        String buttonAction = request.getParameter("buttonAction");

        if (buttonAction.equals("submit")) {
            if (originId == null || originId.isEmpty()) {
                origin.setName(name);
                origin.setUpdateDate(ts);
                origin.setCreateDate(ts);
                dao.addOriginEntity(origin);
            } else {
                origin.setOriginId(Integer.parseInt(originId));
                origin.setName(name);
                origin.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                origin.setUpdateDate(ts);
                dao.updateOriginEntity(origin);
            }
        }

        request.setAttribute("origins", dao.getAllOrigins());
        response.sendRedirect(url);

    }

}
