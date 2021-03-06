<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table id="example" class="table table-hover">
            <thead>
            <tr>
                <th>Water</th>
                <th>pH</th>
                <th>Last Updated</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${waterIngredients}" var="water">
                <tr>
                    <td><c:out value="${water.name}" /></td>
                    <td><c:out value="${water.ph}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${water.updateDate}" /></td>
                    <td class="text-center">
                        <a href="editWater?action=edit&componentId=<c:out value="${water.compWaterId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${water.compWaterId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p><a href="addWater?action=insert">Add Water</a></p>

    </div>

</div>
