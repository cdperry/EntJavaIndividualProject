<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"
              href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Add New Grain Type</title>
    </head>
    <body>
        <script>
            $(function() {
                $('input[name=updateDate]').datepicker();
            });
        </script>

        <form method="POST" action='/grainTypeController' name="frmAddGrainType">
            ID : <input type="text" readonly="readonly" name="grainTypeId"
                             value="<c:out value="${grainType.grainTypeId}" />" /> <br />
            Name : <input
                type="text" name="name"
                value="<c:out value="${grainType.name}" />" /> <br />
            Create Date : <input
                type="text" readonly="readonly" name="createDate"
                value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.createDate}" />" /> <br />
            Update Date : <input
                type="text" readonly="readonly" name="updateDate"
                value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.updateDate}" />" /> <br />
            <input
                type="submit" value="Submit" />
        </form>
    </body>
</html>