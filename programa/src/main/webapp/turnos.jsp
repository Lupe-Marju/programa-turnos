<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Turnos</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<header>
    <h1>Listado de Turnos</h1>
</header>

<main>
    <form method="get" action="turnos" style="margin-bottom: 20px;">
        <label for="estado">Filtrar por Estado:</label>
        <select name="estado" id="estado">
            <option value="">-- Todos --</option>
            <option value="EN_ESPERA">En espera</option>
            <option value="YA_ATENDIDO">Ya atendido</option>
        </select>

        <label for="fecha">Filtrar por Fecha:</label>
        <input type="date" name="fecha" id="fecha">

        <button type="submit">Filtrar</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse; width: 100%;">
        <thead>
        <tr style="background-color: #1E3A8A; color: white;">
            <th>ID</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Ciudadano</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="${listadoTurnos}">
            <tr>
                <td>${t.identificadorProgresivo}</td>
                <td>${t.fecha}</td>
                <td>${t.estadoTurno}</td>
                <td>${t.ciudadano.nombre}</td>
            </tr>
        </c:forEach>
        <c:if test="${empty listadoTurnos}">
            <tr>
                <td colspan="4" style="text-align: center;">No hay turnos disponibles.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</main>
</body>
</html>