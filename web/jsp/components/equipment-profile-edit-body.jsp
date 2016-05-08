<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditEquipmentProfile' name="frmAddEditEquipmentProfile">
            <div class="form-group form-group-sm">
                <label for="profileName" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="profileName" name="profileName"
                           value="<c:out value="${equipmentProfile.name}" />" />
                </div>
                <label for="equipmentProfileId" class="col-sm-1 control-label">ID</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" readonly="readonly" id="equipmentProfileId"
                           name="equipmentProfileId"
                           value="<c:out value="${equipmentProfile.profileEquipmentId}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="batchVol" class="col-sm-1 control-label">Batch Volume</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="batchVol" name="batchVol"
                           value="<c:out value="${equipmentProfile.fermBatchVol}" />" />
                </div>
                <div class="col-sm-2">
                    <%--
                    <select class="form-control" id="batchVolUomId" name="batchVolUomId">
                        <c:forEach items="${uomTypes}" var="uomType">
                            <option value="${uomType.uomId}"
                                ${equipmentProfile.batchVolUom.uomId == uomType.uomId ? 'selected' : ''}>
                                <c:out value="${uomType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                    --%>
                </div>

                <label for="boilVol" class="col-sm-1 control-label">Boil Volume</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="boilVol" name="boilVol"
                           value="<c:out value="${equipmentProfile.boilVol}" />" />
                </div>
                <div class="col-sm-2">
                    <%--
                    <select class="form-control" id="batchVolUomId" name="batchVolUomId">
                        <c:forEach items="${uomTypes}" var="uomType">
                            <option value="${uomType.uomId}"
                                ${equipmentProfile.batchVolUom.uomId == uomType.uomId ? 'selected' : ''}>
                                <c:out value="${uomType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                    --%>
                </div>

            </div>
            <div class="form-group form-group-sm">
                <label for="bottlingVol" class="col-sm-1 control-label">Bottling Volume</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="bottlingVol" name="bottlingVol"
                           value="<c:out value="${equipmentProfile.bottlingVol}" />" />
                </div>
                <div class="col-sm-2">
                    <%--
                    <select class="form-control" id="batchVolUomId" name="batchVolUomId">
                        <c:forEach items="${uomTypes}" var="uomType">
                            <option value="${uomType.uomId}"
                                ${equipmentProfile.batchVolUom.uomId == uomType.uomId ? 'selected' : ''}>
                                <c:out value="${uomType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                    --%>
                </div>

            </div>
            <div class="form-group form-group-sm">
                <label for="notes" class="col-sm-1 control-label">Notes</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="notes" name="notes"
                           value="<c:out value="${equipmentProfile.notes}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${equipmentProfile.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${equipmentProfile.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
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
