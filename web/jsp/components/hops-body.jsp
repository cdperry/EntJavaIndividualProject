<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table id="example" class="table table-hover">

            <thead>
                <tr>
                    <th>Name</th>
                    <th>Origin</th>
                    <th>Alpha %</th>
                    <th>Type</th>
                    <th>Last Updated</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${hopIngredients}" var="hop">
                <tr>
                    <td><c:out value="${hop.name}" /></td>
                    <td><c:out value="${hop.origin.name}" /></td>
                    <td><c:out value="${hop.alphaPct}" /></td>
                    <td><c:out value="${hop.hopType.name}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${hop.updateDate}" /></td>
                    <td class="text-center">
                        <a href="/editHop?action=edit&componentId=<c:out value="${hop.compHopId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${hop.compHopId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <p><a href="/addHop?action=insert">Add Hop</a></p>

    </div>

</div>
