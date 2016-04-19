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

                        <form class="form-horizontal" method="POST" action='/grainTypeController' name="frmAddGrainType">
                            <div class="form-group">
                                <label for="grainTypeId" class="col-sm-2 control-label">ID</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" readonly="readonly" id="grainTypeId"
                                           name="grainTypeId"
                                           value="<c:out value="${grainType.grainTypeId}" />" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="name" name="name"
                                            value="<c:out value="${grainType.name}" />" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="createDate" class="col-sm-2 control-label">ID</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" readonly="readonly" id="createDate"
                                           name="createDate"
                                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${grainType.createDate}" />" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="updateDate" class="col-sm-2 control-label">ID</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" readonly="readonly" id="updateDate"
                                           name="updateDate"
                                           value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                    value="${grainType.updateDate}" />" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <c:choose>
                                        <c:when test="${actionType == 'edit'}">
                                            <c:set var="buttonText" scope="request" value="Update Grain Type"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="buttonText" scope="request" value="Add Grain Type"/>
                                        </c:otherwise>
                                    </c:choose>
                                    <%--<button type="submit" class="btn btn-default" name="button">${buttonText}</button>--%>
                                    <button type="submit" class="btn btn-default" name="buttonAction"
                                           value="submit">${buttonText}</button>
                                    <button type="submit" class="btn btn-default" name="buttonAction"
                                           value="cancel">Cancel</button>
                                </div>
                            </div>
                        </form>

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

    </body>

</html>
