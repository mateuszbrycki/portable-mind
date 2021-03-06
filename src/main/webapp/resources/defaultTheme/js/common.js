/**
 * Created by Mateusz Brycki on 02/05/2015.
 */

function refreshBoardTable(data) {

    if (!$('#projects-list').length) {
        return;
    }

    var oldPanelGroup = document.getElementById('panel-group-projects');
    var newPanelGroup = document.createElement('div');
    newPanelGroup.id = 'panel-group-projects';

    if(data.length == 0) {
        var alertDiv = getEmptyAlert(translations['message-project-list-empty']);
        newPanelGroup.appendChild(alertDiv);

        $("#show-add-card-form-button").addClass('disabled');
    } else {
        $("#show-add-card-form-button").removeClass('disabled');
    }

    for(var i = 0; i < data.length; i++){
        var panelDefault = null;
        if(data[i]){
            panelDefault = document.createElement('div');
            panelDefault.className = 'panel panel-default';
            panelDefault.id = 'project-' + data.id;

            var panelHeading = document.createElement('div');
            panelHeading.className = 'panel-heading';

            var panelHeadingH = document.createElement('h4');
            panelHeadingH.className = 'panel-title';

            var panelHeadingHA = document.createElement('a');
            panelHeadingHA.setAttribute('href', ctx + '/project/' + data[i].id);

            var aText = document.createTextNode(data[i].name);

            panelHeadingHA.appendChild(aText);
            panelHeadingH.appendChild(panelHeadingHA);
            panelHeading.appendChild(panelHeadingH);
            panelDefault.appendChild(panelHeading);

            var panelCollapse = document.createElement('div');
            panelCollapse.id = 'collapse' + i;
            panelCollapse.className = 'panel-collapse collapse in';

            var panelBody = document.createElement('div');
            panelBody.className = 'panel-body';

            var projectDescription = document.createTextNode(data[i].description);

            panelBody.appendChild(projectDescription);
            panelCollapse.appendChild(panelBody);

            panelDefault.appendChild(panelCollapse);

            var panelFooter = document.createElement('div');
            panelFooter.className = 'panel-footer clearfix';

            var footerButtons = document.createElement('div');
            footerButtons.className = 'footer-buttons';

            var editButton = document.createElement('button');
            editButton.className = 'edit-project btn btn-primary';
            editButton.type = 'button';
            editButton.setAttribute('href', ctx + url['api_project'] + '/' + data[i].id + '');

            var editGlyphicon = document.createElement('span');
            editGlyphicon.className = 'glyphicon glyphicon-edit';
            var editText = document.createTextNode(' ' + translations['button-edit']);

            editButton.appendChild(editGlyphicon);
            editButton.appendChild(editText);

            var deleteButton = document.createElement('button');
            deleteButton.className = 'delete-project btn btn-danger';
            deleteButton.type = 'button';
            deleteButton.setAttribute('href', ctx + url['api_project'] + '/' + data[i].id);

            var deleteGlyphicon = document.createElement('span');
            deleteGlyphicon.className = 'glyphicon glyphicon-remove';
            var deleteText = document.createTextNode(' ' + translations['button-delete']);

            deleteButton.appendChild(deleteGlyphicon);
            deleteButton.appendChild(deleteText);

            footerButtons.appendChild(editButton);
            footerButtons.appendChild(deleteButton);

            panelFooter.appendChild(footerButtons);

            panelDefault.appendChild(panelFooter);

        }
        newPanelGroup.appendChild(panelDefault);
    }
    oldPanelGroup.parentElement.replaceChild(newPanelGroup, oldPanelGroup);
    
}

