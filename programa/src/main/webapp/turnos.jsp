<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head><title> Listar turnos</title></head>

<body>

<div class="container">
    <h2>Listado de Turnos</h2>

    <form action="<c:url value='/buscarTurnos'/>" method="post" class="form-inline">
        <label>Estado:</label>
        <select name="estado">
            <option value="">-- Todos --</option>
            <option value="EN_ESPERA">En Espera</option>
            <option value="YA_ATENDIDO">Ya Atendido</option>
            <button> </button>
        </select>

        <label>Fecha:</label>
        <input type="date" name="fecha">

        <button type="submit" class="btn">Filtrar</button>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th>ID Prog.</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Ciudadano</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="{listaTurnos}">
            <tr>
                <td>{t.identificadorProgresivo}</td>
                <td>{t.fecha}</td>
                <td>{t.estadoTurno}</td>
                <td>{t.ciudadano.nombre}</td>
                <td>{t.ciudadano.dni}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
