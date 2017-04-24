<%@ include file="common/header.jspf"%>
<%@ include file="common/navbar.jspf"%>
<body>
<div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="/todo/login" method="POST">
		<fieldset class="form-group">
			<label>Name</label> <input name="name" type="text"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input name="password" type="password"
				class="form-control" />
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form>

</div>
</body>
</html>