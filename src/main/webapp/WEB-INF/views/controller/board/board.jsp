<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
	<sec:authorize access="isAuthenticated()">
		<div id="projects-list">
			<div id="panel-group" id="accordion">
			<c:choose>
				<c:when test="${fn:length(projects) gt 0}">
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
									<button type="button" class="edit-project btn btn-primary"> <span class="glyphicon glyphicon-edit"></span> Edit</button>
									<button type="button" class="delete-project btn btn-danger" href="${pageContext.request.contextPath}/project/${project.id}"><span class="glyphicon glyphicon-remove"></span> Delete</button>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="alert alert-info" role="alert">
						You don't have any projects.
					</div>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</sec:authorize>
</body>
</html>