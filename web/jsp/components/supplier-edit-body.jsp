<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12"></div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditSupplier' name="frmAddSupplier">
            <div class="form-group form-group-sm">
                <label for="name" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value="${supplier.name}" />" />
                </div>
                <label for="supplierId" class="col-sm-1 control-label">ID</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" readonly="readonly" id="supplierId"
                           name="supplierId"
                           value="<c:out value="${supplier.supplierId}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="supplierTypeId" class="col-sm-1 control-label">Type</label>
                <div class="col-sm-4">
                    <select class="form-control" id="supplierTypeId" name="supplierTypeId">
                        <c:forEach items="${supplierTypes}" var="supplierType">
                            <option value="${supplierType.supplierTypeId}"
                                ${supplier.supplierType.supplierTypeId == supplierType.supplierTypeId ? 'selected' : ''}>
                                <c:out value="${supplierType.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="url" class="col-sm-1 control-label">URL</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="url" name="url"
                           value="<c:out value="${supplier.url}" />" />
                </div>
                <label for="phone" class="col-sm-1 control-label">Phone</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="phone" name="phone"
                           value="<c:out value="${supplier.phone}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="contactName" class="col-sm-1 control-label">Contact Person</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="contactName" name="contactName"
                           value="<c:out value="${supplier.contactName}" />" />
                </div>
                <label for="email" class="col-sm-1 control-label">Email Address</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="email" name="email"
                           value="<c:out value="${supplier.email}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="notes" class="col-sm-1 control-label">Notes</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="notes" name="notes"
                           value="<c:out value="${supplier.notes}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${supplier.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${supplier.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Supplier"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Supplier"/>
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
