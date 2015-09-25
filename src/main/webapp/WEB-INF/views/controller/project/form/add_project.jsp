<div id="add-project-modal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close add-project-form-close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Add new project</h4>
      </div>
      <form method="PUT" id="add-project-form" action="${pageContext.request.contextPath}/project" class="form-horizontal">
        <div class="modal-body">
            <div class="form-group">
              <label class="control-label col-sm-3" for="projectName">Name: </label>
              <div class="col-sm-5">
                <input type="text" name="name" class="form-control"/>
              </div>
            </div>

            <div class="form-group">
              <label class="control-label col-sm-3" for="projectDescription">Description:</label>
              <div class="col-sm-5">
                <textarea type="text" name="description" class="form-control" rows="6"></textarea>
              </div>
            </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default add-project-form-close" data-dismiss="modal">Close</button>
          <input type="submit" id="add-project-submit" value="Add project" class="btn btn-primary"/>
        </div>
      </form>
    </div>
  </div>
</div>

