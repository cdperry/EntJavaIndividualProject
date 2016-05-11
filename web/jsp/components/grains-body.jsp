<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Origin</th>
                <th>Type</th>
                <th>Color (SRM)</th>
                <th>Potential (SG)</th>
                <th>Last Updated</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${grainIngredients}" var="grain">
                <tr>
                    <td><c:out value="${grain.name}" /></td>
                    <td><c:out value="${grain.origin.name}" /></td>
                    <td><c:out value="${grain.grainType.name}" /></td>
                    <td><c:out value="${grain.color}" /></td>
                    <td><c:out value="${grain.potential}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grain.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editGrain?action=edit&componentId=<c:out value="${grain.compGrainId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${grain.compGrainId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p><a href="addGrain?action=insert">Add Grain</a></p>

    </div>

</div>
