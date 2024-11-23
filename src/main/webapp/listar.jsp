<%@ page import="com.edutecno.modelo.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edutecno.dao.HoroscopoDAOImp" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    HoroscopoDAOImp horoscopoDAOImp = new HoroscopoDAOImp();
    Optional<Usuario> usuario = horoscopoDAOImp.porId(id);
    Usuario u = usuario.get();
%>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Horóscopo Chino - Listado de Usuarios</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <div class="container-fluid">
            <a class="navbar-brand text-white" href="<%= request.getContextPath() %>/menu.jsp?id=<%= u.getId() %>">Horóscopo Chino</a>
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
                <a href="/ProyectoHoroscopo/CerrarSesion" class="btn btn-info text-white">Logout</a>
            </div>
        </div>
    </nav>
    <div class="container mt-5 ">
        <table class="table table-info" border="1" width="650px">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Animal</th>
                </tr>
            </thead>
            <tbody>
                <% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios"); %>
                <% for (Usuario us : usuarios) { %>
                    <tr class="table-info">
                        <td><%= us.getNombre() %></td>
                        <td><%= us.getUsername() %></td>
                        <td><%= us.getEmail() %></td>
                        <td><%= us.getFecha_nac() %></td>
                        <td><%= us.getAnimal() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
