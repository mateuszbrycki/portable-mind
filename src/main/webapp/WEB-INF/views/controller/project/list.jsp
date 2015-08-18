<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="com.portablemind.helper.translation.TranslationHelper" %>
<html>
<body>
  <h1>${project.name}</h1>

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
        </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>