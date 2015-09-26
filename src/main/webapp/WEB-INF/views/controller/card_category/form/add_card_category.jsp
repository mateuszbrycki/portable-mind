<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="add-card-category-modal" class="modal fade" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close add-card-category-form-close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"><spring:message code="cardcategory.modal.title.add" /></h4>
      </div>
      <form method="PUT" id="add-card-category-form" action="${pageContext.request.contextPath}/cardCategory" class="form-horizontal"  enctype="multipart/form-data">
        <div class="modal-body">
          <div class="form-group">
            <label class="control-label col-sm-3" for="cardCategoryName"><spring:message code="cardcategory.modal.name" />:</label>
            <div class="col-sm-5">
              <input type="text" name="name" class="form-control"/>
            </div>
          </div>

          <div class="form-group">
            <label class="control-label col-sm-3" for="cardCategoryIcon"><spring:message code="cardcategory.modal.icon" />:</label>
            <div class="col-sm-5">
              <input type="file" name="file" class="form-control"/>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default add-card-category-form-close" data-dismiss="modal"><spring:message code="button.close" /></button>
          <input type="submit" id="add-card-category-submit" value="<spring:message code="cardcategory.button.add" />" class="btn btn-primary"/>
        </div>
      </form>
    </div>
  </div>
</div>

