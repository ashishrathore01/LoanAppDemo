<div class="login-div" id="login-admin-div">
	<span class="login-heading" style="">Admin Login</span>
	<div class="login-sub-div">
		<form class="login-form" method="post" action="./login.do">
			<!-- <p><a href="./user/login">Login Home</a></p>
			<p><a href="./user/registration">Registration Home</a></p> -->
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><select name="role">
							<option value="null">Select Role</option>
							<option value="Operator">Operator</option>
							<option value="Manager">Manager</option>
							<option value="Admin">Admin</option>
					</select></td>
				</tr>
				<td colspan="2"><input type="hidden" name="userName"
					value="<%=session.getAttribute("username")%>"> <input
					type="hidden" name="userPassword"
					value="<%=session.getAttribute("password")%>"> <input
					type="hidden" name="userRole"
					value="<%=session.getAttribute("role")%>"></td>
				<tr>
				</tr>
				<tr>
					<td><button class="shiny-blue" type="submit">Login</button></td>
					<td><button class="shiny-blue" type="reset">Reset</button></td>
				</tr>
			</table>
		</form>
	</div>
</div>