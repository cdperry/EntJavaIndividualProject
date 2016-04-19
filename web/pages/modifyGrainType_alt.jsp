<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Your META here -->
        <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0" name="viewport">

        <!-- Stylesheets -->
        <link rel="stylesheet" href="../css/jforms/demo.css">
        <link rel="stylesheet" href="../css/jforms/font-awesome.min.css">
        <link rel="stylesheet" href="../css/jforms/j-forms.css">

        <!-- Scripts -->
        <script src="../js/jquery/jquery.1.11.1.min.js"></script>
        <script src="../js/jforms/j-forms-modal.js"></script>

        <title>Boogey!</title>
    </head>
    <body>

        <div class="modal-form" id="registration-form">
            <div class="wrapper wrapper-400">
                <form method="POST" action='/grainTypeController' name="frmAddGrainType" class="j-forms">

                    <div class="header">
                        <p>Add/Edit Grain Type</p>
                        <!-- start close-modal button -->
                        <label class="modal-close">
                            <i></i>
                        </label>
                        <!-- end close-modal button -->
                    </div>

                    <div class="content">

                        <div class="j-row">
                            <div class="span4">
                                <label class="label label-center">ID</label>
                            </div>
                            <div class="span8 unit">
                                <div class="input">
                                    <label class="icon-right" for="ID">
                                        <i class="fa fa-user"></i>
                                    </label>
                                    <input type="text" readonly="readonly" name="grainTypeId" value="<c:out value="${grainType.grainTypeId}" />" />
                                </div>
                            </div>
                        </div>

                        <div class="j-row">
                            <div class="span4">
                                <label class="label label-center">Name</label>
                            </div>
                            <div class="span8 unit">
                                <div class="input">
                                    <label class="icon-right" for="name">
                                        <i class="fa fa-user"></i>
                                    </label>
                                    <input type="text" name="name" value="<c:out value="${grainType.name}" />" />
                                </div>
                            </div>
                        </div>

                        <div class="j-row">
                            <div class="span4">
                                <label class="label label-center">Create Date</label>
                            </div>
                            <div class="span8 unit">
                                <div class="input">
                                    <label class="icon-right" for="create date">
                                        <i class="fa fa-user"></i>
                                    </label>
                                    <input type="text" readonly="readonly" name="createDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.createDate}" />" />
                                </div>
                            </div>
                        </div>

                        <div class="j-row">
                            <div class="span4">
                                <label class="label label-center">Update Date</label>
                            </div>
                            <div class="span8 unit">
                                <div class="input">
                                    <label class="icon-right" for="update date">
                                        <i class="fa fa-user"></i>
                                    </label>
                                    <input type="text" readonly="readonly" name="updateDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${grainType.updateDate}" />" /> <br />
                                </div>
                            </div>
                        </div>

                        <div class="footer">
                            <button type="submit" class="primary-btn disabled-view" id="enable-button" disabled="">Update</button>
                        </div>
                        <!--<input type="submit" value="Submit" />-->
                    </div>
                </form>
            </div>
        </div>
        <script>
            $(document).ready(function() {

                // Enabled button
                $('#check-enable-button').on('change', function() {
                    if ( $('#check-enable-button').is(':checked') ) {
                        $('#enable-button').attr('disabled', false).removeClass('disabled-view');
                    } else {
                        $('#enable-button').attr('disabled', true).addClass('disabled-view');
                    };
                });
            });
        </script>

    </body>
</html>