<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Hop Types</h1>
    </div>
</div>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th>Hop Type ID</th>--%>
                <th>Hop Type</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hopTypes}" var="hopType">
                <tr>
                    <%--<td><c:out value="${hopType.hopTypeId}" /></td>--%>
                    <td><c:out value="${hopType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${hopType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${hopType.updateDate}" /></td>
                    <td class="text-center">
                        <a href="/editHopType?action=edit&hopTypeId=<c:out value="${hopType.hopTypeId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${hopType.hopTypeId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="/addHopType?action=insert">Add Hop Type</a></p>
    </div>

</div>