function refreshCardList(data) {

    if (!$('#card-list').length) {
        return;
    }
    var oldPanelGroup = document.getElementById('panel-group-cards');
    var newPanelGroup = document.createElement('div');
    newPanelGroup.id = 'panel-group-cards';

    if(data.length == 0) {
        var alertDiv = getEmptyAlert(translations['message-card-list-empty']);
        newPanelGroup.appendChild(alertDiv);
    }

    for(var i = 0; i < data.length; i++){
        var panelDefault = null;
        if(data[i]){
            panelDefault = document.createElement('div');
            panelDefault.className = 'panel panel-default';
            panelDefault.id = 'card-' + data[i].id;

            var panelHeading = document.createElement('div');
            panelHeading.className = 'panel-heading';

            var iconElement = document.createElement('img');
            iconElement.setAttribute('src', data[i].category.icon);
            iconElement.className = 'category-icon';

            var headerString = data[i].category.name;
            if(data[i].name) {
                headerString = data[i].name + " - " + data[i].category.name;
            }

            var pElement = document.createElement('p');
            pElement.className = 'card-title';
            var aText = document.createTextNode(headerString);

            pElement.appendChild(aText);
            panelHeading.appendChild(iconElement);
            panelHeading.appendChild(pElement);
            panelDefault.appendChild(panelHeading);

            var panelCollapse = document.createElement('div');
            panelCollapse.id = 'collapse' + i;
            panelCollapse.className = 'panel-collapse collapse in';

            var panelBody = document.createElement('div');
            panelBody.className = 'panel-body';

            panelBody.innerHTML = data[i].description;
            panelCollapse.appendChild(panelBody);

            panelDefault.appendChild(panelCollapse);

            var panelFooter = document.createElement('div');
            panelFooter.className = 'panel-footer clearfix';

            var footerButtons = document.createElement('div');
            footerButtons.className = 'footer-buttons';

            var editButton = document.createElement('button');
            editButton.className = 'edit-card btn btn-primary';
            editButton.type = 'button';
            editButton.setAttribute('href', ctx + url['api_card'] + '/' + data[i].id);

            var editGlyphicon = document.createElement('span');
            editGlyphicon.className = 'glyphicon glyphicon-edit';
            var editText = document.createTextNode(' ' + translations['button-edit']);

            editButton.appendChild(editGlyphicon);
            editButton.appendChild(editText);

            var deleteButton = document.createElement('button');
            deleteButton.className = 'delete-card btn btn-danger';
            deleteButton.type = 'button';
            deleteButton.setAttribute('href', ctx + url['api_card'] + '/' + data[i].id);

            var deleteGlyphicon = document.createElement('span');
            deleteGlyphicon.className = 'glyphicon glyphicon-remove';
            var deleteText = document.createTextNode(' ' + translations['button-delete']);

            deleteButton.appendChild(deleteGlyphicon);
            deleteButton.appendChild(deleteText);

            footerButtons.appendChild(editButton);
            footerButtons.appendChild(deleteButton);

            panelFooter.appendChild(footerButtons);

            panelDefault.appendChild(panelFooter);
        }
        newPanelGroup.appendChild(panelDefault);
    }
    oldPanelGroup.parentElement.replaceChild(newPanelGroup, oldPanelGroup);

    $('pre code').each(function(i, block) {
        hljs.highlightBlock(block);
    });
}

function refreshCardCategoriesSelect(data) {

    var oldSelectDiv = document.getElementById('add-card-form-category');
    var newSelectDiv = document.createElement('div');
    newSelectDiv.className = 'col-sm-5';
    newSelectDiv.id = 'add-card-form-category';

    var newSelect = document.createElement('select');
    newSelect.className = 'form-control';
    newSelect.name = 'category';

    for(var i = 0; i < data.length; i++){
        var option = document.createElement('option');

        if(data[i]) {
            option.value = data[i].id;
            option.text = data[i].name;
        }

        newSelect.appendChild(option);
    }
    newSelectDiv.appendChild(newSelect);
    oldSelectDiv.parentNode.replaceChild(newSelectDiv, oldSelectDiv);
}

function reloadProjectSelect() {
    $.ajax({
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "GET",
        url:  ctx + url['api_projects'],
        beforeSend: function(xhr) {
            var csrfData = getCSRFRequestHeader();
            xhr.setRequestHeader(csrfData['header'], csrfData['token']);
        },
        success : refreshProjectSelect,
        error : function(){
            console.log(translations['request-failed']);
        }
    });
}

function refreshProjectSelect(data) {
    //TODO mbrycki nie działa

    var oldSelectDiv = document.getElementById('add-card-form-project');
    var newSelectDiv = document.createElement('div');
    newSelectDiv.className = 'col-sm-5';
    newSelectDiv.id = 'add-card-form-project';

    var newSelect = document.createElement('select');
    newSelect.className = 'form-control';
    newSelect.name = 'project';

    for(var i = 0; i < data.length; i++){
        var option = document.createElement('option');

        if(data[i]) {
            option.value = data[i].id;
            option.text = data[i].name;
        }

        newSelect.appendChild(option);
    }
    newSelectDiv.appendChild(newSelect);
    oldSelectDiv.parentNode.replaceChild(newSelectDiv, oldSelectDiv);
}

