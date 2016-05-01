<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Add/Edit Recipe</h1>
    </div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditRecipe' name="frmAddEditRecipe">
            <div class="form-group">
                <label for="recipeId" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="recipeId"
                           name="recipeId"
                           value="<c:out value="${recipe.recipeId}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="recipeName" class="col-sm-2 control-label">Recipe Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="recipeName" name="recipeName"
                           value="<c:out value="${recipe.recipeName}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="brewerName" class="col-sm-2 control-label">Brewer Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="brewerName" name="brewerName"
                           value="<c:out value="${recipe.brewerName}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="createDate" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${recipe.createDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="updateDate" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${recipe.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Recipe"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Recipe"/>
                        </c:otherwise>
                    </c:choose>
                    <%--<button type="submit" class="btn btn-default" name="button">${buttonText}</button>--%>
                    <button type="submit" class="btn btn-default" name="buttonAction"
                            value="submit">${buttonText}</button>
                    <button type="submit" class="btn btn-default" name="buttonAction"
                            value="cancel">Cancel</button>
                </div>
            </div>
        </form>

    </div>

</div>
