<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th>Yeast Type ID</th>--%>
                <th>Yeast Type</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${yeastTypes}" var="yeastType">
                <tr>
                        <%--<td><c:out value="${yeastType.yeastTypeId}" /></td>--%>
                    <td><c:out value="${yeastType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${yeastType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${yeastType.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editYeastType?action=edit&yeastTypeId=<c:out value="${yeastType.yeastTypeId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${yeastType.yeastTypeId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="addYeastType?action=insert">Add Yeast Type</a></p>
    </div>

</div>
