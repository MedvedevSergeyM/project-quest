<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quest</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<form method="post" action="/play">

  <h4>${situation.getText()}</h4>
  <br>
  <c:forEach var = "i" begin = "0" end = "${situation.getOptions().size() - 1}">
    <div class="form-check">
      <input class="form-check-input" type="radio" name="option" id="${situation.getOptions().get(i).getId()}" value="${situation.getOptions().get(i).getId()}">
      <label class="form-check-label" for="${situation.getOptions().get(i).getId()}">
          ${situation.getOptions().get(i).getText()}
      </label>
    </div>
    <br>
  </c:forEach>
  <br>
  <button type="submit" class="btn btn-primary">Ответить</button>

</form>

<br>
<table>
  <tr><td><b>Статистика:</b></td></tr>
  <tr><td>IP address: ${ipAddress}</td></tr>
  <tr><td>Имя в игре: ${user.getName()}</td></tr>
  <tr><td>Количество побед: ${user.getWinsCount()}</td></tr>
  <tr><td>Количество поражений: ${user.getLossesCount()}</td></tr>
</table>

</body>
</html>
