<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><spring:message code="portablemind" /></title>
    <link rel="shortcut icon" type="image/png" href="<c:url value="/resources/img/favicon.ico" />" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap_3_2_0_min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/msdropdown_dd.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-glyphicons.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/shCore.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/shThemeEclipse.css" />"/>

    <script>var ctx = "${pageContext.request.contextPath}";</script>
    <script>
      var translations = {
        'button-edit': "<spring:message code="button.edit" />",
        'button-delete': "<spring:message code="button.delete" />",
        'message-project-list-empty': "<spring:message code="message.project.list.empty" />",
        'message-card-list-empty':"<spring:message code="message.card.list.empty" />",
        'request-failed': "<spring:message code="request.failed" />"
      };
    </script>

    <script src="<c:url value="/resources/js/jquery_1_11_1_min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap_3_2_0_min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery_msdropdown_dd.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery_cookie_1_4_1.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery_validate_1_12_0_min.js" />"></script>
    <script src="<c:url value="/resources/js/common.js" />" type="text/javascript"></script>

    <script src="<c:url value="/resources/js/shCore.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/shBrushPhp.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/shBrushSql.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/shBrushJava.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/shBrushJScript.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/shBrushPowerShell.js" />" type="text/javascript"></script>

    <script type="text/javascript">
      SyntaxHighlighter.all();
    </script>
</head>

<body>
