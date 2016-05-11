<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th>Supplier Type ID</th>--%>
                <th>Supplier Type</th>
                <th>Create Date</th>
                <th>Update Date</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${supplierTypes}" var="supplierType">
                <tr>
                    <%--<td><c:out value="${supplierType.supplierTypeId}" /></td>--%>
                    <td><c:out value="${supplierType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${supplierType.createDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${supplierType.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editSupplierType?action=edit&supplierTypeId=<c:out value="${supplierType.supplierTypeId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${supplierType.supplierTypeId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="addSupplierType?action=insert">Add Supplier Type</a></p>
    </div>

</div>
