package com.cdperry.brewday.controller;

import com.cdperry.brewday.entity.HopFormTypeEntity;
import com.cdperry.brewday.persistence.HopFormTypeDao;

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
 *  This servlet is used to perform hop form type modifications and then show the user all of the
 *  current grain types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "HopFormTypeEditActionServlet",
        urlPatterns = { "/doEditHopFormType" }
)
public class HopFormTypeEditActionServlet extends HttpServlet {

    private HopFormTypeDao dao;

    public HopFormTypeEditActionServlet() {
        super();
        dao = new HopFormTypeDao();
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

        HopFormTypeEntity hopFormType = new HopFormTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listHopFormTypes";

        String name = request.getParameter("name");
        String hopFormTypeId = request.getParameter("hopFormTypeId");
        String buttonAction = request.getParameter("buttonAction");

        if (buttonAction.equals("submit")) {
            if (hopFormTypeId == null || hopFormTypeId.isEmpty()) {
                hopFormType.setName(name);
                hopFormType.setUpdateDate(ts);
                hopFormType.setCreateDate(ts);
                dao.addHopFormTypeEntity(hopFormType);
            } else {
                hopFormType.setHopFormTypeId(Integer.parseInt(hopFormTypeId));
                hopFormType.setName(name);
                hopFormType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                hopFormType.setUpdateDate(ts);
                dao.updateHopFormTypeEntity(hopFormType);
            }
        }

        request.setAttribute("hopFormTypes", dao.getAllHopFormTypes());
        response.sendRedirect(url);

    }

}
