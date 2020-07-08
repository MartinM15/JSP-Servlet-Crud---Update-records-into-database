<%@ include file="include/header.jsp" %>
<div class="container mtb" >
	<div class="row">
		<div class="col-lg-12">
			<h3>Adding User</h3>
			<form action="${pageContext.request.contextPath}/operation" method="post">
			Username: <input type="text" name="username" required="required"/><br/>
			Email: <input type="email" name="email" required="required"/><br/>
			<input type="hidden" name="form" value="adduserOperation"/>
			
			<input type="submit" name="Add User"/><br/>
			
			
			</form>


			
		</div>
	</div>
</div> 
<%@ include file="include/footer.jsp" %>