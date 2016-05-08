<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12"></div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditGrain' name="frmAddGrain">
            <div class="form-group form-group-sm">
                <label for="name" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value="${grain.name}" />" />
                </div>
                <label for="componentId" class="col-sm-1 control-label">ID</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" readonly="readonly" id="componentId"
                           name="componentId"
                           value="<c:out value="${component.componentId}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="originId" class="col-sm-1 control-label">Origin</label>
                <div class="col-sm-2">
                    <select class="form-control" id="originId" name="originId">
                        <c:forEach items="${origins}" var="origin">
                            <option value="${origin.originId}"
                                ${grain.origin.originId == origin.originId ? 'selected' : ''}>
                                <c:out value="${origin.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <label for="supplierId" class="col-sm-1 control-label">Supplier</label>
                <div class="col-sm-4">
                    <select class="form-control" id="supplierId" name="supplierId">
                        <c:forEach items="${suppliers}" var="supplier">
                            <option value="${supplier.supplierId}"
                                ${grain.supplier.supplierId == supplier.supplierId ? 'selected' : ''}>
                                <c:out value="${supplier.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="grainTypeId" class="col-sm-1 control-label">Type</label>
                <div class="col-sm-4">
                    <select class="form-control" id="grainTypeId" name="grainTypeId">
                        <c:forEach items="${grainTypes}" var="grainType">
                            <option value="${grainType.grainTypeId}"
                                ${grain.grainType.grainTypeId == grainType.grainTypeId ? 'selected' : ''}>
                                <c:out value="${grainType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="color" class="col-sm-2 control-label">Color (SRM)</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="color" name="color"
                           value="<c:out value="${grain.color}" />" />
                </div>
                <label for="potential" class="col-sm-2 control-label">Potential (SG)</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="potential" name="potential"
                           value="<c:out value="${grain.potential}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="notes" class="col-sm-1 control-label">Notes</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="notes" name="notes"
                           value="<c:out value="${grain.notes}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${grain.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${grain.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Grain"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Grain"/>
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
