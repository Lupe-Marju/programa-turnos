<html>
<head>
    <title>Inicio</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }
        h2 {
            color: #003366;
            margin-top: 50px;
            margin-bottom: 30px;
            text-align: center;
        }
        a {
            display: block;
            background-color: #003366; /* mismo azul del título */
            color: white;
            text-decoration: none;
            padding: 12px 25px;
            border-radius: 6px;
            font-weight: bold;
            margin: 10px 0;
            width: 220px;
            text-align: center;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #002244; /* azul más oscuro para hover */
        }
        .container {
            margin-top: 30px;
            width: 100%;
            max-width: 300px;
        }
    </style>
</head>
<body>
    <h2>Bienvenido al Sistema de Turnos</h2>
    <div class="container">
        <a href="ciudadanoformulario.jsp"> Agregar Ciudadano </a>
        <a href="agregarturno"> Agregar Turno </a>
        <a href="buscarTurnos"> Listado de Turnos </a>
    </div>
</body>
</html>
