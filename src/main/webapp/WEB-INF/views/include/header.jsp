<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Portable Mind</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap_3_2_0_min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-glyphicons.css" />">

    <script src="<c:url value="/resources/js/jquery_1_11_1_min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap_3_2_0_min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery_validate_1_12_0_min.js" />"></script>
    <script src="<c:url value="/resources/js/common.js" />" type="text/javascript"></script>

    <script>var ctx = "${pageContext.request.contextPath}"</script>
</head>

<body>