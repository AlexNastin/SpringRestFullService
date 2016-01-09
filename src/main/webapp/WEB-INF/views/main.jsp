<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script src="<c:url value="/resources/js/jquery-2.1.4.js" />">
	
</script>
</head>
<body>

	<form id="save-form">
		<input type="text" id="idBook"> <input type="text" id="name">
		<input type="text" id="provider">
		<button type="submit" id="saveBook">Save</button>
	</form>

	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="<c:url value="/library" />">Library</a>

	<input type="button" onclick="library()" value="Library">
	<div id="test"></div>

	<script type="text/javascript">
		$(document).ready(function($) {
			$("#save-form").submit(function(event) {
				save();
			});
		});

		function library() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : '${pageContext.request.contextPath}/library',
				success : function(response) {
					display(response);
				},
				dataType : "json"
			});
		}

		function display(data) {
			var json = JSON.stringify(data, null, 4);
			$('#test').html(json);
		}

		function save() {
			var save = {}
			save["idBook"] = $("#idBook").val();
			save["name"] = $("#name").val();
			save["provider"] = $("#provider").val();
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "${pageContext.request.contextPath}/save",
				data : JSON.stringify(save),
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					alert("S");
					library();
					alert("S2");
				},
				error : function(e) {
					alert("e");
				},
				done : function(e) {
					alert("D");
				}
			});

		}
	</script>

</body>
</html>
