<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <c:url value="/entrada" var="linkEntradaServlet"/>
</head>
<body>

<form action="${linkEntradaServlet}" method="get">
    Nome: <input type="text" name="nome" value="${empresa.nome}"/>
    Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
    <input type="hidden" name="id" value="${empresa.id}"/>
    <input type="hidden" name="acao" value="alteraempresa"/>
    <button type="submit">Atualizar</button>
</form>

</body>
</html>