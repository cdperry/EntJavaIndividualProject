<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <div class="modal fade" id="editRecipeComponentModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Edit Component</h4>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to edit this ingredient?  This action is irreversible.
                    </div>
                    <form class="form-inline" id="frmEditComponent" method="POST" action='#' name="frmEditComponent">
                        <div class="form-group">
                            <label class="sr-only" for="amount">Amount</label>
                            <input type="number" class="form-control" id="newAmount" name="newAmount" value="" />
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
                                    value="submit">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>