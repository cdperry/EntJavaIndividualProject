<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th>YeastForm Type ID</th>--%>
                <th>Yeast Form</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${yeastFormTypes}" var="yeastFormType">
                <tr>
                    <%--<td><c:out value="${yeastFormType.yeastFormId}" /></td>--%>
                    <td><c:out value="${yeastFormType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${yeastFormType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${yeastFormType.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editYeastFormType?action=edit&yeastFormId=<c:out value="${yeastFormType.yeastFormId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${yeastFormType.yeastFormId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="addYeastFormType?action=insert">Add Yeast Form</a></p>
    </div>

</div>
