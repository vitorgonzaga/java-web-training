<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String nomeEmpresa = (String)request.getAttribute("nomeEmpresa");
    System.out.println(nomeEmpresa);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nova empresa criada</title>
</head>
<body>
  Empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body>
</html>
