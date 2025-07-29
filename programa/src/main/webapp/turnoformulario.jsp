<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.entities.Ciudadano" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Turno</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css">
</head>
<body>
<header>
    <h1>Gestión de Turnos</h1>
    </header>
<div class="container">
    <h2 class="page-title">Formulario de Turno</h2>
    <form action="agregarturno" method="post">
        <label for="estado">Estado:</label>
        <select name="estado" required>
            <option value="EN_ESPERA">En espera</option>
            <option value="YA_ATENDIDO">Ya atendido</option>
        </select>

        <label for="fecha">Fecha:</label>
        <input type="date" name="fecha" required>

        <label for="ciudadanoId">Ciudadano:</label>
        <select name="ciudadanoId" required>
            <%
                List<Ciudadano> listado = (List<Ciudadano>) request.getAttribute("listado");
                if (listado != null) {
                    for (Ciudadano c : listado) {
            %>
            <option value="<%= c.getId() %>"><%= c.getNombre() %> - <%= c.getDni() %></option>
            <%
                    }
                }
            %>
        </select>

    </form>
    <a class="add-button" href="agregarturno">Guardar Turno</a>
    <a class="add-button" href="index.jsp">Volver al inicio</a>

</div>
</body>
</html>
