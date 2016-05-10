<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <div class="modal fade" id="modalAddOther" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Add Other Ingredient</h4>
                    </div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Use For</th>
                        </tr>
                        </thead>
                        <tbody>
                        <div class="modal-body">
                            <c:forEach items="${others}" var="other">
                                <tr recipeId="<c:out value="${recipe.recipeId}"/>"
                                    compId="<c:out value="${other.componentId}"/>">
                                    <td><c:out value="${other.componentId}" /></td>
                                    <td><c:out value="${other.componentOther.name}" /></td>
                                    <td><c:out value="${other.componentOther.useType.name}" /></td>
                                    <td><c:out value="${other.componentOther.useFor}" /></td>
                                </tr>
                            </c:forEach>
                        </div>
                        </tbody>
                    </table>
                    <div class="modal-footer">
                        <form class="form-horizontal" id="frmAddOther" method="POST" action='#' name="frmAddOther">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary" name="buttonAction"
                                    value="submit">Add</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>