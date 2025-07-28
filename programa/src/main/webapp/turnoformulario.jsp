<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.example.entities.Ciudadano, java.time.LocalDate" %>

<html>
<head>
    <title>Agregar Turno</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #003366;
            color: white;
            padding: 15px;
            text-align: center;
        }
        h1 {
            margin: 0;
        }
        .container {
            max-width: 600px;
            margin: 30px auto;
            background: white;
            border: 2px solid #00bfff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
            color: #003366;
        }
        select, input[type="date"], input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #00bfff;
            border-radius: 5px;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #00bfff;
            color: white;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #009acd;
        }
        .no-data {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
        a {
            display: inline-block;
            margin-top: 10px;
            color: #003366;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<header>
    <h1>Gestión de Turnos</h1>
</header>

<div class="container">
    <h2>Agregar un Turno</h2>
    <form action="agregarturno" method="post">
        <!-- Ciudadano -->
        <label for="ciudadano">Ciudadano</label>
        <select name="ciudadanoId" id="ciudadano" required>
            <option value="" disabled selected>Seleccione un ciudadano</option>
            <%
                List<Ciudadano> listado = (List<Ciudadano>) request.getAttribute("listado");
                if (listado != null && !listado.isEmpty()) {
                    for (Ciudadano ciudadano : listado) {
            %>
                        <option value="<%= ciudadano.getId() %>">
                            <%= ciudadano.getNombre() %> (<%= ciudadano.getDni() %>)
                        </option>
            <%
                    }
                } else {
            %>
                <option disabled>No hay ciudadanos disponibles</option>
            <%
                }
            %>
        </select>

        <!-- Estado del Turno -->
        <label for="estadoTurno">Estado del turno</label>
        <select name="estado" id="estadoTurno" required>
            <option value="" disabled selected>Seleccione el estado</option>
            <option value="EN_ESPERA">En espera</option>
            <option value="YA_ATENDIDO">Atendido</option>
        </select>

        <!-- Fecha -->
        <label for="fechaTurno">Fecha</label>
        <input type="date" min="<%= LocalDate.now() %>" name="fecha" id="fechaTurno" required>

        <input type="submit" value="Agregar Turno">
    </form>
    <a class="add-button" href="index.jsp"> Volver al inicio </a>
</div>
</body>
</html>

