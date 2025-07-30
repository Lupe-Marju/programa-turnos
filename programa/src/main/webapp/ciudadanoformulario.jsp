<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Ciudadano</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css">
</head>
<body>
<header>
    <h1>Gestión de Turnos</h1>
</header>
<div class="container">
    <h2 class="page-title">Formulario de Ciudadano</h2>
    <form action="agregarciudadano" method="post" class="styled-form">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" required>
        </div>

        <div class="form-group">
            <label for="dni">DNI:</label>
            <input type="text" name="dni" required>
        </div>

        <button type="submit" class="add-button">Guardar</button>
    </form>
    <div class="corner-buttons">
        <a class="add-button" href="index.jsp">Volver al inicio</a>
    </div>
</body>
</html>
