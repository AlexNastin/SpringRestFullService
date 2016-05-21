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
Заданиe:</br>
1) Распарсить через Angular.js данные(книги) в виде таблицы. Добавить возможность:</br> записи книги на сервер через форму, добавить на форму валидацию данных, а также возможность удаления, обновления данных. Оформить все через Bootstrap.</br>
 URLs: </br>
 Пример: http://localhost:8080/example/library;</br>
 
Получение всех книг: example/library; Тип запроса: GET</br>
<a href='<c:url value="/library"/>'>Library</a></br>
Получение одной книги по ID: example/get/{id}; Тип запроса: GET</br>
<a href='<c:url value="/get/1"/>'>Get</a></br>
Удаление одной книги по ID: example/delete/{id}; Тип запроса: GET</br>
<a href='<c:url value="/delete/1"/>'>Delete</a></br>
Сохраниение книги на сервер: example/save; Тип запроса: POST</br>
</body>
</html>
