<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <p></p>
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
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="recipeName" name="recipeName"
                           value="<c:out value="${recipe.recipeName}" />" />
                </div>
                <label for="recipeTypeId" class="col-sm-2 control-label">Recipe Type</label>
                <div class="col-sm-4">
                    <select class="form-control" id="recipeTypeId" name="recipeTypeId">
                        <c:forEach items="${recipeTypes}" var="recipeType">
                            <option value="${recipeType.recipeTypeId}"
                                    ${recipeType.recipeTypeId == recipe.recipeType.recipeTypeId ? 'selected' : ''}>
                                <c:out value="${recipeType.name}" />
                            </option>
                        </c:forEach>
                    </select>
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

                <label for="equipmentProfileId" class="col-sm-2 control-label">Equipment</label>
                <div class="col-sm-4">
                    <select class="form-control" id="equipmentProfileId" name="equipmentProfileId">
                        <c:forEach items="${equipmentProfiles}" var="equipmentProfile">
                            <option value="${equipmentProfile.profileEquipmentId}"
                                ${equipmentProfile.profileEquipmentId == recipe.profileEquipment.profileEquipmentId ? 'selected' : ''}>
                                <c:out value="${equipmentProfile.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <label for="batchSize" class="col-sm-2 control-label">Batch Size</label>
                <div class="col-sm-2">
                    <input type="number" class="form-control" id="batchSize" name="batchSize"
                           value="<c:out value="${recipe.batchSize}" />" />
                </div>

                <div class="col-sm-2">
                    <select class="form-control" id="batchSizeUomId" name="batchSizeUomId">
                        <c:forEach items="${uomTypes}" var="uomType">
                            <option value="${uomType.uomId}"
                                ${uomType.uomId == recipe.batchSizeUom.uomId ? 'selected' : ''}>
                                <c:out value="${uomType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <div class="form-group">
                <label for="createDate" class="col-sm-2 control-label">Create Date</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${recipe.createDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="updateDate" class="col-sm-2 control-label">Update Date</label>
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
                            value="cancel">Cancel</button>
                    <button type="submit" class="btn btn-primary" name="buttonAction"
                            value="submit">${buttonText}</button>
                </div>
            </div>
        </form>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Amount</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${recipeComponents}" var="recipeComponent">
                <tr>
                    <td><c:out value="${recipeComponent.amount}" /></td>
                    <td class="text-center">
                        <a href="/editRecipeComponent?action=edit&recipeComponentId=
                                <c:out value="${recipeComponent.componentId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${recipeComponent.componentId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div>
