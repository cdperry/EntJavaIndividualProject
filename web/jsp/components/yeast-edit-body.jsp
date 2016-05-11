<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12"></div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='doEditYeast' name="frmAddYeast">
            <div class="form-group form-group-sm">
                <label for="name" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value="${yeast.name}" />" />
                </div>
                <label for="componentId" class="col-sm-1 control-label">ID</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" readonly="readonly" id="componentId"
                           name="componentId"
                           value="<c:out value="${component.componentId}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="laboratoryId" class="col-sm-1 control-label">Lab</label>
                <div class="col-sm-2">
                    <select class="form-control" id="laboratoryId" name="laboratoryId">
                        <c:forEach items="${laboratories}" var="laboratory">
                            <option value="${laboratory.supplierId}"
                                ${yeast.lab.supplierId == laboratory.supplierId ? 'selected' : ''}>
                                <c:out value="${laboratory.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <label for="supplierId" class="col-sm-1 control-label">Supplier</label>
                <div class="col-sm-4">
                    <select class="form-control" id="supplierId" name="supplierId">
                        <c:forEach items="${suppliers}" var="supplier">
                            <option value="${supplier.supplierId}"
                                ${yeast.supplier.supplierId == supplier.supplierId ? 'selected' : ''}>
                                <c:out value="${supplier.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="yeastTypeId" class="col-sm-1 control-label">Type</label>
                <div class="col-sm-2">
                    <select class="form-control" id="yeastTypeId" name="yeastTypeId">
                        <c:forEach items="${yeastTypes}" var="yeastType">
                            <option value="${yeastType.yeastTypeId}"
                                ${yeast.yeastType.yeastTypeId == yeastType.yeastTypeId ? 'selected' : ''}>
                                <c:out value="${yeastType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <label for="yeastFormId" class="col-sm-1 control-label">Form</label>
                <div class="col-sm-2">
                    <select class="form-control" id="yeastFormId" name="yeastFormId">
                        <c:forEach items="${yeastForms}" var="yeastForm">
                            <option value="${yeastForm.yeastFormId}"
                                ${yeast.yeastForm.yeastFormId == yeastForm.yeastFormId ? 'selected' : ''}>
                                <c:out value="${yeastForm.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <label for="yeastFlocTypeId" class="col-sm-2 control-label">Flocculation</label>
                <div class="col-sm-2">
                    <select class="form-control" id="yeastFlocTypeId" name="yeastFlocTypeId">
                        <c:forEach items="${yeastFlocTypes}" var="yeastFlocType">
                            <option value="${yeastFlocType.yeastFlocTypeId}"
                                ${yeast.yeastFlocType.yeastFlocTypeId == yeastFlocType.yeastFlocTypeId ? 'selected' : ''}>
                                <c:out value="${yeastFlocType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="attenuationMin" class="col-sm-3 control-label">Min Attenuation (%)</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="attenuationMin" name="attenuationMin"
                           value="<c:out value="${yeast.attenuationMin}" />" />
                </div>
                <label for="attenuationMax" class="col-sm-3 control-label">Max Attenuation (%)</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="attenuationMax" name="attenuationMax"
                           value="<c:out value="${yeast.attenuationMax}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="temperatureMin" class="col-sm-3 control-label">Min Temperature (F)</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="temperatureMin" name="temperatureMin"
                           value="<c:out value="${yeast.temperatureMin}" />" />
                </div>
                <label for="temperatureMax" class="col-sm-3 control-label">Max Temperature (F)</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="temperatureMax" name="temperatureMax"
                           value="<c:out value="${yeast.temperatureMax}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="cellsPerPack" class="col-sm-3 control-label">Cells per Pack (Billions)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="cellsPerPack" name="cellsPerPack"
                           value="<c:out value="${yeast.cellsPerPack}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
            </div>
            <div class="form-group form-group-sm">
                <label for="notes" class="col-sm-1 control-label">Notes</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="notes" name="notes"
                           value="<c:out value="${yeast.notes}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${yeast.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${yeast.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Yeast"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Yeast"/>
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
