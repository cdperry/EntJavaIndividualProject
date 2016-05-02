<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Equipment Profiles</h1>
    </div>
</div>

<div class="row">

    <div class="col-lg-12">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Profile Name</th>
                <th>Batch Volume</th>
                <th>Boil Volume</th>
                <th>Bottle Volume</th>
                <th>Last Updated</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${equipmentProfiles}" var="equipmentProfile">
                <tr>
                    <td><c:out value="${equipmentProfile.name}" /></td>
                    <td><c:out value="${equipmentProfile.fermBatchVol}" /></td>
                    <td><c:out value="${equipmentProfile.boilVol}" /></td>
                    <td><c:out value="${equipmentProfile.bottlingVol}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${equipmentProfile.updateDate}" /></td>
                    <td class="text-center">
                        <a href="/editEquipmentProfile?action=edit&profileEquipmentId=<c:out
                                value="${equipmentProfile.profileEquipmentId}"/>">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td class="text-center">
                        <a href="#" data-id="<c:out value="${equipmentProfile.profileEquipmentId}"/>"
                           data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p><a href="/addEquipmentProfile?action=insert">Add Equipment Profile</a></p>

    </div>

</div>

