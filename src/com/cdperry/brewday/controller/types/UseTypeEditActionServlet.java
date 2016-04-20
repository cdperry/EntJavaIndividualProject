package com.cdperry.brewday.controller.types;

import com.cdperry.brewday.entity.UseTypeEntity;
import com.cdperry.brewday.persistence.UseTypeDao;

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
 *  This servlet is used to perform use type modifications and then show the user all of the
 *  current use types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UseTypeEditActionServlet",
        urlPatterns = { "/doEditUseType" }
)
public class UseTypeEditActionServlet extends HttpServlet {

    private UseTypeDao dao;

    public UseTypeEditActionServlet() {
        super();
        dao = new UseTypeDao();
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

        UseTypeEntity useType = new UseTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listUseTypes";

        String name = request.getParameter("name");
        String useTypeId = request.getParameter("useTypeId");
        String buttonAction = request.getParameter("buttonAction");

        if (buttonAction.equals("submit")) {
            if (useTypeId == null || useTypeId.isEmpty()) {
                useType.setName(name);
                useType.setUpdateDate(ts);
                useType.setCreateDate(ts);
                dao.addUseTypeEntity(useType);
            } else {
                useType.setUseTypeId(Integer.parseInt(useTypeId));
                useType.setName(name);
                useType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                useType.setUpdateDate(ts);
                dao.updateUseTypeEntity(useType);
            }
        }

        request.setAttribute("useTypes", dao.getAllUseTypes());
        response.sendRedirect(url);

    }

}
