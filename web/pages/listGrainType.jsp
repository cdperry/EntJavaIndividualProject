<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="en">

    <c:import url="components/main-head-tag.jsp" />

    <body>

        <div id="wrapper">

            <c:import url="components/main-navigation.jsp" />

            <div id="page-wrapper">

                <c:import url="components/main-title.jsp" />

                <div class="row">

                    <div class="col-lg-12">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <%--<th>Grain Type ID</th>--%>
                                    <th>Grain Type Name</th>
                                    <th>Create Date</th>
                                    <th>Update Date</th>
                                    <th colspan=2 class="text-center">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${grainTypes}" var="grainType">
                                    <tr>
                                        <%--<td><c:out value="${grainType.grainTypeId}" /></td>--%>
                                        <td><c:out value="${grainType.name}" /></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.createDate}" /></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.updateDate}" /></td>
                                        <td class="text-center">
                                            <a href="/grainTypeController?action=edit&grainTypeId=<c:out value="${grainType.grainTypeId}"/>">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </a>
                                        </td>
                                        <td class="text-center">
                                            <a href="#" data-id="<c:out value="${grainType.grainTypeId}"/>"
                                               data-toggle="modal" data-target="#myModal">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </a>
                                        </td>
                                        <td class="text-center">
                                            <a href="/grainTypeController?action=delete&grainTypeId=<c:out value="${grainType.grainTypeId}"/>">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <p><a href="/grainTypeController?action=insert">Add Grain Type</a></p>
                    </div>

                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure you want to delete this record?  This action is irreversible.
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <a id="confirmedDelete" href="#"
                                           type="button" class="btn btn-primary">
                                            Delete
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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

        <script>
            $('#myModal').on('show.bs.modal', function (event) {
                var docElement = $(event.relatedTarget) // Element that triggered the modal
                var id = docElement.data('id') // Extract info from data-* attributes
                $("#confirmedDelete").attr('href', '/grainTypeController?action=delete&grainTypeId=' + id)
            })
        </script>

    </body>

</html>
