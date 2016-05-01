package com.cdperry.brewday.controller.types.Origin;

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
 *  This servlet is used to perform grain type modifications and then show the user all of the
 *  current grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "OriginAddEditActionServlet",
        urlPatterns = { "/doEditOrigin" }
)
public class OriginAddEditActionServlet extends HttpServlet {

    private OriginDao dao;

    public OriginAddEditActionServlet() {
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

        origin.setName(name);
        origin.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (originId == null || originId.isEmpty()) {
                origin.setCreateDate(ts);
                dao.addOriginEntity(origin);
            } else {
                origin.setOriginId(Integer.parseInt(originId));
                origin.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateOriginEntity(origin);
            }
        }

        request.setAttribute("origins", dao.getAllOrigins());
        response.sendRedirect(url);

    }

}
