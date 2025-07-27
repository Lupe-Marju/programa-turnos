<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.example.entities.Ciudadano, java.time.LocalDate" %>
<html>
<head>
    <title> Formulario turnos</title>
</head>
<body>
<h1> Agregar un turno</h1>
<h2> Formulario turnos </h2>
<form action="agregarturno" method="post">
    <!-- Elegir al ciudadano-->
    <label for="ciudadano">Ciudadano</label>
    <select name="ciudadanoId" id="ciudadano" required>
        <option value="" disabled selected>Seleccione una opción</option>
        <!-- Iterar los nombres de los ciudadanos-->
        <% List<Ciudadano> listado = (List<Ciudadano>)request.getAttribute("listado");
        if (listado != null) {
                for (Ciudadano ciudadano: listado) { %>
                <option value="<%= ciudadano.getId() %>"> <%= ciudadano.getNombre()%> (<%= ciudadano.getDni()%>) </option>
                <% }
        } else {
        %>
        <option disabled> No hay ciudadanos disponibles</option>
        <%
            }
        %>
    </select><br>
    <!-- Elegir el estado del turno-->
    <label for="estadoTurno">Estado del turno</label>
    <select name="estado" id="estadoTurno" required>
        <option value="" disabled selected>Seleccione una opción</option>
        <option value="EN_ESPERA">En espera</option>
        <option value="YA_ATENDIDO">Atendido</option>
    </select> <br>
    <!-- Elegir la fecha del turno-->
    <label for="fechaTurno"> Fecha </label>
    <input type="date" min="<%=LocalDate.now()%>" name="fecha" id="fechaTurno" required><br>
    <input type="submit" value="Agregar Turno">
</form>
</body>
</html>