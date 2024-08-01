<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
        <jsp:include page="../css/style.css"/>
</style>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="header-inner header-inner-auth">
            <div class="header-title">
                <div class="header-subtitle">Авторизация</div>
            </div>
        </div>
    </div>
</div>

		<form class="auth-inner" method="POST" action="login">
			<div class="auth-block">
			<div class="auth-block-login">
				<div class="auth-login-title"> Логин:
				<input type="hidden" name="command" value="login" />
				<input class="input" type="text" name="login" value=""/>
				</div>
				
			</div>
			<div class="auth-block-password">
				
				<div class="auth-password-title"> Пароль:
				<input class="input" type="password" name="password" value=""/> 
				</div>
			</div>
				
			<div class="auth-block-button">
				<input class="submitButton" type="submit" value="Авторизоваться"/>	
			</div>
			
			
			
			</div>
			
				
		</form>
		
		<div class="auth-block">
				<div align="center" style="margin: 5px">${errorLoginPassMessage}</div>	
				<div align="center" style="margin: 5px">${wrongAction}</div>
				<div align="center" style="margin: 5px">${nullPage}</div>
		</div>

</body>
</html>