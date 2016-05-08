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
            <div class="form-group form-group-sm">
                <label for="recipeName" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="recipeName" name="recipeName"
                           value="<c:out value="${recipe.recipeName}" />" />
                </div>
                <label for="recipeId" class="col-sm-1 control-label">ID</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" readonly="readonly" id="recipeId"
                           name="recipeId"
                           value="<c:out value="${recipe.recipeId}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
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
            <div class="form-group form-group-sm">
                <label for="brewerName" class="col-sm-2 control-label">Brewer Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="brewerName" name="brewerName"
                           value="<c:out value="${recipe.brewerName}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">

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

            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${recipe.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${recipe.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
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
    </div>
</div>

<div class="row">

    <div class="col-lg-10">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Amount</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${recipeComponents}" var="recipeComponent">
                <tr>
                    <td><c:out value="${recipeComponent.component.componentId}" /></td>
                    <td><c:out value="${recipeComponent.amount}" /></td>
                    <td class="text-center">
                        <a href="/editRecipeComponent?action=edit&recipeId=
                                <c:out value="${recipe.recipeId}"/>
                                &recipeComponentId=
                                <c:out value="${recipeComponent.component.componentId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${recipeComponent.component.componentId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div class="col-lg-2">

        <div class="btn-group-vertical" role="group">
            <%--<button type="button" class="btn btn-default"><a href="/editRecipeAddGrain?action=insert&recipeId=
                                <c:out value="${recipe.recipeId}"/>">Add Grain</a></button>--%>
            <button type="button" class="btn btn-default">
                <a href="#" data-id="<c:out value="${recipe.recipeId}"/>"
                   data-toggle="modal" data-target="#modalAddGrain">Add Grain</a>
            </button>
            <button type="button" class="btn btn-default"><a href="/editRecipeAddHop">Add Hops</a></button>
            <button type="button" class="btn btn-default"><a href="/editRecipeAddMisc">Add Misc</a></button>
            <button type="button" class="btn btn-default"><a href="/editRecipeAddYeast">Add Yeast</a></button>
            <button type="button" class="btn btn-default"><a href="/editRecipeAddWater">Add Water</a></button>
        </div>

    </div>

</div>

<div class="row">
    <div class="col-lg-12">
        <div class="modal fade" id="modalAddGrain" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Add Grain</h4>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Origin</th>
                                <th>Type</th>
                                <th>Color</th>
                                <th>Potential</th>
                            </tr>
                        </thead>
                        <tbody>
                            <div class="modal-body">
                                <c:forEach items="${grains}" var="grain">
                                    <tr>
                                        <td><c:out value="${grain.componentGrain.name}" /></td>
                                        <td><c:out value="${grain.componentGrain.origin.name}" /></td>
                                        <td><c:out value="${grain.componentGrain.grainType.name}" /></td>
                                        <td><c:out value="${grain.componentGrain.color}" /></td>
                                        <td><c:out value="${grain.componentGrain.potential}" /></td>
                                    </tr>
                                </c:forEach>
                            </div>
                        </tbody>
                    </table>
                    <div class="modal-footer">
                        <form class="form-horizontal" id="frmAddGrain" method="POST" action='#' name="frmAddGrain">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary" name="buttonAction"
                                    value="submit">Add</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
