<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12"></div>
</div>

<div class="row">

    <div class="col-lg-12">

        <form class="form-horizontal" method="POST" action='/doEditWater' name="frmAddWater">
            <div class="form-group form-group-sm">
                <label for="name" class="col-sm-1 control-label">Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="name" name="name"
                           value="<c:out value="${water.name}" />" />
                </div>
                <label for="componentId" class="col-sm-1 control-label">ID</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" readonly="readonly" id="componentId"
                           name="componentId"
                           value="<c:out value="${component.componentId}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="ph" class="col-sm-1 control-label">pH</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="ph" name="ph"
                           value="<c:out value="${water.ph}" />" />
                </div>
            </div>
            <div class="col-sm-11">Mineral Profile (ppm)</div>
            <div class="form-group form-group-sm">
                <label for="caPpm" class="col-sm-2 control-label">Calcium (Ca)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="caPpm" name="caPpm"
                           value="<c:out value="${water.caPpm}" />" />
                </div>
                <label for="mgPpm" class="col-sm-2 control-label">Magnesium (Mg)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="mgPpm" name="mgPpm"
                           value="<c:out value="${water.mgPpm}" />" />
                </div>
                <label for="naPpm" class="col-sm-2 control-label">Sodium (Na)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="naPpm" name="naPpm"
                           value="<c:out value="${water.naPpm}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="so4Ppm" class="col-sm-2 control-label">Sulfate (SO4)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="so4Ppm" name="so4Ppm"
                           value="<c:out value="${water.so4Ppm}" />" />
                </div>
                <label for="clPpm" class="col-sm-2 control-label">Chloride (Cl)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="clPpm" name="clPpm"
                           value="<c:out value="${water.clPpm}" />" />
                </div>
                <label for="hco3Ppm" class="col-sm-2 control-label">Bicarbonate (HCO3)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="hco3Ppm" name="hco3Ppm"
                           value="<c:out value="${water.hco3Ppm}" />" />
                </div>
            </div>
            <div class="col-sm-12">Additions (weights in grams) to achieve this water</div>
            <div class="form-group form-group-sm">
                <label for="caso4G" class="col-sm-2 control-label">Gypsum (CaSO4)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="caso4G" name="caso4G"
                           value="<c:out value="${water.caso4G}" />" />
                </div>
                <label for="naclG" class="col-sm-2 control-label">Table Salt (NaCl)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="naclG" name="naclG"
                           value="<c:out value="${water.naclG}" />" />
                </div>
                <label for="mgso4G" class="col-sm-2 control-label">Epsom Salt (MgSO4)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="mgso4G" name="mgso4G"
                           value="<c:out value="${water.mgso4G}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="caclG" class="col-sm-2 control-label">Calcium Chloride (CaCl)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="caclG" name="caclG"
                           value="<c:out value="${water.caclG}" />" />
                </div>
                <label for="nahco3G" class="col-sm-2 control-label">Baking Soda (NaHCO3)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="nahco3G" name="nahco3G"
                           value="<c:out value="${water.nahco3G}" />" />
                </div>
                <label for="caco3G" class="col-sm-2 control-label">Chalk (CaCO3)</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="caco3G" name="caco3G"
                           value="<c:out value="${water.caco3G}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="batchSize" class="col-sm-2 control-label">For Batch Volume</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="batchSize" name="batchSize"
                           value="<c:out value="${water.batchSize}" />" />
                </div>
                <div class="col-sm-2">
                    <select class="form-control" id="batchSizeUomId" name="batchSizeUomId">
                        <c:forEach items="${batchSizeUomTypes}" var="batchSizeUom">
                            <option value="${batchSizeUom.uomId}"
                                ${water.batchSizeUom.uomId == batchSizeUom.uomId ? 'selected' : ''}>
                                <c:out value="${batchSizeUom.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="notes" class="col-sm-1 control-label">Notes</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="notes" name="notes"
                           value="<c:out value="${water.notes}" />" />
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label for="createDate" class="col-sm-1 control-label">Created</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                           name="createDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${water.createDate}" />" />
                </div>
                <label for="updateDate" class="col-sm-1 control-label">Updated</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                           name="updateDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${water.updateDate}" />" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
                    <c:choose>
                        <c:when test="${actionType == 'edit'}">
                            <c:set var="buttonText" scope="request" value="Update Water"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonText" scope="request" value="Add Water"/>
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
