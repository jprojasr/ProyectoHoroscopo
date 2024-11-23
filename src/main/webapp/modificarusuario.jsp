<%@ page import="com.edutecno.dao.HoroscopoDAOImp" %>
<%@ page import="com.edutecno.modelo.Usuario" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.edutecno.dao.HoroscopoDAOImp" %>
<%@ page import="com.edutecno.dao.HoroscopoDAOImp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    HoroscopoDAOImp horoscopoDAOImp = new HoroscopoDAOImp();
    Optional<Usuario> usuario = horoscopoDAOImp.porId(id);
    Usuario u = usuario.get();
%>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Horóscopo Chino - Editar Perfil</title>
</head>
<body>


<div class="container mt-5 ">
    <form method="post" action="/ProyectoHoroscopo/Modificar">

        <div class="row mb-3">
            <label for="id" class="col-sm-2 col-form-label">Id</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="id" name="id" value="<%=id%>" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%=u.getNombre()%>">
            </div>
        </div>
        <div class="row mb-3">
            <label for="username" class="col-sm-2 col-form-label">Nombre de Usuario</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username" value="<%=u.getUsername()%>">
            </div>
        </div>
        <div class="row mb-3">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="email" name="email" value="<%=u.getEmail()%>">
            </div>
        </div>
        <div class="row mb-3">
            <label for="fecha" class="col-sm-2 col-form-label">Fecha de Nacimiento</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="fecha" name="fecha" value="<%=u.getFecha_nac()%>">
            </div>
        </div>
        <div class="row mb-3">
            <label for="clave" class="col-sm-2 col-form-label">Clave</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="clave" name="clave" value="<%=u.getClave()%>">
            </div>
        </div>
        <div class="row mb-3">
            <label for="animal" class="col-sm-2 col-form-label">Animal</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="animal" name="animal" value="<%=u.getAnimal()%>" readonly>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Actualizar</button>
    </form>
</div>
</body>
</html>
