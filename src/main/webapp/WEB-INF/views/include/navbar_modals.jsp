<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authorize access="isAuthenticated()">
  <jsp:include page="../controller/card/form/add_card.jsp" />
  <jsp:include page="../controller/project/form/add_project.jsp" />

  <jsp:include page="../include/navbar.jsp" />
</sec:authorize>