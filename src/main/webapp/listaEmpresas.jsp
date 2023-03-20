<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, main.servlet.Empresa"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista Empresas</title>
</head>
<body>
  <h1>Lista de Empresas</h1>
    <ul>
    <%
        List<Empresa> Lista = (List<Empresa>)request.getAttribute("empresas");
        for (Empresa empresa : Lista) {
    %>
      <li><%= empresa.getNome() %></li>
    <%
        }
    %>
    </ul>
</body>
</html>
