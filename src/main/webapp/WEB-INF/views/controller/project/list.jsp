<%@ page import="com.portablemind.helper.image.ImageHelper" %>
<%@ page import="com.portablemind.card.CardUrls" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>

  <c:set var="cardCategoryImagePath" scope="session" value="<%=ImageHelper.getCardCategoryImagePath()%>"/>
  <h1>${project.name}</h1>

  <script>var projectId = "${project.id}"</script>
  <jsp:include page="../card/form/edit_card.jsp" />
  <div id="card-list">
    <div id="panel-group" id="accordion">
      <c:choose>
        <c:when test="${fn:length(cards) gt 0}">
          <c:forEach items="${cards}" var="card">
            <div class="panel panel-default">
              <div class="panel-heading">
                <c:if test="${not empty card.category.icon}">
                  <img src="<c:url value="${card.category.icon}" />" alt="${card.category.name}" class="category-icon"/>
                </c:if>
                <p class="card-title" style="margin-left: 3px;">
                  <c:if test="${not empty card.name}">
                    ${card.name} -
                  </c:if>
                  ${card.category.name}
                </p>
              </div>
              <div id="collapse${card.id}" class="panel-collapse collapse in" aria-expanded="true">
                <div class="panel-body">
                    ${card.description}
                </div>
              </div>
              <div class="panel-footer clearfix">
                <div class="footer-buttons">
                  <button type="button" class="edit-card btn btn-primary" href="${pageContext.request.contextPath}<%=CardUrls.Api.CARD%>/${card.id}">
                    <span class="glyphicon glyphicon-edit"></span>
                    <spring:message code="button.edit" /></button>
                  <button type="button" class="delete-card btn btn-danger" href="${pageContext.request.contextPath}<%=CardUrls.Api.CARD%>/${card.id}">
                    <span class="glyphicon glyphicon-remove"></span>
                    <spring:message code="button.delete" /></button>
                </div>
              </div>
            </div>
          </c:forEach>
        </c:when>
        <c:otherwise>
          <div class="alert alert-info" role="alert">
            <spring:message code="message.card.list.empty" />
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</body>
</html>