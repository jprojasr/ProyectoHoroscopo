<%--
  Created by IntelliJ IDEA.
  User: reape
  Date: 28-10-2024
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
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
        <div class="ms-auto">
            <a href="logout.html" class="btn btn-outline-danger">Cerrar sesión</a>
        </div>
    </div>
</nav>

<div class="container mt-5 ">
    <h1 class="text-center">¿Que desea hacer?</h1>
    <div class="container my-5">
        <div class="d-flex justify-content-between">
            <button class="btn btn-info text-white py-3">Conoce tu animal</button>
            <button class="btn btn-info text-white py-3">Buscar usuarios</button>
            <button class="btn btn-info text-white py-3">Modificar datos</button>
            <button class="btn btn-info text-white py-3">Eliminar cuenta</button>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>
