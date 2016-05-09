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

            $('#modalAddGrain tr').click(function (event) {
                var compId = $(this).attr('compId');
                var recipeId = $(this).attr('recipeId');
                var url = "/doEditRecipeComponent?action=edit&recipeId=" + recipeId + "&componentId=" + compId;
                //alert(url); //trying to alert id of the clicked row
                $("#frmAddGrain").attr("action", url);
                $(this).addClass('info').siblings().removeClass('info');
            });

            $('#modalAddHop tr').click(function (event) {
                var compId = $(this).attr('compId');
                var recipeId = $(this).attr('recipeId');
                var url = "/doEditRecipeComponent?action=edit&recipeId=" + recipeId + "&componentId=" + compId;
                //alert(url); //trying to alert id of the clicked row
                $("#frmAddHop").attr("action", url);
                $(this).addClass('info').siblings().removeClass('info');
            });

            $('#modalAddYeast tr').click(function (event) {
                var compId = $(this).attr('compId');
                var recipeId = $(this).attr('recipeId');
                var url = "/doEditRecipeComponent?action=edit&recipeId=" + recipeId + "&componentId=" + compId;
                //alert(url); //trying to alert id of the clicked row
                $("#frmAddYeast").attr("action", url);
                $(this).addClass('info').siblings().removeClass('info');
            });

            $('#modalAddWater tr').click(function (event) {
                var compId = $(this).attr('compId');
                var recipeId = $(this).attr('recipeId');
                var url = "/doEditRecipeComponent?action=edit&recipeId=" + recipeId + "&componentId=" + compId;
                //alert(url); //trying to alert id of the clicked row
                $("#frmAddWater").attr("action", url);
                $(this).addClass('info').siblings().removeClass('info');
            });

            $('#modalAddOther tr').click(function (event) {
                var compId = $(this).attr('compId');
                var recipeId = $(this).attr('recipeId');
                var url = "/doEditRecipeComponent?action=edit&recipeId=" + recipeId + "&componentId=" + compId;
                //alert(url); //trying to alert id of the clicked row
                $("#frmAddOther").attr("action", url);
                $(this).addClass('info').siblings().removeClass('info');
            });

        </script>

    </body>

</html>
