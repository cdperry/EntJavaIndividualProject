<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

    $('#modalAddGrain tr').click(function (event) {
        var compId = $(this).attr('compId');
        var recipeId = $(this).attr('recipeId');
        var url = "doEditRecipeComponent?action=insert&recipeId=" + recipeId + "&componentId=" + compId;
        //alert(url); //trying to alert id of the clicked row
        $("#frmAddGrain").attr("action", url);
        $(this).addClass('info').siblings().removeClass('info');
    });

    $('#modalAddGrain').on('show.bs.modal', function (event) {
        // TODO: responsive datatable not working, spilling over modal window boundary.  Removed 'nowrap' from table for now.
        var dataTable = $('#grainListTbl').DataTable();
        dataTable.columns.adjust();
        dataTable.responsive.recalc();
        $("div.addGrain select").val(6); //TODO: UOM 6 = lbs can this be pulled from a properties file somehow?
    });

    $('#modalAddHop tr').click(function (event) {
        var compId = $(this).attr('compId');
        var recipeId = $(this).attr('recipeId');
        var url = "doEditRecipeComponent?action=insert&recipeId=" + recipeId + "&componentId=" + compId;
        //alert(url); //trying to alert id of the clicked row
        $("#frmAddHop").attr("action", url);
        $(this).addClass('info').siblings().removeClass('info');
    });

    $('#modalAddHop').on('show.bs.modal', function (event) {

        // TODO: deal with responsive datatable issue
        $("div.addHopAmt select").val(3); //TODO: UOM 3 = oz, can this be pulled from a properties file somehow?
        $("div.addHopTime select").val(8); //TODO: UOM 8 = min, can this be pulled from a properties file somehow?
    });

    $('#modalAddYeast tr').click(function (event) {
        var compId = $(this).attr('compId');
        var recipeId = $(this).attr('recipeId');
        var url = "doEditRecipeComponent?action=insert&recipeId=" + recipeId + "&componentId=" + compId;
        //alert(url); //trying to alert id of the clicked row

        $("#frmAddYeast").attr("action", url);
        $(this).addClass('info').siblings().removeClass('info');
    });

    $('#modalAddYeast').on('show.bs.modal', function (event) {
        // TODO: deal with responsive datatable issue
        $("div.addYeast select").val(5); //TODO: UOM 5 = pkg, can this be pulled from a properties file somehow?
    });

    $('#modalAddWater tr').click(function (event) {
        var compId = $(this).attr('compId');
        var recipeId = $(this).attr('recipeId');
        var url = "doEditRecipeComponent?action=insert&recipeId=" + recipeId + "&componentId=" + compId;
        //alert(url); //trying to alert id of the clicked row
        $("#frmAddWater").attr("action", url);
        $(this).addClass('info').siblings().removeClass('info');
    });

    $('#modalAddWater').on('show.bs.modal', function (event) {
        // TODO: deal with responsive datatable issue
        $("div.addWater select").val(1); //TODO: UOM 1 = gal, can this be pulled from a properties file somehow?
    });

    $('#modalAddOther tr').click(function (event) {
        var compId = $(this).attr('compId');
        var recipeId = $(this).attr('recipeId');
        var url = "doEditRecipeComponent?action=insert&recipeId=" + recipeId + "&componentId=" + compId;
        //alert(url); //trying to alert id of the clicked row
        $("#frmAddOther").attr("action", url);
        $(this).addClass('info').siblings().removeClass('info');
    });

    $('#modalAddOther').on('show.bs.modal', function (event) {
        // TODO: deal with responsive datatable issue
        $("div.addOther select").val(2); //TODO: UOM 2 = ea, can this be pulled from a properties file somehow?
    });

    $('#editRecipeComponentModal').on('show.bs.modal', function (event) {
        var docElement = $(event.relatedTarget); // Element that triggered the modal
        var recipeId = docElement.data('recipeid');
        var recipeComponentId = docElement.data('recipecomponentid');
        var amount = docElement.data('amount');
        var amountUomId = docElement.data('amountuomid');
        var time = docElement.data('time');
        var timeUomId = docElement.data('timeuomid');
        var componentTypeName = docElement.data('componenttypename');
        var url = "doEditRecipeComponent?action=edit&recipeId=" + recipeId + "&recipeComponentId="
                + recipeComponentId;

        if (componentTypeName == "Hop" || componentTypeName == "Hop") {
            $("div.updatedTimeGroup").removeClass('hidden');
        } else {
            $("div.updatedTimeGroup").addClass('hidden');
        }

        $("#newAmount").attr("value", amount);
        $("div.updatedAmountGroup select").val(amountUomId);
        $("#newTime").attr("value", time);
        $("div.updatedTimeGroup select").val(timeUomId);
        $("#frmEditComponent").attr("action", url)
    });

    $('#deleteRecipeComponentModal').on('show.bs.modal', function (event) {
        var docElement = $(event.relatedTarget); // Element that triggered the modal
        var recipeId = docElement.data('recipeid');
        var recipeComponentId = docElement.data('recipecomponentid');
        var url = "deleteRecipeComponent?action=delete&recipeId=" + recipeId + "&recipeComponentId="
                + recipeComponentId;
        //alert(url);
        $("#frmConfirmDelete").attr("action", url)
    });

    $(document).ready(function() {

        $('#grainListTbl').DataTable(
                {
                    "lengthChange": false,
                    "searching": true,
                    "pageLength": 8,
                    "order": [[1, 'asc']],
                    "columnDefs": [
                        {
                            "visible":false,
                            "targets":[0]
                        }
                    ],
                    "aoColumns": [
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ]
                });

        $('#hopListTbl').DataTable(
                {
                    "lengthChange": false,
                    "searching": true,
                    "pageLength": 8,
                    "order": [[1, 'asc']],
                    "columnDefs": [
                        {
                            "visible":false,
                            "targets":[0]
                        }
                    ],
                    "aoColumns": [
                        null,
                        null,
                        null,
                        null,
                        null
                    ]
                });

        $('#otherListTbl').DataTable(
                {
                    "lengthChange": false,
                    "searching": true,
                    "pageLength": 8,
                    "order": [[1, 'asc']],
                    "columnDefs": [
                        {
                            "visible":false,
                            "targets":[0]
                        }
                    ],
                    "aoColumns": [
                        null,
                        null,
                        null,
                        null
                    ]
                });

        $('#waterListTbl').DataTable(
                {
                    "lengthChange": false,
                    "searching": true,
                    "pageLength": 8,
                    "order": [[1, 'asc']],
                    "columnDefs": [
                        {
                            "visible":false,
                            "targets":[0]
                        }
                    ],
                    "aoColumns": [
                        null,
                        null,
                        null
                    ]
                });

        $('#yeastListTbl').DataTable(
                {
                    "lengthChange": false,
                    "searching": true,
                    "pageLength": 8,
                    "order": [[1, 'asc']],
                    "columnDefs": [
                        {
                            "visible":false,
                            "targets":[0]
                        }
                    ],
                    "aoColumns": [
                        null,
                        null,
                        null,
                        null
                    ]
                });


        $('#recipeComponents').DataTable(
                {
                    "lengthChange": false,
                    "searching": false,
                    "pageLength": 8,
                    "order": [[0, 'asc'], [1, 'asc']],
                    "columnDefs": [
                        {
                            "render": function(data, type, row) {
                                var amountUom;
                                var time;
                                var timeUom;
                                var componentType;
                                var displayString;

                                componentType = row[0];
                                amountUom = row[3];
                                time = row[4];
                                timeUom = row[5];

                                displayString = data + ' ' + amountUom;

                                if (componentType == "Hop") {
                                    displayString = displayString + ' @ ' + time + ' ' + timeUom;
                                }

                                return displayString;
                            },
                            "targets": 2
                        },
                        {
                            "visible":false,
                            "targets":[3,4,5]
                        }
                    ],
                    "aoColumns": [
                        null,
                        null,
                        { "bSortable": false },
                        { "bSortable": false },
                        { "bSortable": false },
                        { "bSortable": false },
                        { "bSortable": false },
                        { "bSortable": false }
                    ]
                });
    } );

</script>