function reloadCardCategories() {
    $.ajax({
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "GET",
        url:  ctx + url['api_cardCategory'] + '/',
        beforeSend: function(xhr) {
            var csrfData = getCSRFRequestHeader();
            xhr.setRequestHeader(csrfData['header'], csrfData['token']);
        },
        success : refreshCardCategoriesSelect,
        error : function(){
            console.log(translations['request-failed']);
        }
    });
}

function getEmptyAlert(element) {
    var alertDiv = document.createElement('div');
    alertDiv.className = 'alert alert-info';
    alertDiv.setAttribute('role', 'alert');

    alertDiv.appendChild(document.createTextNode(element));

    return alertDiv;
}

function refreshForm(form) {
    //przy dodwaniu nowej karty z poziomu projektu usuwane było id projektu z pola hidden, jeżeli będzie powodowało
    //problemy czyszczenie należy rozbić na różne metody lub ifować
    //form.find("input[type=hidden]").val("");
    form.trigger("reset");
    form.validate().resetForm();
}

function populateEditCardForm(data) {
    var form = document.forms['edit-card-form'];
    form.elements['id'].value = data['id'];
    form.elements['project'].value = data['project']['id'];
    form.elements['category'].value = data['category']['id'];
    form.elements['name'].value = data['name'];
    form.elements['description'].value = data['description'];
}

function populateEditProjectForm(data) {
    var form = document.forms['edit-project-form'];
    form.elements['id'].value = data['id'];
    form.elements['name'].value = data['name'];
    form.elements['description'].value = data['description'];
}

function showAddCardForm() {
    $('#add-card-modal').modal({keyboard: true});
    $("#add-card-modal").modal('show');
}

function showEditCardForm() {
    $('#edit-card-modal').modal({keyboard: true});
    $("#edit-card-modal").modal('show');
}

function showEditProjectForm() {
    $('#edit-project-modal').modal({keyboard: true});
    $("#edit-project-modal").modal('show');
}

function showAddCardCategoryForm() {
    $('#add-project-modal').modal({keyboard: true});
    $("#add-project-modal").modal('show');
}

function getCSRFRequestHeader() {
    var result = new Array();

    result['token'] = $("meta[name='_csrf']").attr("content");
    result['header'] = $("meta[name='_csrf_header']").attr("content");

    return result;
}

function changeLanguage(data) {

    $.ajax({
        contentType: "application/text; charset=utf-8",
        type: "GET",
        url: ctx + "?language=" + data,
        success: function(callback) {
            location.reload();
        },
        error: function (callback) {
            console.log(callback);
        }
    });

}

function addCard(data) {


    if(data.category.id != parameters['category'] && parameters['category'] != null) {
        return;
    }

    var panelGroup = document.getElementById('panel-group-cards');
    if (panelGroup == null) {
        return;
    }

    var panelDefault = document.createElement('div');
    panelDefault.className = 'panel panel-default';
    panelDefault.id = 'card-' + data.id;

    var panelHeading = document.createElement('div');
    panelHeading.className = 'panel-heading';

    var iconElement = document.createElement('img');
    iconElement.setAttribute('src', data.category.icon);
    iconElement.className = 'category-icon';

    var headerString = data.category.name;
    if (data.name) {
        headerString = data.name + " - " + data.category.name;
    }

    var pElement = document.createElement('p');
    pElement.className = 'card-title';
    var aText = document.createTextNode(headerString);

    pElement.appendChild(aText);
    panelHeading.appendChild(iconElement);
    panelHeading.appendChild(pElement);
    panelDefault.appendChild(panelHeading);

    var panelCollapse = document.createElement('div');
    panelCollapse.id = 'collapse-' + data.i;
    panelCollapse.className = 'panel-collapse collapse in';

    var panelBody = document.createElement('div');
    panelBody.className = 'panel-body';

    panelBody.innerHTML = data.description;
    panelCollapse.appendChild(panelBody);

    panelDefault.appendChild(panelCollapse);

    var panelFooter = document.createElement('div');
    panelFooter.className = 'panel-footer clearfix';

    var footerButtons = document.createElement('div');
    footerButtons.className = 'footer-buttons';

    var editButton = document.createElement('button');
    editButton.className = 'edit-card btn btn-primary';
    editButton.type = 'button';
    editButton.setAttribute('href', ctx + url['api_card'] + '/' + data.id);

    var editGlyphicon = document.createElement('span');
    editGlyphicon.className = 'glyphicon glyphicon-edit';
    var editText = document.createTextNode(' ' + translations['button-edit']);

    editButton.appendChild(editGlyphicon);
    editButton.appendChild(editText);

    var deleteButton = document.createElement('button');
    deleteButton.className = 'delete-card btn btn-danger';
    deleteButton.type = 'button';
    deleteButton.setAttribute('href', ctx + url['api_card'] + '/' + data.id);

    var deleteGlyphicon = document.createElement('span');
    deleteGlyphicon.className = 'glyphicon glyphicon-remove';
    var deleteText = document.createTextNode(' ' + translations['button-delete']);

    deleteButton.appendChild(deleteGlyphicon);
    deleteButton.appendChild(deleteText);

    footerButtons.appendChild(editButton);
    footerButtons.appendChild(deleteButton);

    panelFooter.appendChild(footerButtons);

    panelDefault.appendChild(panelFooter);

    panelGroup.appendChild(panelDefault);

    $('pre code').each(function(i, block) {
        hljs.highlightBlock(block);
    });
}

