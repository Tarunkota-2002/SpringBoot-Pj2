<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h2>Verify User</h2>
    <form:form action="verify" method="post">
        Username: <input type="text" name="username"><br>
        <input type="submit" value="Verify">
    </form:form>
    <br>
    ${msgs}
</body>
</html>
