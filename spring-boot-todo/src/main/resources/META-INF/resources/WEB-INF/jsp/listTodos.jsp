<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<title> My first JSP page </title>
	</head>
	<body>
		<div class="container">
			<div><h2>!!Welcome ${name}!!</h2></div>
			<hr>
			<h2>Your Todos</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Description</th>
						<th>TargetDate</th>
						<th>Is Done?</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
								<td>${todo.id}</td>
								<td>${todo.description}</td>
								<td>${todo.targetDate}</td>
								<td>${todo.done}</td>
								<td><a href="deletetodo?id=${todo.id}" class="btn btn-warning">DELETE ${todo.id}</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<a href="/addtodo" class="btn btn-success">Add Todo</a>
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		</div>
	</body>
</html>
	