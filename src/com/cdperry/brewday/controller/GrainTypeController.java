package com.cdperry.brewday.controller;

import java.io.*;
import java.util.*;
import java.sql.Timestamp;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.hibernate.HibernateException;

import com.cdperry.brewday.entity.GrainTypeEntity;
import com.cdperry.brewday.persistence.GrainTypeDao;

/**
 *  <p>
 *  This servlet is used to process a request to add an employee to the
 *  database.  After the add action is performed it redirects the user back
 *  to the Add Employee page.
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "GrainTypeController",
        urlPatterns = { "/grainTypeController" }
)
public class GrainTypeController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/pages/modifyGrainType_alt.jsp";
    private static String LIST_ENTRIES = "/pages/listGrainType.jsp";
    private GrainTypeDao dao;

    public GrainTypeController() {
        super();
        dao = new GrainTypeDao();
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));
            dao.deleteGrainTypeEntityById(grainTypeId);
            forward = LIST_ENTRIES;
            request.setAttribute("grainTypes", dao.getAllGrainTypes());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));
            GrainTypeEntity grainType = dao.getGrainTypeEntity(grainTypeId);
            request.setAttribute("grainType", grainType);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST_ENTRIES;
            request.setAttribute("grainTypes", dao.getAllGrainTypes());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

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

        String name = request.getParameter("name");
        String grainTypeId = request.getParameter("grainTypeId");

        if (grainTypeId == null || grainTypeId.isEmpty()) {
            grainType.setName(name);
            grainType.setUpdateDate(ts);
            grainType.setCreateDate(ts);
            dao.addGrainTypeEntity(grainType);
        } else {
            grainType.setGrainTypeId(Integer.parseInt(grainTypeId));
            grainType.setName(name);
            grainType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
            grainType.setUpdateDate(ts);
            dao.updateGrainTypeEntity(grainType);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_ENTRIES);
        request.setAttribute("grainTypes", dao.getAllGrainTypes());
        view.forward(request, response);

    }

}



