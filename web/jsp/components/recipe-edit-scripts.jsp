<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    $('#editRecipeComponentModal').on('show.bs.modal', function (event) {
        var docElement = $(event.relatedTarget); // Element that triggered the modal
        var recipeId = docElement.data('recipeid');
        var componentId = docElement.data('componentid');
        var amount = docElement.data('amount');
        var amountUomId = docElement.data('amountuomid');
        alert(amount + " " + amountUomId)
        var url = "/deleteRecipeComponent?action=edit&recipeId=" + recipeId + "&recipeComponentId="
                + componentId;
        //alert(url);
        $("#newAmount").attr("value", amount);
        $("#frmEditComponent").attr("action", url)
    });

    $('#deleteRecipeComponentModal').on('show.bs.modal', function (event) {
        var docElement = $(event.relatedTarget); // Element that triggered the modal
        var recipeId = docElement.data('recipeid');
        var componentId = docElement.data('componentid');
        var url = "/deleteRecipeComponent?action=edit&recipeId=" + recipeId + "&recipeComponentId="
                + componentId;
        //alert(url);
        $("#frmConfirmDelete").attr("action", url)
    });

    $(document).ready(function() {
        $('#recipeComponents').DataTable(
                {
                    "lengthChange": false,
                    "searching": false,
                    "pageLength": 8,
                    "order": [[0, 'asc'], [1, 'asc']],
                    "columnDefs": [
                        {
                            "render": function(data, type, row) {
                                return data + ' ' + row[3];
                            },
                            "targets": 2
                        },
                        {
                            "visible":false,
                            "targets":[3]
                        }
                    ],
                    "aoColumns": [
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