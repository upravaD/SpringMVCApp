<html lang="en" xmlns:th="https://www.thymeleaf.org">

    <head>
        <meta charset="UTF-8">
        <title>index</title>
    </head>

    <body>
        <h2>Index</h2>
        <a href="/first/hello">START</a>
<%--        <input th:href="/first/hello" th:type="button" value="START">--%>
<%--        <form href="/first/hello">--%>
<%--            <input href="/first/hello" type="submit" value="START">--%>
<%--        </form>--%>
        <br/>
        <a href="/hello-world">see my first app</a>
<%--        <form th:action="@{/hello-world}">--%>
<%--            <input type="submit" value="My first app">--%>
<%--        </form>--%>
        <br/>
        <a href="/first/calculator'?a=10&b=2&action=addition'">calculator</a>
<%--        <form th:action="@{/first/calculator'?a=10&b=2&action=addition'}">--%>
<%--            <input type="submit" value="Calculator">--%>
<%--        </form>--%>
        <br/>
        <a href="/person">DataBase</a>
<%--        <form th:action="@{/person}">--%>
<%--            <input type="submit" value="DataBase">--%>
<%--        </form>--%>
    </body>

</html>
