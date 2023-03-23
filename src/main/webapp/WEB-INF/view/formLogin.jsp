<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>

        <form action="${linkEntradaServlet}" method="post">
            Login: <input type="text" name="login" />
            Senha: <input type="password" name="senha" />
            <input type="hidden" name="acao" value="Login" />
            <button type="submit">Cadastrar</button>

            <c:if test="${not empty loginError}">
                usuário ou senha inválidos!
            </c:if>

        </form>

    </body>
</html>