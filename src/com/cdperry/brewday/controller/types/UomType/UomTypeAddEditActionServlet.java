package com.cdperry.brewday.controller.types.UomType;

import com.cdperry.brewday.entity.UomTypeEntity;
import com.cdperry.brewday.persistence.UomTypeDao;

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
 *  This servlet is used to perform uom type modifications and then show the user all of the
 *  current uom types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UomTypeAddEditActionServlet",
        urlPatterns = { "/doEditUomType" }
)
public class UomTypeAddEditActionServlet extends HttpServlet {

    private UomTypeDao dao;

    public UomTypeAddEditActionServlet() {
        super();
        dao = new UomTypeDao();
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

        UomTypeEntity uomType = new UomTypeEntity();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        String url = "/listUomTypes";

        String name = request.getParameter("name");
        String uomId = request.getParameter("uomId");
        String buttonAction = request.getParameter("buttonAction");

        uomType.setName(name);
        uomType.setUpdateDate(ts);

        if (buttonAction.equals("submit")) {
            if (uomId == null || uomId.isEmpty()) {
                uomType.setCreateDate(ts);
                dao.addUomTypeEntity(uomType);
            } else {
                uomType.setUomId(Integer.parseInt(uomId));
                uomType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                dao.updateUomTypeEntity(uomType);
            }
        }

        request.setAttribute("uomTypes", dao.getAllUomTypes());
        response.sendRedirect(url);

    }

}
