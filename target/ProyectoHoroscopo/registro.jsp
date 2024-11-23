<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Horóscopo Chino - Registro</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="container-fluid">
        <a class="navbar-brand text-white" href="/ProyectoHoroscopo/menu.jsp">Horóscopo Chino</a>
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
    <h3 >Regístrate</h3>

    <form method="post" action="/ProyectoHoroscopo/Registro">
        <div class="row mb-3 align-items-center">
            <label for="nombre" class="col-sm-3 col-form-label">Nombre:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
        </div>
        <div class="row mb-3 align-items-center">
            <label for="email" class="col-sm-3 col-form-label">Correo electrónico:</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
        </div>
        <div class="row mb-3 align-items-center">
            <label for="usuario" class="col-sm-3 col-form-label">Nombre de usuario:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="usuario" name="usuario" required>
            </div>
        </div>
        <div class="row mb-3 align-items-center">
            <label for="fecha" class="col-sm-3 col-form-label">Fecha de Nacimiento:</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" min="1924-02-05" max="2024-02-09" id="fecha" name="fecha" required>
            </div>
        </div>
        <div class="row mb-3 align-items-center">
            <label for="clave" class="col-sm-3 col-form-label">Contraseña:</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="clave" name="clave" required>
            </div>
        </div>
        <div class="row mb-3 align-items-center">
            <label for="clave2" class="col-sm-3 col-form-label">Repita contraseña:</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="clave2" name="clave2" required>
            </div>
        </div>
        <button type="submit" class="btn btn-info text-white">Registrarse</button>
    </form>
</div>
<div class="modal fade" id="modalPass" tabindex="-1" aria-labelledby="modalPassLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalPassLabel">Error</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Las contraseñas no coinciden. Intenta de nuevo.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info text-white" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<script>
    document.querySelector("form").addEventListener("submit", function(event) {
        var password = document.getElementById("clave").value;
        var password2 = document.getElementById("clave2").value;
        if (password !== password2) {
            event.preventDefault();
            var errorModal = new bootstrap.Modal(document.getElementById("modalPass"));
            errorModal.show();
        }
    });
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>
