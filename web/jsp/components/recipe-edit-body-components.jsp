<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <table id="recipeComponents" class="table table-hover dt-responsive nowrap">
            <thead>
            <tr>
                <th>Type</th>
                <th>Name</th>
                <th>Amount</th>
                <th>Amount UOM</th>
                <th>Time</th>
                <th>Time UOM</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${recipeComponents}" var="recipeComponent">
                <tr>
                    <td>${recipeComponent.component.componentType.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${recipeComponent.component.componentType.name == 'Grain'}">
                                <c:out value="${recipeComponent.component.componentGrain.name}" />
                            </c:when>
                            <c:when test="${recipeComponent.component.componentType.name == 'Hop'}">
                                <c:out value="${recipeComponent.component.componentHop.name}" />
                            </c:when>
                            <c:when test="${recipeComponent.component.componentType.name == 'Yeast'}">
                                <c:out value="${recipeComponent.component.componentYeast.name}" />
                            </c:when>
                            <c:when test="${recipeComponent.component.componentType.name == 'Water'}">
                                <c:out value="${recipeComponent.component.componentWater.name}" />
                            </c:when>
                            <c:when test="${recipeComponent.component.componentType.name == 'Other'}">
                                <c:out value="${recipeComponent.component.componentOther.name}" />
                            </c:when>
                            <c:otherwise>Unknown</c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${recipeComponent.amount}" /></td>
                    <td><c:out value="${recipeComponent.amountUom.name}" /></td>
                    <td><c:out value="${recipeComponent.time}" /></td>
                    <td><c:out value="${recipeComponent.timeUom.name}" /></td>
                    <%--
                    <td class="text-center">
                        <a href="/editRecipeComponent?action=edit&recipeId=
                                    <c:out value="${recipe.recipeId}"/>
                                    &recipeComponentId=
                                    <c:out value="${recipeComponent.component.componentId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    --%>
                    <td class="text-center">
                        <a href="#" data-recipeid="<c:out value="${recipe.recipeId}"/>"
                           data-recipecomponentid="<c:out value="${recipeComponent.recipeComponentId}"/>"
                           data-amount="<c:out value="${recipeComponent.amount}"/>"
                           data-amountuomid="<c:out value="${recipeComponent.amountUom.uomId}"/>"
                           data-time="<c:out value="${recipeComponent.time}"/>"
                           data-timeuomid="<c:out value="${recipeComponent.timeUom.uomId}"/>"
                           data-componenttypename="<c:out value="${recipeComponent.component.componentType.name}"/>"
                           data-toggle="modal" data-target="#editRecipeComponentModal">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-recipeid="<c:out value="${recipe.recipeId}"/>"
                           data-recipecomponentid="<c:out value="${recipeComponent.recipeComponentId}"/>"
                           data-toggle="modal" data-target="#deleteRecipeComponentModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div>