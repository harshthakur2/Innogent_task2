<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import url(https://fonts.googleapis.com/css?family=Lobster);

* {
	margin: 0;
	padding: 0;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	user-select: none;
}

body {
	background: hsla(255, 255%, 255%, 1);
	font: 100%/1 'Lobster', cursive;
}

.login {
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -10rem 0 0 -10rem;
	width: 20rem;
	height: 20rem;
	padding: 3em;
	background: hsla(255, 255%, 255%, 1);
	border-radius: 50%;
	overflow: hidden;
	transition: all 1s ease;
}

.login:hover>.header, .login.clicked>.header {
	width: 2rem;
}

.login:hover>.header>.text, .login.clicked>.header>.text {
	font-size: 1rem;
	-webkit-transform: rotate(-90deg);
	transform: rotate(-90deg);
}

.login.loading>.header {
	width: 20rem;
	transition: all 1s ease;
}

.login.loading>.header>.text {
	display: none;
}

.login.loading>.header>.loader {
	display: block;
}

.header {
	position: absolute;
	left: 0;
	top: 0;
	z-index: 1;
	width: 20rem;
	height: 20rem;
	background: hsla(0, 5%, 0%, 1);
	transition: width 0.5s ease-in-out;
}

.header>.text {
	display: block;
	width: 100%;
	height: 100%;
	font-size: 5rem;
	text-align: center;
	line-height: 20rem;
	color: hsla(255, 255%, 255%, 1);
	transition: all 0.5s ease-in-out;
}

.header>.loader {
	display: none;
	position: absolute;
	left: 5rem;
	top: 5rem;
	width: 10rem;
	height: 10rem;
	border-left: 10px solid hsla(255, 255%, 255%, 1);
	border-bottom: 10px solid hsla(255, 255%, 255%, 1);
	border-right: 10px solid hsla(255, 255%, 255%, 1);
	border-top: 8px solid hsla(255, 255%, 255%, 1);
	border-radius: 50%;
	box-shadow: inset 2px 2px 2px 2px hsla(0, 5%, 0%, 1);
	animation: loading 2s linear infinite;
}

.header>.loader:after {
	content: "";
	position: absolute;
	left: 4.15rem;
	top: -0.5rem;
	width: 1rem;
	height: 1rem;
	background: hsla(1, 75%, 55%, 1);
	border-radius: 50%;
	border-right: 1px solid hsla(1, 75%, 55%, 1);
}

.header>.loader:before {
	content: "";
	position: absolute;
	left: 3.4rem;
	top: -0.5rem;
	width: 0;
	height: 0;
	border-right: 1rem solid hsla(1, 75%, 55%, 1);
	border-top: 0.5rem solid transparent;
	border-bottom: 0.5rem solid transparent;
}

@
keyframes loading { 50% {
	border-left: 10px solid hsla(1, 95%, 25%, 1);
	border-bottom: 10px solid hsla(1, 95%, 25%, 1);
	border-right: 10px solid hsla(1, 95%, 25%, 1);
	border-top: 8px solid hsla(1, 95%, 25%, 1);
}

100
%
{
transform
:
rotate(
360deg
);
}
}
.form {
	margin: 0 0 0 2rem;
	padding: 0.5rem;
}

.input {
	display: block;
	width: 100%;
	font-size: 2rem;
	padding: 0.5rem 1rem;
	box-shadow: none;
	border-color: hsla(0, 5%, 0%, 1);
	border-width: 0 0 3px 0;
	transition: all .5s ease-in;
	outline: transparent;
}

.input+.input {
	margin: 10px 0 0;
}

.input:focus {
	border-bottom: 3px solid hsla(1, 75%, 55%, 1);
}

.btn {
	position: absolute;
	right: 7.8rem;
	bottom: 3rem;
	width: 4rem;
	height: 4rem;
	border: none;
	background: hsla(255, 255%, 255%, 1);
	font-size: 0;
	border: none;
	transition: all 0.3s ease-in-out;
}

.btn:after {
	content: "";
	position: absolute;
	left: 1.4rem;
	top: 1rem;
	width: 0;
	height: 0;
	border-left: 1.6rem solid hsla(1, 75%, 55%, 1);
	border-top: .8rem solid transparent;
	border-bottom: .8rem solid transparent;
	transition: border 0.3s ease-in-out 0s;
}

.btn:hover, .btn:focus, .btn:active {
	outline: none;
}

.btn:hover:after, .btn:focus:after, .btn:active:after {
	border-left-color: hsla(0, 5%, 0%, 1);
}

.resetbtn {
	margin: 1%;
	border: none;
	padding: .5em;
	width: 5em;
	background: hsla(0, 0%, 0%, 1);
	color: hsla(255, 255%, 255%, 1);
	font-size: 1.5em;
	border-radius: 2px;
	transition: all 1s ease-in-out;
	outline: none;
	box-shadow: 0 0 1px 1px hsla(0, 0%, 0%, 0.2);
}

.resetbtn:hover, .resetbtn:focus {
	background: hsla(255, 255%, 255%, 1);
	color: hsla(0, 0%, 0%, 1);
	outline: 5px solid hsla(0, 0%, 0%, 1);
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('.input').on('focus', function() {
			$('.login').addClass('clicked');
		});
		$('.login').on('submit', function(e) {
			e.preventDefault();
			$('.login').removeClass('clicked').addClass('loading');
		});
		$('.resetbtn').on('click', function(e) {
			e.preventDefault();
			$('.login').removeClass('loading');
		});
	});
</script>
<meta charset="ISO-8859-1">
<title>Employee Page</title>

</head>
<body>

	<%!String msg;%>
	<%
	msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>
	<div><%=msg%></div>
	<%
	}
	%>

	<div class="container">
		<h2>Employee Login Form</h2>
		<form action="LoginCtl" method="post">
			<!-- <div class="form-group">
      <label for="userName">User Name :</label>
      <input type="text" class="form-control" id="userName" placeholder="Enter userName" name="userName">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    </div>
    
    <button type="submit" class="btn btn-default" name="operation" value="login">Login</button>
   </form>
</div> -->
			<div class="login">
				<header class="header">
					<span class="text">LOGIN</span> <span class="loader"></span>
				</header>
				<form class="form">
					<input type="text" class="form-control" id="userName"
						placeholder="Enter userName" name="userName"> <input
						type="password" class="form-control" id="pwd"
						placeholder="Enter password" name="password">
					<button type="submit" class="btn btn-default" name="operation"
						value="login">Login</button>
				</form>
			</div>

		</form>
</body>
</html>