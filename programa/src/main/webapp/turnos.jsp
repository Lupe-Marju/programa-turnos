<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Listado de Turnos</title>
</head>
<body>
<h1>Turnos Registrados</h1>

<form action="buscarTurnos" method="get">
    Filtrar por Estado:
    <select name="estado">
        <option value="">-- Todos --</option>
        <option value="EN_ESPERA">En Espera</option>
        <option value="YA_ATENDIDO">Ya Atendido</option>
    </select>

    Filtrar por Fecha:
    <input type="date" name="fecha" />

    <input type="submit" value="Filtrar" />
</form>

<table border="1" cellpadding="5" cellspacing="0">
    <thead>
        <tr>
            <th>ID Progresivo</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Ciudadano</th>
            <th>Descripción</th> <!-- agregar si tienes descripción -->
        </tr>
    </thead>
    <tbody>
    <c:forEach var="turno" items="${turnos}">
        <tr>
            <td>${turno.identificadorProgresivo}</td>
            <td>${turno.fecha}</td>
            <td>${turno.estadoTurno}</td>
            <td>${turno.ciudadano.nombre}</td>
            <!-- <td>${turno.descripcion}</td> Si tienes descripción -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>