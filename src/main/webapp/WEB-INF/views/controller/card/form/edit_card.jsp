<%@ page import="com.portablemind.card.CardUrls" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="edit-card-modal" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close edit-card-form-close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="edit-card-modal-title"><spring:message code="card.modal.title.edit" /></h4>
            </div>
            <form method="PUT" id="edit-card-form" action="${pageContext.request.contextPath}<%=CardUrls.Api.CARD%>" class="form-horizontal" >
                <div class="modal-body">
                    <input type="hidden" name="id" value="" />
                    <input type="hidden" name="project" value="" />
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="cardCategory"><spring:message code="card.modal.category" />:</label>
                        <div id="edit-card-form-category" class="col-sm-5">
                            <select name="category" class="form-control">
                                <c:forEach items="${cardCategories}" var="cardCategory">
                                    <option value="${cardCategory.id}">${cardCategory.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-3" for="cardName"><spring:message code="card.modal.name" />:</label>
                        <div class="col-sm-5">
                            <input type="text" name="name"  class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-3" for="cardDescription"><spring:message code="card.modal.description" />:</label>
                        <div class="col-sm-5">
                            <textarea type="text" name="description" class="form-control" rows="6"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default edit-card-form-close" data-dismiss="modal"><spring:message code="button.close" /></button>
                    <input type="submit" id="edit-card-submit" value="<spring:message code="card.button.edit" />" class="btn btn-primary"/>
                </div>
            </form>
        </div>
    </div>
</div>

