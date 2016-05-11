<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12"></div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='doEditHop' name="frmAddHop">
            <div class="form-group form-group-sm">
                <label for="name" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value="${hop.name}" />" />
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
                                ${hop.origin.originId == origin.originId ? 'selected' : ''}>
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
                                ${hop.supplier.supplierId == supplier.supplierId ? 'selected' : ''}>
                                <c:out value="${supplier.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="hopFormTypeId" class="col-sm-1 control-label">Form</label>
                <div class="col-sm-2">
                    <select class="form-control" id="hopFormTypeId" name="hopFormTypeId">
                        <c:forEach items="${hopForms}" var="hopForm">
                            <option value="${hopForm.hopFormTypeId}"
                                ${hop.hopForm.hopFormTypeId == hopForm.hopFormTypeId ? 'selected' : ''}>
                                <c:out value="${hopForm.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <label for="hopTypeId" class="col-sm-1 control-label">Type</label>
                <div class="col-sm-4">
                    <select class="form-control" id="hopTypeId" name="hopTypeId">
                        <c:forEach items="${hopTypes}" var="hopType">
                            <option value="${hopType.hopTypeId}"
                                ${hop.hopType.hopTypeId == hopType.hopTypeId ? 'selected' : ''}>
                                <c:out value="${hopType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="alphaPct" class="col-sm-1 control-label">Alpha %</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="alphaPct" name="alphaPct"
                           value="<c:out value="${hop.alphaPct}" />" />
                </div>
                <label for="betaPct" class="col-sm-1 control-label">Beta %</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" id="betaPct" name="betaPct"
                           value="<c:out value="${hop.betaPct}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="notes" class="col-sm-1 control-label">Notes</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="notes" name="notes"
                           value="<c:out value="${hop.notes}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${hop.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${hop.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Hop"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Hop"/>
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
