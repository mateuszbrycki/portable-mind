<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../include/header.jsp" />

<div class="container">
    <jsp:include page="../include/navbar_modals.jsp" />

    <h1><a href="${pageContext.request.contextPath}/"><spring:message code="portablemind" /></a></h1>

    <sitemesh:write property='body'/>
</div>
<jsp:include page="../include/footer.jsp" />