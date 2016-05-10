<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <div class="modal fade" id="deleteRecipeComponentModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to delete this ingredient?  This action is irreversible.
                    </div>
                    <div class="modal-footer">
                        <form class="form-horizontal" id="frmConfirmDelete" method="POST" action='#' name="frmConfirmDelete">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="buttonAction"
                                    value="submit">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>