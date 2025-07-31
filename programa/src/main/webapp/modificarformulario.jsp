<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.entities.Ciudadano" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Modificar Turno</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css">
</head>
<body>
<header>
    <h1>Gestión de Turnos</h1>
</header>

<div class="container">
    <h2 class="page-title">Modificar Turno</h2>
    <form action="modificarturno" method="post">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <label for="fecha">Fecha:</label>
        <input type="date" name="fecha" value="<%= request.getAttribute("fecha")%>" readonly>

        <label for="estado">Estado:</label>
        <select name="estado" required>
            <option value="EN_ESPERA">En espera</option>
            <option value="YA_ATENDIDO">Ya atendido</option>
        </select>

        <label> Ciudadano:</label>
        <input type="text" name="nombre" value="<%= request.getAttribute("nombre") %>" readonly>

        <label>Numero de turno:</label>
        <input type="text" name="identificador" value="<%= request.getAttribute("identificador") %>" readonly>
        <label>Descripcion:</label>
        <input type="text" name="descripcion" value="<%= request.getAttribute("descripcion") %>" readonly>

        <input class="add-button" type="submit" value="Modificar estado">
    </form>
    <a class="add-button" href="index.jsp">Volver al inicio</a>

</div>
</body>
</html>
