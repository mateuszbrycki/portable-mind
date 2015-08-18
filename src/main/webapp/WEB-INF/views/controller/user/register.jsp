<%--
  Created by IntelliJ IDEA.
  User: Mateusz Brycki
  Date: 29/05/2015
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
  <title>Register</title>
</head>
<body>

  <div class="col-sm-5 col-md-6">
    <c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
      <span class="sr-only">Error:</span>
      ${error}
    </div>
  </c:if>

  <c:if test="${not empty success}">
    <div class="alert alert-success" role="alert">
      <span class="sr-only">Success:</span>
      ${success}
    </div>
  </c:if>

    <jsp:include page="../user/form/register.jsp" />
  </div>

</body>
</html>