<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table id="example" class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>URL</th>
                <th>Phone</th>
                <th>Last Updated</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${suppliers}" var="supplier">
                <tr>
                    <td><c:out value="${supplier.name}" /></td>
                    <td><c:out value="${supplier.url}" /></td>
                    <td><c:out value="${supplier.phone}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${supplier.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editSupplier?action=edit&supplierId=<c:out value="${supplier.supplierId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${supplier.supplierId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p><a href="editSupplier?action=insert">Add Supplier</a></p>

    </div>

</div>
