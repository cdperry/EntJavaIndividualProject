<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Hop Form Types</h1>
    </div>
</div>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th>Hop Form Type ID</th>--%>
                <th>Hop Form Type Name</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hopFormTypes}" var="hopFormType">
                <tr>
                        <%--<td><c:out value="${hopFormType.hopFormTypeId}" /></td>--%>
                    <td><c:out value="${hopFormType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${hopFormType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${hopFormType.updateDate}" /></td>
                    <td class="text-center">
                        <a href="/editHopFormType?action=edit&hopFormTypeId=<c:out value="${hopFormType.hopFormTypeId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${hopFormType.hopFormTypeId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="/addHopFormType?action=insert">Add Hop Form Type</a></p>
    </div>

</div>