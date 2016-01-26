<%@ include file="../fragments/definitions.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <tiles:insertAttribute name="pageHeader"/>
    <tiles:insertAttribute name="pageCss"/>
    <tiles:insertAttribute name="pageJs"/>
</head>
<body>
    <tiles:importAttribute name="pageMenu"/>
    <tiles:insertAttribute name="pageDisplayName"/>
    <tiles:insertAttribute name="pageBody"/>
</body>
</html>
