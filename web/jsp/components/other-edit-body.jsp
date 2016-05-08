<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12"></div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditOther' name="frmAddOther">
            <div class="form-group form-group-sm">
                <label for="name" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value="${other.name}" />" />
                </div>
                <label for="componentId" class="col-sm-1 control-label">ID</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" readonly="readonly" id="componentId"
                           name="componentId"
                           value="<c:out value="${component.componentId}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="useTypeId" class="col-sm-1 control-label">Type</label>
                <div class="col-sm-2">
                    <select class="form-control" id="useTypeId" name="useTypeId">
                        <c:forEach items="${useTypes}" var="useType">
                            <option value="${useType.useTypeId}"
                                ${other.useType.useTypeId == useType.useTypeId ? 'selected' : ''}>
                                <c:out value="${useType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <label for="useFor" class="col-sm-1 control-label">Use For</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="useFor" name="useFor"
                           value="<c:out value="${other.useFor}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="amount" class="col-sm-1 control-label">Amount</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="amount" name="amount"
                           value="<c:out value="${other.amount}" />" />
                </div>
                <div class="col-sm-2">
                    <select class="form-control" id="amountUomId" name="amountUomId">
                        <c:forEach items="${uomTypes}" var="uomType">
                            <option value="${uomType.uomId}"
                                ${other.amountUom.uomId == uomType.uomId ? 'selected' : ''}>
                                <c:out value="${uomType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="batchSize" class="col-sm-1 control-label">Batch Size</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="batchSize" name="batchSize"
                           value="<c:out value="${other.batchSize}" />" />
                </div>
                <div class="col-sm-2">
                    <select class="form-control" id="batchSizeUomId" name="batchSizeUomId">
                        <c:forEach items="${uomTypes}" var="uomType">
                            <option value="${uomType.uomId}"
                                ${other.batchSizeUom.uomId == uomType.uomId ? 'selected' : ''}>
                                <c:out value="${uomType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="time" class="col-sm-1 control-label">Time</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="time" name="time"
                           value="<c:out value="${other.time}" />" />
                </div>
                <div class="col-sm-2">
                    <select class="form-control" id="timeUomId" name="timeUomId">
                        <c:forEach items="${uomTypes}" var="uomType">
                            <option value="${uomType.uomId}"
                                ${other.timeUom.uomId == uomType.uomId ? 'selected' : ''}>
                                <c:out value="${uomType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="notes" class="col-sm-1 control-label">Notes</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="notes" name="notes"
                           value="<c:out value="${other.notes}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${other.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${other.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Other"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Other"/>
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
