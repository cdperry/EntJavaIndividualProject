<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <div class="modal fade" id="modalAddHop" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Add Hop</h4>
                    </div>
                    <div class="modal-body">
                        <table id="hopListTbl" class="table table-hover dt-responsive" width="100%"">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Origin</th>
                                <th>Type</th>
                                <th>Alpha %</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${hops}" var="hop">
                                    <tr recipeId="<c:out value="${recipe.recipeId}"/>"
                                        compId="<c:out value="${hop.componentId}"/>">
                                        <td><c:out value="${hop.componentId}" /></td>
                                        <td><c:out value="${hop.componentHop.name}" /></td>
                                        <td><c:out value="${hop.componentHop.origin.name}" /></td>
                                        <td><c:out value="${hop.componentHop.hopType.name}" /></td>
                                        <td><c:out value="${hop.componentHop.alphaPct}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <form class="form-inline" id="frmAddHop" method="POST" action='#' name="frmAddHop">
                            <div class="form-group addHopAmt">
                                <label class="sr-only" for="amount">Amount</label>
                                <input type="number" class="form-control" id="amount" name="amount" placeholder="amount"/>
                                <select class="form-control" id="amountUomId" name="amountUomId">
                                    <c:forEach items="${componentUomTypes}" var="uomType">
                                        <option value="${uomType.uomId}">
                                            <c:out value="${uomType.name}" />
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group addHopTime">
                                <label class="sr-only" for="amount">Time</label>
                                <input type="number" class="form-control" id="time" name="time" placeholder="time"/>
                                <select class="form-control" id="timeUomId" name="timeUomId">
                                    <c:forEach items="${componentUomTypes}" var="uomType">
                                        <option value="${uomType.uomId}">
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
