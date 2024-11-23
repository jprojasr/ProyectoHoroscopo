<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Horóscopo Chino - Inicio Sesión</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="container-fluid">
        <a class="navbar-brand text-white" href="#">Horóscopo Chino</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link text-white" aria-current="page" href="#">Tu Horóscopo Chino</a>
            </div>
        </div>
    </div>
</nav>

<div class="container mt-5 ">
    <h3 >Inicia sesión</h3>
    <p>Es necesario que inicies sesión para revisar tu horóscopo chino. Si todavía no tienes cuenta, haz click <a href="/ProyectoHoroscopo/registro.jsp">aquí</a>.</p>
    <form method="post" action="/ProyectoHoroscopo/InicioSesion">
        <div class="row mb-3 align-items-center">
            <label for="usuario" class="col-sm-3 col-form-label">Nombre de usuario:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="usuario" name="usuario" required>
            </div>
        </div>
        <div class="row mb-3 align-items-center">
            <label for="clave" class="col-sm-3 col-form-label">Contraseña:</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="clave" name="clave" required>
            </div>
        </div>
        <button type="submit" class="btn btn-info text-white">Ingresar</button>
    </form>
</div>

<div class="modal" tabindex="-1" id="mensajeModal" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Información</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <%= request.getAttribute("mensajeModal") %>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info text-white" data-bs-dismiss="modal">Aceptar</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<script>
    <% if (request.getAttribute("mostrarModal") != null && (boolean) request.getAttribute("mostrarModal")) { %>
    var myModal = new bootstrap.Modal(document.getElementById('mensajeModal'));
    myModal.show();
    <% } %>
</script>
</body>

</html>

