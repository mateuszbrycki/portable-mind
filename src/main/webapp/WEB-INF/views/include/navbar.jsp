<%@ page import="com.portablemind.user.UserUtilities" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="hasUserProjects" scope="session" value="<%=UserUtilities.hasUserProjects()%>"/>

<nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/"><spring:message code="portablemind" /></a>
    </div>
    <ul class="nav navbar-nav">
      <li type="button"  data-dismiss="modal" style="margin: 2px;">
        <a href="#" id="show-add-project-form">
          <span class="glyphicon glyphicon-plus"></span>
          <spring:message code="project.button.add" />
        </a>
      </li>
      <li type="button" data-dismiss="modal" style="margin: 2px;" <c:if test="${not hasUserProjects}">class="disabled"</c:if> id="show-add-card-form-button">
        <a href="#" id="show-add-card-form">
          <span class="glyphicon glyphicon-plus"></span>
          <spring:message code="card.button.add" />
        </a>
      </li>
    </ul>
    <c:url var="logoutUrl" value="/j_spring_security_logout"/>
    <form action="${logoutUrl}" method="post" id="logoutForm" style="float: right; margin-top: 10px;">

      <input type="submit" id="login-user" name="submit" value="<spring:message code="button.logout" />" class="btn btn-primary"/>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    </form>

  </div>
</nav>