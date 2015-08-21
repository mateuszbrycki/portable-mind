<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="com.portablemind.helper.translation.TranslationHelper" %>
<html>
<body>

	<%--<%=TranslationHelper.getTranslation("mainHeader")%>--%>

	<sec:authorize access="isAuthenticated()">
		<jsp:include page="../card/form/add_card.jsp" />
		<jsp:include page="../project/form/add_project.jsp" />

		<button type="button" id="show-add-project-form" class="btn btn-primary" data-dismiss="modal" style="margin: 2px;">Add project</button>
		<button type="button" id="show-add-card-form" class="btn btn-primary" data-dismiss="modal" style="margin: 2px;">Add card</button>

		<c:url var="logoutUrl" value="/j_spring_security_logout"/>
		<form action="${logoutUrl}" method="post" id="logoutForm" style="float: right;">

			<input type="submit" id="login-user" name="submit" value="Logout" class="btn btn-primary"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form>

		<div id="projects-list">
		<div id="panel-group" id="accordion">
			<c:forEach items="${projects}" var="project">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a href="${pageContext.request.contextPath}/project/${project.id}">${project.name}</a>
						</h4>
					</div>
					<div id="collapse${project.id}" class="panel-collapse collapse in" aria-expanded="true">
						<div class="panel-body">
								${project.description}
						</div>
					</div>
					<div class="panel-footer clearfix">
						<div class="footer-buttons">
							<button type="button" class="edit-project btn btn-primary">Edit</button>
							<button type="button" class="delete-project btn btn-danger" href="${pageContext.request.contextPath}/project/${project.id}">Delete</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	</sec:authorize>
</body>
</html>