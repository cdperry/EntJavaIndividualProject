<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

    <c:import url="components/main-head-tag.jsp" />

    <body>

        <jsp:forward page="/grainTypeController?action=list"></jsp:forward>

        <div id="wrapper">

            <c:import url="components/main-navigation.jsp" />

            <div id="page-wrapper">

                <c:import url="components/main-title.jsp" />
                <%--<c:import url="components/main-panels.jsp" />--%>

                <div class="row">

                    <%--
                    <div class="col-lg-8">
                        <c:import url="components/main-area-chart.jsp" />
                        <c:import url="components/main-bar-chart.jsp" />
                        <c:import url="components/main-timeline.jsp" />
                    </div>

                    <div class="col-lg-4">
                        <c:import url="components/main-notification-panel.jsp" />
                        <c:import url="components/main-donut-chart.jsp" />
                        <c:import url="components/main-chat-panel.jsp" />
                    </div>
                    --%>

                </div>

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

    </body>

</html>
