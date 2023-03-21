<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <c:url value="/atualizaempresa" var="linkServletAtualizaEmpresa"/>
</head>
<body>

<form action="${linkServletAtualizaEmpresa}" method="get">
    Nome: <input type="text" name="nome" value="${empresa.nome}"/>
    Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
    <input type="hidden" name="id" value="${empresa.id}"/>
    <button type="submit">Atualizar</button>
</form>

</body>
</html>