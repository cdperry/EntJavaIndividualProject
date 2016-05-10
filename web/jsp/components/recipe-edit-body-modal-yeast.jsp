<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <div class="modal fade" id="modalAddYeast" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Add Yeast</h4>
                    </div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Form</th>
                        </tr>
                        </thead>
                        <tbody>
                        <div class="modal-body">
                            <c:forEach items="${yeasts}" var="yeast">
                                <tr recipeId="<c:out value="${recipe.recipeId}"/>"
                                    compId="<c:out value="${yeast.componentId}"/>">
                                    <td><c:out value="${yeast.componentId}" /></td>
                                    <td><c:out value="${yeast.componentYeast.name}" /></td>
                                    <td><c:out value="${yeast.componentYeast.yeastType.name}" /></td>
                                    <td><c:out value="${yeast.componentYeast.yeastForm.name}" /></td>
                                </tr>
                            </c:forEach>
                        </div>
                        </tbody>
                    </table>
                    <div class="modal-footer">
                        <form class="form-horizontal" id="frmAddYeast" method="POST" action='#' name="frmAddYeast">
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