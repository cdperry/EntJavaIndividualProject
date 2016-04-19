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

    private static String INSERT_OR_EDIT = "/pages/editGrainType.jsp";
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

        if (action == null || action.isEmpty()) {
            action = "list";
        }

        if (action.equalsIgnoreCase("delete")) {
            // when the delete finishes why doens't the URL show /grainTypeController?
            forward = LIST_ENTRIES;
            int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));
            dao.deleteGrainTypeEntityById(grainTypeId);
            request.setAttribute("grainTypes", dao.getAllGrainTypes());
            request.setAttribute("actionType", "delete");
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int grainTypeId = Integer.parseInt(request.getParameter("grainTypeId"));
            GrainTypeEntity grainType = dao.getGrainTypeEntity(grainTypeId);
            request.setAttribute("grainType", grainType);
            request.setAttribute("actionType", "edit");
        } else if (action.equalsIgnoreCase("insert")){
            forward = INSERT_OR_EDIT;
            request.setAttribute("actionType", "insert");
        } else {
            forward = LIST_ENTRIES;
            request.setAttribute("grainTypes", dao.getAllGrainTypes());
            request.setAttribute("actionType", "list");
        }

        // do a redirect for the deletes so that the URL doesn't screw things up on a page refresh?
        // what did I do in advanced java final project?
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
        String buttonAction = request.getParameter("buttonAction");

        if (buttonAction.equals("submit")) {
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
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_ENTRIES);
        request.setAttribute("grainTypes", dao.getAllGrainTypes());
        view.forward(request, response);

    }

}



