<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<div class="container">
    <h1><a href="${pageContext.request.contextPath}">Portable Mind</a></h1>
    <sitemesh:write property='body'/>
</div>
<jsp:include page="../include/footer.jsp" />