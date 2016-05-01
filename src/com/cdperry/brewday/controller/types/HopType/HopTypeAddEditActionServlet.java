package com.cdperry.brewday.controller.types.HopType;

import com.cdperry.brewday.entity.HopTypeEntity;
import com.cdperry.brewday.persistence.HopTypeDao;

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
 *  This servlet is used to perform hop type modifications and then show the user all of the
 *  current hop types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopTypeAddEditActionServlet",
        urlPatterns = { "/doEditHopType" }
)
public class HopTypeAddEditActionServlet extends HttpServlet {

    private HopTypeDao dao;

    public HopTypeAddEditActionServlet() {
        super();
        dao = new HopTypeDao();
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

        HopTypeEntity hopType = new HopTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listHopTypes";

        String name = request.getParameter("name");
        String hopTypeId = request.getParameter("hopTypeId");
        String buttonAction = request.getParameter("buttonAction");

        hopType.setName(name);
        hopType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (hopTypeId == null || hopTypeId.isEmpty()) {
                hopType.setCreateDate(ts);
                dao.addHopTypeEntity(hopType);
            } else {
                hopType.setHopTypeId(Integer.parseInt(hopTypeId));
                hopType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateHopTypeEntity(hopType);
            }
        }

        request.setAttribute("hopTypes", dao.getAllHopTypes());
        response.sendRedirect(url);

    }

}
