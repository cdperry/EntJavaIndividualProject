<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

    <c:import url="components/main-head-tag.jsp" />

    <body>

        <div id="wrapper">

            <c:import url="components/main-navigation.jsp" />

            <div id="page-wrapper">

                <c:import url="components/origin-body.jsp" />
                <c:import url="components/delete-modal-dialog.jsp" />

            </div>

        </div>

        <c:import url="components/main-scripts.jsp" />

        <script>
            $('#myModal').on('show.bs.modal', function (event) {
                var docElement = $(event.relatedTarget) // Element that triggered the modal
                var id = docElement.data('id') // Extract info from data-* attributes
                <%--$("#confirmedDelete").attr('href', '/deleteOriginType?originId=' + id)--%>
                $("#frmConfirmDelete").attr("action", "deleteOrigin?originId=" + id)
            })
        </script>

    </body>

</html>
