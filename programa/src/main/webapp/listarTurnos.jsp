<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Listado de Turnos</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<div class="container">
    <h1>Listado de Turnos</h1>

    <table class="table">
        <thead>
        <tr>
            <th>ID Progresivo</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Ciudadano</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="turno" items="${turnos}">
            <tr>
                <td>${turno.identificadorProgresivo}</td>
                <td>${turno.fecha}</td>
                <td>${turno.estadoTurno}</td>
                <td>${turno.ciudadano.nombre}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
