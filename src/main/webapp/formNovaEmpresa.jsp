<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaempresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="${linkServletNovaEmpresa}" method="post">
    Nome: <input type="text" name="nome" />
    Data Abertura: <input type="text" name="data" />
    <button type="submit">Cadastrar</button>

</form>

</body>
</html>