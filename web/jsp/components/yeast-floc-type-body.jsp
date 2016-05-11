<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th>YeastFloc Type ID</th>--%>
                <th>Flocculation Type</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${yeastFlocTypes}" var="yeastFlocType">
                <tr>
                    <%--<td><c:out value="${yeastFlocType.yeastFlocTypeId}" /></td>--%>
                    <td><c:out value="${yeastFlocType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${yeastFlocType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${yeastFlocType.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editYeastFlocType?action=edit&yeastFlocTypeId=<c:out value="${yeastFlocType.yeastFlocTypeId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${yeastFlocType.yeastFlocTypeId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="addYeastFlocType?action=insert">Add Yeast Flocculation Type</a></p>
    </div>

</div>
