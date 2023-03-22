<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, main.modelo.Empresa"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista Empresas</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <c:url value="/entrada?acao=removeempresa" var="linkServletRemoveEmpresa"/>
    <c:url value="/entrada?acao=mostraempresa" var="linkServletMostraEmpresa"/>
</head>
<body>
  <h1>Lista de Empresas</h1>

    <c:if test="${not empty nomeEmpresa}">
        Empresa ${nomeEmpresa} cadastrada com sucesso!
    </c:if>

    <h2>Utilizando jstl e expression language: </h2>

    <ul>
        <c:forEach items="${empresas}" var="emp">
            <li>
                ${emp.nome} - <fmt:formatDate value="${emp.dataAbertura}" pattern="dd/MM/yyyy"/>
                <a href="${linkServletMostraEmpresa}&id=${emp.id}">edita</a>
                <a href="${linkServletRemoveEmpresa}&id=${emp.id}">remove</a>
            </li>
        </c:forEach>
    </ul>

    <h2>Utilizando jsp puro: </h2>

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
