<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

    <c:import url="components/main-head-tag.jsp" />

    <body>

        <div id="wrapper">

            <c:import url="components/main-navigation.jsp" />

            <div id="page-wrapper">

                <c:import url="components/hop-form-type-body.jsp" />
                <c:import url="components/delete-modal-dialog.jsp" />

            </div>

        </div>

        <!-- jQuery -->
        <script src="../bower_components/jquery/dist/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

        <!-- Morris Charts JavaScript -->
        <%--
        <script src="../bower_components/raphael/raphael-min.js"></script>
        <script src="../bower_components/morrisjs/morris.min.js"></script>
        <script src="../js/morris-data.js"></script>
        --%>

        <!-- Custom Theme JavaScript -->
        <script src="../dist/js/sb-admin-2.js"></script>

        <script>
            $('#myModal').on('show.bs.modal', function (event) {
                var docElement = $(event.relatedTarget) // Element that triggered the modal
                var id = docElement.data('id') // Extract info from data-* attributes
                $("#confirmedDelete").attr('href', '/deleteHopFormType?hopFormTypeId=' + id)
            })
        </script>

    </body>

</html>
