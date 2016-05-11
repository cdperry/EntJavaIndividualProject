<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>

        <c:import url="../components/main-head-tag.jsp" />

    </head>
    <body>

    <div id="wrapper">

        <c:import url="../components/main-navigation.jsp" />

        <div id="page-wrapper">

            <div class="row">

                <div class="col-lg-10">

                    <table id="example" class="table table-hover">
                        <thead>
                        <th>First Name</th>
                        <th>Last Name</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Chris</td>
                            <td>Perry</td>
                        </tr>
                        <tr>
                            <td>Erin</td>
                            <td>Perry</td>
                        </tr>
                        <tr>
                            <td>Michael</td>
                            <td>Banas</td>
                        </tr>
                        </tbody>
                    </table>

                </div>

            </div>

        </div>

    </div>

        <c:import url="../components/main-scripts.jsp" />

        <script type="text/javascript">
            $(document).ready( function () {
                $('#example').DataTable();
            } );
        </script>

    </body>
</html>