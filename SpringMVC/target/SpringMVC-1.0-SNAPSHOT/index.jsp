<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/helloworld">Hello World!</a>--%>
    <a>Hello World！！！</a>
    <form action="/handler/testMethod" method="post">
        <input type="submit" value="测试@RequestMapping注解的method属性">
    </form>

    <form action="/handler/testREST" method="post">
        <input type="submit" value="测试REST风格的post请求">
    </form>

    <form action="/handler/testREST/1" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="submit" value="测试REST风格的PUT请求">
    </form>

    <form action="/handler/testREST/1" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="测试REST风格的DELETE请求">
    </form>
</body>
</html>