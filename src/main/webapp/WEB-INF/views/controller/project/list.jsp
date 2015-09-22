<%@ page import="com.portablemind.helper.image.ImageHelper" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

  <c:set var="cardCategoryImagePath" scope="session" value="<%=ImageHelper.getCardCategoryImagePath()%>"/>
  <h1>${project.name}</h1>

  <script>var projectId = "${project.id}"</script>

  <div id="card-list">
    <div id="panel-group" id="accordion">
      <c:forEach items="${cards}" var="card">
        <div class="panel panel-default">
          <div class="panel-heading">
            <c:if test="${not empty card.category.icon}">
              <img src="<c:url value="${cardCategoryImagePath}/${card.category.icon}" />" alt="${card.category.name}" class="category-icon"/>
            </c:if>

            <c:if test="${not empty card.name}">
              ${card.name} -
            </c:if>
            ${card.category.name}
          </div>
          <div id="collapse${card.id}" class="panel-collapse collapse in" aria-expanded="true">
            <div class="panel-body">
                ${card.description}
            </div>
          </div>
          <div class="panel-footer clearfix">
            <div class="footer-buttons">
              <button type="button" class="edit-card btn btn-primary"> <span class="glyphicon glyphicon-edit"></span> Edit</button>
              <button type="button" class="delete-card btn btn-danger" href="${pageContext.request.contextPath}/card/${card.id}"><span class="glyphicon glyphicon-remove"></span> Delete</button>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>