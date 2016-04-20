<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Your META here -->
        <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0" name="viewport">

        <!-- Stylesheets -->
        <link rel="stylesheet" href="../../css/jforms/demo.css">
        <link rel="stylesheet" href="../../css/jforms/font-awesome.min.css">
        <link rel="stylesheet" href="../../css/jforms/j-forms.css">

        <!-- Scripts -->
        <script src="../../js/jquery/jquery.1.11.1.min.js"></script>
        <script src="../../js/jforms/j-forms-modal.js"></script>

        <title>Show Grain Types</title>
    </head>
    <body>
        <table border=1>
            <thead>
            <tr>
                <th>Grain Type ID</th>
                <th>Grain Type Name</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${grainTypes}" var="grainType">
                <tr>
                    <td><c:out value="${grainType.grainTypeId}" /></td>
                    <td><c:out value="${grainType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.updateDate}" /></td>
                    <td><a href="/grainTypeController?action=edit&grainTypeId=<c:out value="${grainType.grainTypeId}"/>" class="modal-link modal-open">Update</a></td>
                    <td><a href="/grainTypeController?action=delete&grainTypeId=<c:out value="${grainType.grainTypeId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="/grainTypeController?action=insert">Add Grain Type</a></p>
    </body>
</html>