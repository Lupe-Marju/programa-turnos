<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Formulario Ciudadanos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff; /* celeste muy suave */
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #003366; /* azul oscuro */
            color: white;
            padding: 15px;
            text-align: center;
        }
        h1, h2 {
            margin: 10px 0;
            color: #003366;
            text-align: center;
        }
        .container {
            max-width: 500px;
            margin: 30px auto;
            background: white;
            border: 2px solid #00bfff; /* celeste */
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            font-weight: bold;
            color: #003366;
            margin-top: 10px;
        }
        input[type="text"] {
            padding: 8px;
            border: 1px solid #00bfff;
            border-radius: 5px;
            font-size: 14px;
            margin-top: 5px;
        }
        input[type="submit"] {
            margin-top: 20px;
            background-color: #00bfff;
            color: white;
            font-weight: bold;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #009acd;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            color: #003366;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<header>
    <h1>Gestión de Ciudadanos</h1>
</header>

<div class="container">
    <h2>Agregar un ciudadano</h2>
    <form action="agregarciudadano" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="dni">DNI:</label>
        <input type="text" id="dni" name="dni" required>

        <input type="submit" value="Agregar">
    </form>
    <a href="index.jsp">← Volver al inicio</a>
</div>
</body>
</html>
