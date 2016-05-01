package com.cdperry.brewday.controller.types.GrainType;

import com.cdperry.brewday.entity.GrainTypeEntity;
import com.cdperry.brewday.persistence.GrainTypeDao;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  <p>
 *  This servlet is used to perform grain type modifications and then show the user all of the
 *  current grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "GrainTypeAddEditActionServlet",
        urlPatterns = { "/doEditGrainType" }
)
public class GrainTypeAddEditActionServlet extends HttpServlet {

    private GrainTypeDao dao;

    public GrainTypeAddEditActionServlet() {
        super();
        dao = new GrainTypeDao();
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

        GrainTypeEntity grainType = new GrainTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listGrainTypes";

        String name = request.getParameter("name");
        String grainTypeId = request.getParameter("grainTypeId");
        String buttonAction = request.getParameter("buttonAction");

        grainType.setName(name);
        grainType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (grainTypeId == null || grainTypeId.isEmpty()) {
                grainType.setCreateDate(ts);
                dao.addGrainTypeEntity(grainType);
            } else {
                grainType.setGrainTypeId(Integer.parseInt(grainTypeId));
                grainType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateGrainTypeEntity(grainType);
            }
        }

        request.setAttribute("grainTypes", dao.getAllGrainTypes());
        response.sendRedirect(url);

    }

}
