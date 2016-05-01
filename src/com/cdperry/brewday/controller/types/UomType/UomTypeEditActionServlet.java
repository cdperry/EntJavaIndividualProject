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
 *  This servlet is used to perform UOM type modifications and then show the user all of the
 *  current UOM types
 *  </p>
 *  @author Chris Perry
 */
@WebServlet(
        name = "UomTypeEditActionServlet",
        urlPatterns = { "/doEditUomType" }
)
public class UomTypeEditActionServlet extends HttpServlet {

    private UomTypeDao dao;

    public UomTypeEditActionServlet() {
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
        String uomTypeId = request.getParameter("uomTypeId");
        String buttonAction = request.getParameter("buttonAction");

        if (buttonAction.equals("submit")) {
            if (uomTypeId == null || uomTypeId.isEmpty()) {
                uomType.setName(name);
                uomType.setUpdateDate(ts);
                uomType.setCreateDate(ts);
                dao.addUomTypeEntity(uomType);
            } else {
                uomType.setUomId(Integer.parseInt(uomTypeId));
                uomType.setName(name);
                uomType.setCreateDate(Timestamp.valueOf(request.getParameter("createDate")));
                uomType.setUpdateDate(ts);
                dao.updateUomTypeEntity(uomType);
            }
        }

        request.setAttribute("uomTypes", dao.getAllUomTypes());
        response.sendRedirect(url);

    }

}
