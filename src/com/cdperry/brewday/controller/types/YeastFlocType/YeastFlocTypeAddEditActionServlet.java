package com.cdperry.brewday.controller.types.YeastFlocType;

import com.cdperry.brewday.entity.YeastFlocTypeEntity;
import com.cdperry.brewday.persistence.YeastFlocTypeDao;

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
 *  This servlet is used to perform yeastFloc type modifications and then show the user all of the
 *  current yeastFloc types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "YeastFlocTypeAddEditActionServlet",
        urlPatterns = { "/doEditYeastFlocType" }
)
public class YeastFlocTypeAddEditActionServlet extends HttpServlet {

    private YeastFlocTypeDao dao;

    public YeastFlocTypeAddEditActionServlet() {
        super();
        dao = new YeastFlocTypeDao();
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

        YeastFlocTypeEntity yeastFlocType = new YeastFlocTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "listYeastFlocTypes";

        String name = request.getParameter("name");
        String yeastFlocTypeId = request.getParameter("yeastFlocTypeId");
        String buttonAction = request.getParameter("buttonAction");

        yeastFlocType.setName(name);
        yeastFlocType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (yeastFlocTypeId == null || yeastFlocTypeId.isEmpty()) {
                yeastFlocType.setCreateDate(ts);
                dao.addYeastFlocTypeEntity(yeastFlocType);
            } else {
                yeastFlocType.setYeastFlocTypeId(Integer.parseInt(yeastFlocTypeId));
                yeastFlocType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateYeastFlocTypeEntity(yeastFlocType);
            }
        }

        request.setAttribute("yeastFlocTypes", dao.getAllYeastFlocTypes());
        response.sendRedirect(url);

    }

}
