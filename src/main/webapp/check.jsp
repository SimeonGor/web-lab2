<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Result</title>

    <link href="style/css/header.css" type="text/css" />
    <link href="style/css/main.css" type="text/css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <main>
        <a href='<c:url value="/controller" />' class="button">Попробовать снова</a>

        <jsp:include page="table.jsp" />
    </main>
</body>
</html>
