package com.cdperry.brewday.controller.types.YeastType;

import com.cdperry.brewday.entity.YeastTypeEntity;
import com.cdperry.brewday.persistence.YeastTypeDao;

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
 *  This servlet is used to perform yeast type modifications and then show the user all of the
 *  current yeast types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastTypeAddEditActionServlet",
        urlPatterns = { "/doEditYeastType" }
)
public class YeastTypeAddEditActionServlet extends HttpServlet {

    private YeastTypeDao dao;

    public YeastTypeAddEditActionServlet() {
        super();
        dao = new YeastTypeDao();
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

        YeastTypeEntity yeastType = new YeastTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listYeastTypes";

        String name = request.getParameter("name");
        String yeastTypeId = request.getParameter("yeastTypeId");
        String buttonAction = request.getParameter("buttonAction");

        yeastType.setName(name);
        yeastType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (yeastTypeId == null || yeastTypeId.isEmpty()) {
                yeastType.setCreateDate(ts);
                dao.addYeastTypeEntity(yeastType);
            } else {
                yeastType.setYeastTypeId(Integer.parseInt(yeastTypeId));
                yeastType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateYeastTypeEntity(yeastType);
            }
        }

        request.setAttribute("yeastTypes", dao.getAllYeastTypes());
        response.sendRedirect(url);

    }

}
