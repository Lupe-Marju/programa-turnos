<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Listado de Turnos</title>
    <style>
        /*Tu CSS azul-celeste ya incluido aquí*/
        body { font-family: Arial, sans-serif; background:#f0f8ff; margin:0; padding:0; }
        header { background:#003366; color:white; padding:15px; text-align:center; }
        h1 { margin:0; }
        .container { max-width:900px; margin:30px auto; background:#fff; border:2px solid #00bfff; border-radius:10px; padding:20px; box-shadow:0 0 10px rgba(0,0,0,0.1);}
        form { margin-bottom:20px; }
        label { font-weight:bold; margin-right:10px; color:#003366; }
        select, input[type="date"], input[type="submit"] {
            padding:5px 8px; border:1px solid #00bfff; border-radius:5px; font-size:14px;
        }
        input[type="submit"] {
            background:#00bfff; color:#fff; font-weight:bold; cursor:pointer; transition:0.3s;
        }
        input[type="submit"]:hover { background:#009acd; }
        table { width:100%; border-collapse:collapse; margin-top:10px; }
        th, td { border:1px solid #00bfff; padding:8px; text-align:center; }
        th { background:#003366; color:#fff; }
        tr:nth-child(even) { background:#f2faff; }
        .add-button {
            display:inline-block; margin-top:10px; padding:8px 12px; background:#00bfff; color:#fff;
            border-radius:5px; text-decoration:none; font-weight:bold; transition:0.3s;
        }
        .add-button:hover { background:#009acd; }
    </style>
</head>
<body>
<header>
    <h1>Gestión de Turnos</h1>
</header>

<div class="container">
    <h2>Turnos Registrados</h2>

    <form action="buscarTurnos" method="get">
        <label for="estado">Filtrar por Estado:</label>
        <select name="estado" id="estado">
            <option value="" <c:if test="${empty param.estado}">selected</c:if>>-- Todos --</option>
            <option value="EN_ESPERA" <c:if test="${param.estado == 'EN_ESPERA'}">selected</c:if>>En Espera</option>
            <option value="YA_ATENDIDO" <c:if test="${param.estado == 'YA_ATENDIDO'}">selected</c:if>>Ya Atendido</option>
        </select>

        <label for="fecha">Filtrar por Fecha:</label>
        <input type="date" name="fecha" id="fecha" value="${param.fecha != null ? param.fecha : ''}" />

        <input type="submit" value="Filtrar" />
    </form>

    <table>
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
                    <td><c:out value="${turno.identificadorProgresivo}" /></td>
                    <td><c:out value="${turno.fecha}" /></td>
                    <td><c:out value="${turno.estadoTurno}" /></td>
                    <td><c:out value="${turno.ciudadano.nombre}" /></td>
                </tr>
            </c:forEach>
            <c:if test="${empty turnos}">
                <tr>
                    <td colspan="4">No hay turnos disponibles</td>
                </tr>
            </c:if>
        </tbody>
    </table>
    <a class="add-button" href="agregarturno"> Agregar turno</a>

    <a class="add-button" href="index.jsp"> Volver al inicio </a>
</div>
</body>
</html>
