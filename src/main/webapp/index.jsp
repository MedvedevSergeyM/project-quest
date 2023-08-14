<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
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

<h1>Пролог</h1>
<p>
    Ты стоишь в космическом порту и готов подняться на борт<br>
    своего корабля. Разве ты не об этом мечтал? Стать капитаном<br>
    галактического судна с экипажем, который будет совершать<br>
    подвиги под твоим командованием.<br>
   Так что вперед!
</p>

<h1>Знакомство с экипажем</h1>
<p>
    Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:<br>
    - Здравствуйте, командир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе<br>
    наш штурман - сержант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан.<br>
    А как обращаться к вам?
</p>

<form method="post" action="/start">

    <table>
        <tr>
            <td>
                <input type="text" name="user_name" id="user_name" class="form-control form-control-sm">
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <button type="submit" class="btn btn-primary">Представиться</button>
            </td>
        </tr>
    </table>

</form>

</body>
</html>