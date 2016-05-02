<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditEquipmentProfile' name="frmAddEditEquipmentProfile">
            <div class="form-group">
                <label for="equipmentProfileId" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="equipmentProfileId"
                           name="equipmentProfileId"
                           value="<c:out value="${equipmentProfile.profileEquipmentId}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="profileName" class="col-sm-2 control-label">Profile Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="profileName" name="profileName"
                           value="<c:out value="${equipmentProfile.name}" />" />
                </div>
                <%--
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
                --%>
            </div>
            <div class="form-group">
                <label for="createDate" class="col-sm-2 control-label">Create Date</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${equipmentProfile.createDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="updateDate" class="col-sm-2 control-label">Update Date</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${equipmentProfile.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Profile"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Profile"/>
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
