<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>RestFull Service</title>
<script src="<c:url value="/resources/js/jquery-2.1.4.js" />">
</script>
</head>
<body>
Задания:</br>
1) Распарсить через Angular.js данные(книги) в виде таблицы. Добавить возможность удаления, обновления данных. Оформить все через Bootstrap.
2) Отправить на сервер JSON обьект. Для записи. Пример обьекта</br>
<form id="save-form">
		<input type="text" id="idBook"> <input type="text" id="name">
		<input type="text" id="provider">
		<button type="submit" id="saveBook">Save</button>
</form>

	<a href="<c:url value="/library" />">Library</a>

	<input type="button" onclick="library()" value="Library">
	<div id="test"></div>
	<input type="button" onclick="RestPutPhys()" value="save">
</body>
</html>
