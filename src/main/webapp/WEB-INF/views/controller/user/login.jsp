<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>

</head>
<body>

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            <span class="sr-only">Error:</span>
                ${error}
        </div>
    </c:if>

    <div class="col-sm-5 col-md-6">
        <jsp:include page="../user/form/login.jsp" />
    </div>
</body>
</html>