function deleteCard(id) {
    var card = document.getElementById('card-' + id);
    card.remove();
}

function editCard(data) {
    deleteCard(data.id);
    addCard(data);
}

function addProject(data) {

    var panelGroup = document.getElementById('panel-group-projects');

    if(panelGroup != null) {
        panelDefault = document.createElement('div');
        panelDefault.className = 'panel panel-default';
        panelDefault.id = 'project-' + data.id;

        var panelHeading = document.createElement('div');
        panelHeading.className = 'panel-heading';

        var panelHeadingH = document.createElement('h4');
        panelHeadingH.className = 'panel-title';

        var panelHeadingHA = document.createElement('a');
        panelHeadingHA.setAttribute('href', ctx + '/project/' + data.id);

        var aText = document.createTextNode(data.name);

        panelHeadingHA.appendChild(aText);
        panelHeadingH.appendChild(panelHeadingHA);
        panelHeading.appendChild(panelHeadingH);
        panelDefault.appendChild(panelHeading);

        var panelCollapse = document.createElement('div');
        panelCollapse.id = 'collapse' + data.id;
        panelCollapse.className = 'panel-collapse collapse in';

        var panelBody = document.createElement('div');
        panelBody.className = 'panel-body';

        var projectDescription = document.createTextNode(data.description);

        panelBody.appendChild(projectDescription);
        panelCollapse.appendChild(panelBody);

        panelDefault.appendChild(panelCollapse);

        var panelFooter = document.createElement('div');
        panelFooter.className = 'panel-footer clearfix';

        var footerButtons = document.createElement('div');
        footerButtons.className = 'footer-buttons';

        var editButton = document.createElement('button');
        editButton.className = 'edit-project btn btn-primary';
        editButton.type = 'button';
        editButton.setAttribute('href', ctx + url['api_project'] + '/' + data.id + '');

        var editGlyphicon = document.createElement('span');
        editGlyphicon.className = 'glyphicon glyphicon-edit';
        var editText = document.createTextNode(' ' + translations['button-edit']);

        editButton.appendChild(editGlyphicon);
        editButton.appendChild(editText);

        var deleteButton = document.createElement('button');
        deleteButton.className = 'delete-project btn btn-danger';
        deleteButton.type = 'button';
        deleteButton.setAttribute('href', ctx + url['api_project'] + '/' + data.id);

        var deleteGlyphicon = document.createElement('span');
        deleteGlyphicon.className = 'glyphicon glyphicon-remove';
        var deleteText = document.createTextNode(' ' + translations['button-delete']);

        deleteButton.appendChild(deleteGlyphicon);
        deleteButton.appendChild(deleteText);

        footerButtons.appendChild(editButton);
        footerButtons.appendChild(deleteButton);

        panelFooter.appendChild(footerButtons);

        panelDefault.appendChild(panelFooter);


        panelGroup.appendChild(panelDefault);
    }
}

function deleteProject(id) {
    var project = document.getElementById('project-' + id);
    project.remove();
}

function editProject(data) {
    deleteProject(data.id);
    addProject(data);
}

function appendCards(data) {
    for(var i = 0; i < data.length; i++) {
        addCard(data[i]);
    }
}

