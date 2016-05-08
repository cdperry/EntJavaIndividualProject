<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

    <c:import url="components/main-head-tag.jsp" />

    <body>

        <div id="wrapper">

            <c:import url="components/main-navigation.jsp" />

            <div id="page-wrapper">

                <c:import url="components/recipe-edit-body.jsp" />

            </div>

        </div>

        <c:import url="components/main-scripts.jsp" />

        <script>
            $('#modalAddGrain').on('show.bs.modal', function (event) {
                var docElement = $(event.relatedTarget) // Element that triggered the modal
                var id = docElement.data('id') // Extract info from data-* attributes
                $("#frmAddGrain").attr("action", "/doEditRecipeComponent?action=edit&recipeId=" + id)
            })
        </script>

    </body>

</html>
