<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="add-card-modal" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close add-card-form-close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="add-card-modal-title">Add new card</h4>
            </div>
            <form method="PUT" id="add-card-form" action="${pageContext.request.contextPath}/card" class="form-horizontal" >
                <div class="modal-body">
                    <c:choose>
                        <c:when test="${not empty requestScope.projectId }">
                            <input type="hidden" name="project" value="${requestScope.projectId}" />
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <label class="control-label col-sm-3" for="project">Project: </label>
                                <div id="add-card-form-project" class="col-sm-5">
                                    <select name="project" class="form-control">
                                        <c:forEach items="${projects}" var="project">
                                            <option value="${project.id}">${project.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="cardCategory">Category:</label>
                        <div id="add-card-form-category" class="col-sm-5">
                            <select name="category" class="form-control">
                                <c:forEach items="${cardCategories}" var="cardCategory">
                                    <option value="${cardCategory.id}">${cardCategory.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-3" for="cardName">Name:</label>
                        <div class="col-sm-5">
                            <input type="text" name="name"  class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-3" for="cardDescription">Description:</label>
                        <div class="col-sm-5">
                            <textarea type="text" name="description" class="form-control" rows="6"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default add-card-form-close" data-dismiss="modal">Close</button>
                    <input type="submit" id="add-card-submit" value="Add card" class="btn btn-primary"/>
                </div>
            </form>
        </div>
    </div>
</div>