function getNextPage() {
    
    if (document.getElementById('panel-group-cards') == null) {
        return;
    }

    parameters['page'] = parameters['page'] + 1;

    var requestUrl = ctx + url['api_project'] + "/" + projectId + "/cards";
    var category = false;

    if(parameters['category'] != null) {
        requestUrl += "?category=" + parameters['category'];
        category = true;
    }

    if(parameters['page'] != null) {
        if(category) {
            requestUrl += "&";
        } else {
            requestUrl += "?";
        }
        requestUrl += "page=" + parameters['page'];
    }

    $.ajax({
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "GET",
        url: requestUrl,
        success: function(callback) {
            appendCards(callback);
        },
        error: function() {
            console.log(translations['request-failed']);
        }
    });
}

$(document).ready(function() {
    if($.cookie(languageCookieName)) {
        $('#language-select').val($.cookie(languageCookieName));
    } else {
        $("#language-select").val($("#language-select").val());
    }
    try {
        $("#language-select").msDropDown();
        $("#language-select_msdd").width(80);
    } catch(e) {
        alert(e.message);
    }

    $(document).on('click', '#show-add-card-form', function() {
        if(!$("#show-add-card-form-button").hasClass("disabled")) {
            showAddCardForm();
        }
    });

    $(document).on('click', '#show-add-project-form', function() {
        showAddCardCategoryForm();
    });

    $(document).on('submit', '#add-project-form', function(e) {
        var frm = $('#add-project-form');
        e.preventDefault();

        var data = {};
        $.each(this, function(i, v){
            var input = $(v);
            data[input.attr("name")] = input.val();
            delete data["undefined"];
        });

        if(frm.valid()) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: JSON.stringify(data),
                beforeSend: function(xhr) {
                    var csrfData = getCSRFRequestHeader();
                    xhr.setRequestHeader(csrfData['header'], csrfData['token']);
                },
                success: function(callback) {
                    reloadProjectSelect();
                    addProject(callback);
                },
                error: function (callback) {
                    console.log(translations['request-failed']);
                }
            });
            refreshForm(frm);
            $("#add-project-modal").modal('hide');
        }
    });

    $(document).on('submit', '#edit-project-form', function(e) {
        var frm = $('#edit-project-form');
        e.preventDefault();

        var data = {};

        $.each(this, function(i, v){
            var input = $(v);
            data[input.attr("name")] = input.val();
            delete data["undefined"];
        });

        data["id"] = parseInt(data["id"]);

        if(frm.valid()) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: JSON.stringify(data),
                beforeSend: function(xhr) {
                    var csrfData = getCSRFRequestHeader();
                    xhr.setRequestHeader(csrfData['header'], csrfData['token']);
                },
                success: function(callback) {
                    editProject(callback);
                },
                error: function (callback) {
                    console.log(translations['request-failed']);
                }
            });

            refreshForm(frm);
            $("#edit-project-modal").modal('hide');
        }
    });

    $(document).on('submit', '#add-card-form', function(e) {
        var frm = $('#add-card-form');
        e.preventDefault();

        var data = {};

        $.each(this, function(i, v){
            var input = $(v);
            data[input.attr("name")] = input.val();
            delete data["undefined"];
        });

        data["project"] = parseInt(data["project"]);
        data["category"] = parseInt(data["category"]);

        if(frm.valid()) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: JSON.stringify(data),
                beforeSend: function(xhr) {
                    var csrfData = getCSRFRequestHeader();
                    xhr.setRequestHeader(csrfData['header'], csrfData['token']);
                },
                success: function(callback) {
                    addCard(callback);
                },
                error: function (callback) {
                    console.log(translations['request-failed']);
                }
            });

            refreshForm(frm);
            $("#add-card-modal").modal('hide');
        }
    });

    $(document).on('submit', '#edit-card-form', function(e) {
        var frm = $('#edit-card-form');
        e.preventDefault();

        var data = {};

        $.each(this, function(i, v){
            var input = $(v);
            data[input.attr("name")] = input.val();
            delete data["undefined"];
        });

        data["project"] = parseInt(data["project"]);
        data["category"] = parseInt(data["category"]);

        if(frm.valid()) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: JSON.stringify(data),
                beforeSend: function(xhr) {
                    var csrfData = getCSRFRequestHeader();
                    xhr.setRequestHeader(csrfData['header'], csrfData['token']);
                },
                success: function(callback) {
                    editCard(callback);
                },
                error: function (callback) {
                    console.log(translations['request-failed']);
                }
            });

            refreshForm(frm);
            $("#edit-card-modal").modal('hide');
        }
    });

    $(document).on('click', '.delete-card', function(e) {
        e.preventDefault();

        $.ajax({
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "DELETE",
            url:  ctx + $(this).attr('href'),
            beforeSend: function(xhr) {
                var csrfData = getCSRFRequestHeader();
                xhr.setRequestHeader(csrfData['header'], csrfData['token']);
            },
            success : function(callback) {
                deleteCard(callback);
            },
            error : function (callback) {
                console.log(translations['request-failed']);
            }
        });
    });

    $(document).on('click', '.delete-project', function(e) {
        e.preventDefault();

        $.ajax({
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "DELETE",
            url: $(this).attr('href'),
            beforeSend: function(xhr) {
                var csrfData = getCSRFRequestHeader();
                xhr.setRequestHeader(csrfData['header'], csrfData['token']);
            },
            success: function(callback) {
                reloadProjectSelect();
                deleteProject(callback);
            },
            error: function (callback) {
                console.log("Request failed.");
            }
        });
    });

    $(document).on('click', '.edit-card', function(e) {
        e.preventDefault();
        $.ajax({
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "GET",
            url: ctx + $(this).attr('href'),
            beforeSend: function(xhr) {
                var csrfData = getCSRFRequestHeader();
                xhr.setRequestHeader(csrfData['header'], csrfData['token']);
            },
            success: function(callback) {
                populateEditCardForm(callback);
                showEditCardForm();
            },
            error: function() {
                console.log(translations['request-failed']);
            }
        });
    });

    $(document).on('click', '.edit-project', function(e) {
        e.preventDefault();
        $.ajax({
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "GET",
            url: ctx + $(this).attr('href'),
            beforeSend: function(xhr) {
                var csrfData = getCSRFRequestHeader();
                xhr.setRequestHeader(csrfData['header'], csrfData['token']);
            },
            success: function(callback) {
                populateEditProjectForm(callback);
                showEditProjectForm();
            },
            error: function() {
                console.log(translations['request-failed']);
            }
        });
    });

    $(document).on('change', '#category-filter-select', function() {
        var value = this.value;

        var requestUrl = ctx + url['api_project'] + "/" + projectId + "/cards";
        if(value != 0) {
            parameters['category'] = value;
            requestUrl += "?category=" + value;
        } else {
            parameters['category'] = null;
        }

        $.ajax({
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "GET",
            url: requestUrl,
            success: function (callback) {
                refreshCardList(callback);
                parameters['page'] = 0;
            },
            error: function () {
                console.log(translations['request-failed']);
            }
        });
    });

    $(document).on('click', '.add-card-form-close', function() {
        refreshForm($('#add-card-form'));
        $("#add-card-modal").modal('hide');
    });

    $(document).on('click', '.add-card-category-form-close', function() {
        refreshForm($('#add-card-category-form'));
        $("#add-card-category-modal").modal('hide');
    });

    $(document).on('click', '.edit-card-form-close', function() {
        refreshForm($('#edit-card-form'));
        $("#edit-card-modal").modal('hide');
    });

    $(document).on('click', '.edit-project-form-close', function() {
        refreshForm($('#edit-project-form'));
        $("#edit-project-modal").modal('hide');
    });

    $('#add-card-form').validate( {
        rules:
        {
            project:
            {
                required: true
            },
            category:
            {
                required: true,
                number: true
            },
            name:
            {
                required: true,
                minlength: 5
            },
            description:
            {
                required: true,
                minlength: 5
            }
        }
    });

    $('#edit-card-form').validate( {
        rules:
        {
            project:
            {
                required: true,
                number: true
            },
            category:
            {
                required: true,
                number: true
            },
            name:
            {
                required: true,
                minlength: 5
            },
            description:
            {
                required: true,
                minlength: 5
            }
        }
    });

    $('#add-project-form').validate( {
        rules:
        {
            name:
            {
                required: true,
                minlength: 5
            },
            description:
            {
                required: true,
                minlength: 5
            }
        }
    });

    $('#edit-project-form').validate( {
        rules:
        {
            name:
            {
                required: true,
                minlength: 5
            },
            description:
            {
                required: true,
                minlength: 5
            }
        }
    });

    $('#user-register-form').validate( {
        rules:
        {
            mail:
            {
                required: true,
                email: true
            },
            password:
            {
                required: true,
                minlength:3
            },
            password_repeat:
            {
                required: true,
                minlength:3
            }
        }
    });

    $(window).scroll(function() {
        if($(window).scrollTop() + $(window).height() == $(document).height()) {
            getNextPage();
        }
    });
});
