<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>
<body>

<div class="container">
<h1>Add a Todo!</h1>
<form:form  method="post" modelAttribute="todo">

	<fieldset class="form-group">
		<form:label path="descript">Description</form:label>
		<form:input class="form-control"  type="text" path="descript" />
		<form:errors path="descript" cssClass="text-warning"></form:errors>
	</fieldset>
	
	<input class="btn btn-success" type="submit" value="submit">
</form:form>
	
</div>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>