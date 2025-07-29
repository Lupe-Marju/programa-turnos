<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.entities.Turno" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.enums.EstadoTurno" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Turnos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css">
</head>
<body>
<header>
    <h1>Gestión de Turnos</h1>
</header>
<div class="container">
    <h2 class="page-title">Listado de Turno</h2>
    <form method="get" action="buscarTurnos">
        <label for="estado">Estado:</label>
        <select name="estado" id="estado">
            <option value="">Todos</option>
            <option value="EN_ESPERA" <%= "EN_ESPERA".equals(request.getParameter("estado")) ? "selected" : "" %>>En espera</option>
            <option value="YA_ATENDIDO" <%= "YA_ATENDIDO".equals(request.getParameter("estado")) ? "selected" : "" %>>Ya atendido</option>
        </select>

        <label for="fecha">Fecha:</label>
        <input type="date" name="fecha" id="fecha" value="<%= request.getParameter("fecha") != null ? request.getParameter("fecha") : "" %>">

        <button type="submit">Filtrar</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Turno</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Ciudadano</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Turno> turnos = (List<Turno>) request.getAttribute("turnos");
            if (turnos != null && !turnos.isEmpty()) {
                for (Turno t : turnos) {
        %>
        <tr>
            <td><%= t.getIdentificadorProgresivo() %></td>
            <td><%= t.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %></td>
            <td>
                <%
                String estado = t.getEstadoTurno().name().replace("_", " ").toLowerCase();
                out.print(Character.toUpperCase(estado.charAt(0)) + estado.substring(1));
                %>
            </td>
            <td><%= t.getCiudadano().getNombre() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No hay turnos disponibles</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a class="add-button" href="agregarturno">Agregar Turno</a>
    <a class="add-button" href="index.jsp">Volver al inicio</a>
</div>
</body>
</html>
