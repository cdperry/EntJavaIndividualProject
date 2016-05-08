<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Lab</th>
                <th>Type</th>
                <th>Form</th>
                <th>Last Updated</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${yeastIngredients}" var="yeast">
                <tr>
                    <td><c:out value="${yeast.name}" /></td>
                    <td><c:out value="${yeast.lab.name}" /></td>
                    <td><c:out value="${yeast.yeastType.name}" /></td>
                    <td><c:out value="${yeast.yeastForm.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${yeast.updateDate}" /></td>
                    <td class="text-center">
                        <a href="/editYeast?action=edit&componentId=<c:out value="${yeast.compYeastId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${yeast.compYeastId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p><a href="/addYeast?action=insert">Add Yeast</a></p>

    </div>

</div>
