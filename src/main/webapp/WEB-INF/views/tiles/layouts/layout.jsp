<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <link href="/static/css/app.css" rel="stylesheet">
</head>

<header>
    <tiles:insertAttribute name ="header"/>
</header>

<body>
<tiles:insertAttribute name ="body"/>



<tiles:insertAttribute name="footer"/>
</body>
</html>
