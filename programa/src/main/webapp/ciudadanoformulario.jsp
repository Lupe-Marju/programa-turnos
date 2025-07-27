<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title> Formulario ciudadanos</title>
</head>
<body>
<h1> Agregar un ciudadano</h1>
<h2> Formulario </h2>
<form action="agregarciudadano" method="post">
    Nombre: <input type="text" name="nombre" required><br>
    DNI: <input type="text" name="dni" required><br>
    <input type="submit" value="Agregar">
</form>
</body>
</html>
