/**
 * Created by Mateusz Brycki on 02/05/2015.
 */

function refreshBoardTable(data) {

    if (!$('#projects-list').length) {
        return;
    }

    var oldPanelGroup = document.getElementById('panel-group');
    var newPanelGroup = document.createElement('div');
    newPanelGroup.id = 'panel-group';

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
            editButton.setAttribute('href', ctx + '/project/' + data[i].id + '/entity');

            var editGlyphicon = document.createElement('span');
            editGlyphicon.className = 'glyphicon glyphicon-edit';
            var editText = document.createTextNode(' ' + translations['button-edit']);

            editButton.appendChild(editGlyphicon);
            editButton.appendChild(editText);

            var deleteButton = document.createElement('button');
            deleteButton.className = 'delete-project btn btn-danger';
            deleteButton.type = 'button';
            deleteButton.setAttribute('href', ctx + '/project/' + data[i].id);

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
    SyntaxHighlighter.all();
}

function refreshCardList(data) {

    if (!$('#card-list').length) {
        return;
    }
    var oldPanelGroup = document.getElementById('panel-group');
    var newPanelGroup = document.createElement('div');
    newPanelGroup.id = 'panel-group';

    if(data.length == 0) {
        var alertDiv = getEmptyAlert(translations['message-card-list-empty']);
        newPanelGroup.appendChild(alertDiv);
    }

    for(var i = 0; i < data.length; i++){
        var panelDefault = null;
        if(data[i]){
            panelDefault = document.createElement('div');
            panelDefault.className = 'panel panel-default';

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

            var projectDescription = document.createTextNode(data[i].description);

            panelBody.appendChild(projectDescription);
            panelCollapse.appendChild(panelBody);

            panelDefault.appendChild(panelCollapse);

            var panelFooter = document.createElement('div');
            panelFooter.className = 'panel-footer clearfix';

            var footerButtons = document.createElement('div');
            footerButtons.className = 'footer-buttons';

            var editButton = document.createElement('button');
            editButton.className = 'edit-card btn btn-primary';
            editButton.type = 'button';
            editButton.setAttribute('href', ctx + '/card/' + data[i].id);

            var editGlyphicon = document.createElement('span');
            editGlyphicon.className = 'glyphicon glyphicon-edit';
            var editText = document.createTextNode(' ' + translations['button-edit']);

            editButton.appendChild(editGlyphicon);
            editButton.appendChild(editText);

            var deleteButton = document.createElement('button');
            deleteButton.className = 'delete-card btn btn-danger';
            deleteButton.type = 'button';
            deleteButton.setAttribute('href', ctx + '/card/' + data[i].id);

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

    SyntaxHighlighter.all();
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
    SyntaxHighlighter.all();
}

function refreshProjectSelect(data) {

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
    SyntaxHighlighter.all();
}

function reloadCardCategories() {
    $.ajax({
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        type: "GET",
        url:  ctx + "/cardCategories",
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

    alertDiv.appendChild(document.createTextNode("You don't have any " + element + "."));

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

$(document).ready(function() {
    $('#language-select').val($.cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE"));

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
            description:
            {
                required: true,
                minlength:5
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

    $('#add-project-form').validate( {
        rules:
        {
            name:
            {
                required: true,
                minlength:5
            },

            description:
            {
                required: true,
                minlength:5
            }
        }
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
                    refreshProjectSelect(callback);
                    refreshBoardTable(callback);
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
                    refreshProjectSelect(callback);
                    refreshBoardTable(callback);
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
                    refreshCardList(callback);
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
                    refreshCardList(callback);
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
                refreshCardList(callback)
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
                refreshProjectSelect(callback);
                refreshBoardTable(callback);
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
});