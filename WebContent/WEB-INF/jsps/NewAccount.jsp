<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery.js"></script>
<script type="text/javascript">
	function onload() {

		$("#password").keyup(cheackPasswordMatch);
		$("#confirmpass").keyup(cheackPasswordMatch);
		$("#details").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password != confirmpass) {
			alert('<fmt:message key="UnmatchedPasswords.users.password"/>');
			return false;
		}
		return true;
	}

	function cheackPasswordMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if (password.length > 3 || confirmpass > 3) {
			if (password == confirmpass) {
				$("#matchpass").text('<fmt:message key="MatchedPasswords.users.password"/>');
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");

			} else {
				$("#matchpass").text('<fmt:message key="UnmatchedPasswords.users.password"/>');
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}
	$(document).ready(onload);
</script>




<head>



<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Create New Account</title>
</head>
<body>





	<h2 class="h2createaccount">Create New Account</h2>


	<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createAccount" commandName="user">
		<table class="formtable">
			<tr>
				<td class="label">Username:</td>
				<td><sf:input class="control" path="username" name="username" type="text" /><br />
					<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><div class="error">
						<sf:input class="control" path="email" name="email" type="text" />
						<br />
						<sf:errors path="email"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><div class="error">
						<sf:input id="password" lass="control" path="password" name="password" type="text" />
						<br />
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>

			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" class="control" name="confirmpass" type="text" />
					<div id="matchpass"></div></td>
			</tr>

			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Account" type="submit" /></td>
			</tr>

		</table>
	</sf:form>




</body>
</html>