<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Recipes</h1>
    </div>
</div>
--%>
<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Recipe Name</th>
                <th>Batch Size</th>
                <th>Last Updated</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${recipes}" var="recipe">
                <tr>
                    <td><c:out value="${recipe.recipeName}" /></td>
                    <td><c:out value="${recipe.batchSize}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${recipe.updateDate}" /></td>
                    <td class="text-center">
                        <a href="/editRecipe?action=edit&recipeId=<c:out value="${recipe.recipeId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${recipe.recipeId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p><a href="/addRecipe?action=insert">Add Recipe</a></p>

    </div>

</div>
