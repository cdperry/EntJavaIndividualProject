<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <div class="modal fade" id="modalAddGrain" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Add Grain</h4>
                    </div>
                    <div class="modal-body">
                        <table id="grainListTbl" class="table table-hover dt-responsive" width="100%">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Origin</th>
                                    <th>Type</th>
                                    <th>Color</th>
                                    <th>Potential</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${grains}" var="grain">
                                    <tr recipeId="<c:out value="${recipe.recipeId}"/>"
                                        compId="<c:out value="${grain.componentId}"/>">
                                        <td><c:out value="${grain.componentId}" /></td>
                                        <td><c:out value="${grain.componentGrain.name}" /></td>
                                        <td><c:out value="${grain.componentGrain.origin.name}" /></td>
                                        <td><c:out value="${grain.componentGrain.grainType.name}" /></td>
                                        <td><c:out value="${grain.componentGrain.color}" /></td>
                                        <td><c:out value="${grain.componentGrain.potential}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <form class="form-inline" id="frmAddGrain" method="POST" action='#' name="frmAddGrain">
                            <div class="form-group addGrain">
                                <label class="sr-only" for="amount">Amount</label>
                                <input type="number" class="form-control" id="amount" name="amount"/>
                                <select class="form-control" id="amountUomId" name="amountUomId">
                                    <c:forEach items="${componentUomTypes}" var="uomType">
                                        <option value="${uomType.uomId}"
                                            ${uomType.uomId == recipeComponent.amountUom.uomId ? 'selected' : ''}>
                                            <c:out value="${uomType.name}" />
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-primary" name="buttonAction"
                                        value="submit">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>