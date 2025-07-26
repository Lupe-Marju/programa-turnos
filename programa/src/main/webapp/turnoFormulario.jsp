<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.example.entities.Ciudadano" %>
<html>
<head>
<title> Formulario turnos</title>
</head>
<body>
<h1> Agregar un turno</h1>
<h2> Formulario </h2>
<form action="agregarturno" method="post">
    <label for="ciudadano">Ciudadano</label>
    <select name="ciudadanoId" id="ciudadano" required>
        <option value="" disabled selected>Seleccione una opción</option>
        <!-- Iterar los nombres de las personas-->
        <% List<Ciudadano> listado = (List<Ciudadano>)request.getAttribute("listado");
        for (Ciudadano ciudadano: listado) { %>
        <option value="<%= ciudadano.getId() %>"> <%= ciudadano.getNombre()%>  <%= ciudadano.getDni()%> </option>
        <% } %>
    </select><br>
    <label for="estadoTurno">Estado del turno</label>
    <select name="estado" id="estadoTurno" required>
        <option value="" disabled selected>Seleccione una opción</option>
        <option value="EN_ESPERA">En espera</option>
        <option value="YA_ATENDIDO">Ya atendido</option>
    </select> <br>
    <input type="submit" value="Agregar">
</form>
</body>
</html>