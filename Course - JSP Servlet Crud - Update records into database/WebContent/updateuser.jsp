<%@ include file="include/header.jsp" %>
<div class="container mtb" >
	<div class="row">
		<div class="col-lg-12">
			<h3>Update User</h3>
			<form action="${pageContext.request.contextPath}/operation" method="post">
			Username: <input type="text" name="username" required="required" value="${param.username}"/>
			Email: <input type="email" name="email" required="required" value="${param.email}"/>
			<input type="hidden" name="usersId" value="${param.usersId}"/>
			<input type="hidden" name="form" value="updateUserOperation"/>
			
			<input type="submit" name="Update User" value="Update User"/><br/>
			
			
			</form>


			
		</div>
	</div>
</div> 
<%@ include file="include/footer.jsp" %>