<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>
<body>

<div class="container">
<br>

<table class="table table-striped">
	<caption>Your Todos</caption>
	<thead>
		<tr>
			<th>ID</th>
			<th>Todo Description</th>
			<th>Target Date</th>
			<th>Done?</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="todo" items="${todos }">
			<tr>
				<td>${todo.id }</td>
				<td>${todo.descript }</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate }"/> </td>
				<td>${todo.done }</td>
				<td><a class="btn btn-success" href="/todo/update-todo?id=${todo.id }" >UPDATE</a>
				<a class="btn btn-danger" href="/todo/delete-todo?id=${todo.id }" >DELETE</a>
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<div class=" text-center">
	<a class="btn btn-success" href="/todo/add-todo">Add a Todo</a>
</div>
	
</div>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>