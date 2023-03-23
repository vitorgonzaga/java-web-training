<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nova empresa criada</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
    <c:if test="${not empty nomeEmpresa}">
        Empresa ${nomeEmpresa} cadastrada com sucesso!
    </c:if>

    <c:if test="${empty nomeEmpresa}">
        Nenhuma empresa cadastrada!
    </c:if>
</body>
</html>
