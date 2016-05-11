<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header text-primary">Welcome!</h1>
    </div>
</div>

<%--
<div class="row">

    <div class="col-lg-12 text-info">
        <h3>Select an option from the left to begin</h3>
    </div>

</div>
--%>

<div class="row">
    <div class="col-lg-12 text-info">
        <h3>Did You Know ...</h3>
        <blockquote>
            ${chuckNorrisJoke.joke}
        </blockquote>
    </div>
</div>

