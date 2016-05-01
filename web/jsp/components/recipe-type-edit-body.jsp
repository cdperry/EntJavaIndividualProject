<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Add/Edit Recipe Type</h1>
    </div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditRecipeType' name="frmAddRecipeType">
            <div class="form-group">
                <label for="recipeTypeId" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="recipeTypeId"
                           name="recipeTypeId"
                           value="<c:out value="${recipeType.recipeTypeId}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value="${recipeType.name}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="createDate" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${recipeType.createDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="updateDate" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${recipeType.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Recipe Type"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Recipe Type"/>
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
