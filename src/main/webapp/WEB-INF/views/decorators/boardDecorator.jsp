<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/header.jsp" />

<div class="container">

    <select id="language-select" onchange="changeLanguage(this.value)">
        <option value="en" data-image="<c:url value="/resources/img/language/en.png" />"></option>
        <option value="pl_PL" data-image="<c:url value="/resources/img/language/pl_PL.png" />"></option>
    </select>

    <jsp:include page="../include/navbar_modals.jsp" />

    <h1><a href="${pageContext.request.contextPath}/"><spring:message code="portablemind" /></a></h1>

    <sitemesh:write property='body'/>
</div>
<jsp:include page="../include/footer.jsp" />