package com.cdperry.brewday.controller.types.YeastFormType;

import com.cdperry.brewday.entity.YeastFormEntity;
import com.cdperry.brewday.persistence.YeastFormDao;

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
        name = "YeastFormTypeAddEditActionServlet",
        urlPatterns = { "/doEditYeastFormType" }
)
public class YeastFormTypeAddEditActionServlet extends HttpServlet {

    private YeastFormDao dao;

    public YeastFormTypeAddEditActionServlet() {
        super();
        dao = new YeastFormDao();
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

        YeastFormEntity yeastForm = new YeastFormEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "listYeastFormTypes";

        String name = request.getParameter("name");
        String yeastFormId = request.getParameter("yeastFormId");
        String buttonAction = request.getParameter("buttonAction");

        yeastForm.setName(name);
        yeastForm.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (yeastFormId == null || yeastFormId.isEmpty()) {
                yeastForm.setCreateDate(ts);
                dao.addYeastFormEntity(yeastForm);
            } else {
                yeastForm.setYeastFormId(Integer.parseInt(yeastFormId));
                yeastForm.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateYeastFormEntity(yeastForm);
            }
        }

        request.setAttribute("yeastForms", dao.getAllYeastForms());
        response.sendRedirect(url);

    }

}
