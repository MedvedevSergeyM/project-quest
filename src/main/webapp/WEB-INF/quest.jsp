<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Quest</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

    <c:set var = "quest" scope = "session" value = "${requestScope.quest}"/>

    <h3>${quest.question}</h3>

</body>
</html>
