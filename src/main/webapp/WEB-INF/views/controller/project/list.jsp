<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
  <h1>${project.name}</h1>

  <script>var projectId = "${project.id}"</script>

  <jsp:include page="../card/form/add_card.jsp" />
  <button type="button" id="show-add-card-form" class="btn btn-primary" data-dismiss="modal" style="margin: 2px;">Add card</button>

  <div id="card-list">
    <div id="panel-group" id="accordion">
      <c:forEach items="${cards}" var="card">
        <div class="panel panel-default">
          <div class="panel-heading">
            ${card.category.name}
          </div>
          <div id="collapse${card.id}" class="panel-collapse collapse in" aria-expanded="true">
            <div class="panel-body">
                ${card.description}
            </div>
          </div>
          <div class="panel-footer clearfix">
            <div class="footer-buttons">
              <button type="button" class="edit-card btn btn-primary">Edit</button>
              <button type="button" class="delete-card btn btn-danger" href="${pageContext.request.contextPath}/card/${card.id}">Delete</button>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>