<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

    <c:import url="components/main-head-tag.jsp" />

    <body>

        <div id="wrapper">

            <c:import url="components/main-navigation.jsp" />

            <div id="page-wrapper">

                <c:import url="components/hops-body.jsp" />
                <c:import url="components/delete-modal-dialog.jsp" />

            </div>

        </div>

        <c:import url="components/main-scripts.jsp" />

        <script>
            $('#myModal').on('show.bs.modal', function (event) {
                var docElement = $(event.relatedTarget) // Element that triggered the modal
                var id = docElement.data('id') // Extract info from data-* attributes
                <%--$("#confirmedDelete").attr('href', '/deleteHop?hopId=' + id)--%>
                $("#frmConfirmDelete").attr("action", "/deleteHop?componentId=" + id)
            })
        </script>

        <script>
            $(document).ready(function() {
                $('#example').DataTable(
                        {
                            "lengthChange": false,
                            "pageLength": 10,
                            "aoColumns": [
                                null,
                                null,
                                null,
                                null,
                                null,
                                { "bSortable": false },
                                { "bSortable": false }
                            ]
                        }
                );
            } );
        </script>

    </body>

</html>
