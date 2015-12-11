<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Tasks Viewer</title>

<spring:url value="/resources/bootstrap-3.3.6/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Tasks Viewer</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<c:forEach items="${tasks}" var="i">
			<p>
				<b><c:out value="${i.taskName}" /></b> -- <c:out value="${i.taskDescription} - ${i.taskPriority} ${i.taskStatus}" />
			</p>
		</c:forEach>
	</div>
</div>

<div class="container">
	<footer>
		<p>2015</p>
	</footer>
</div>

<spring:url value="/resources/bootstrap-3.3.6/js/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

</body>
</html>