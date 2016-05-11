<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th>Component Type ID</th>--%>
                <th>Component Type</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${componentTypes}" var="componentType">
                <tr>
                    <%--<td><c:out value="${componentType.componentTypeId}" /></td>--%>
                    <td><c:out value="${componentType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${componentType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${componentType.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editComponentType?action=edit&componentTypeId=<c:out value="${componentType.componentTypeId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${componentType.componentTypeId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p class="text-danger"><c:out value="${errorMessage}"/></p>
        <c:remove var="errorMessage" scope="session"/>
        <p><a href="addComponentType?action=insert">Add Component Type</a></p>
    </div>

</div>
