<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="com.portablemind.helper.translation.TranslationHelper" %>
<html>
<body>
  <h1>${project.name}</h1>

  <jsp:include page="../card/form/add_card.jsp" />
  <button type="button" id="show-add-card-form" class="btn btn-primary" data-dismiss="modal" style="margin: 2px;">Add card</button>

  <table class="table table-striped table-bordered table-hover table-condensed" id="cards-list">
    <tbody id="cards-list-body">
    <tr id="cards-list-title">
      <td><strong>Category name</strong></td>
      <td><strong>Description</strong></td>
    </tr>
      <c:forEach items="${cards}" var="card">
        <tr>
          <td>${card.category.name}</td>
          <td>${card.description}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>