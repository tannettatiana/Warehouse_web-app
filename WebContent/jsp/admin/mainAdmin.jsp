<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<style>
        <jsp:include page="../../css/style.css"/>
</style>
</head>
<body>
		
		<ol class="userMenu">
  			<li>
  			<form name="AddingUser" method="POST" action="adding_user_page" style="display: inline;">
  			<input type="hidden" name="command" value="addingUser"/>
  			<input class="menuButton" type="submit" value="Добавить пользователя" />
  			</form>
  			
  			<li>
  			<form name="DeletingUser" method="POST" action="deleting_user_page" style="display: inline;">
  			<input type="hidden" name="command" value="deletingUser"/>
  			<input class="menuButton" type="submit" value="Удалить пользователя" />
  			</form>
  			
  			<li>
  			<form name="ViewingUsers" method="POST" action="viewing_users" style="display: inline;">
  			<input type="hidden" name="command" value="viewingUsers"/>
  			<input class="menuButton" type="submit" value="Список пользователей" />
  			</form>
  			
  			<li>
  			<form name="ViewingAuthorizedUsers" method="POST" action="viewing_authorized_users" style="display: inline;">
  			<input type="hidden" name="command" value="viewingAuthorizedUsers"/>
  			<input class="menuButton" name="viewAuthorizedUsers" type="submit" value="Список авторизованных" />
  			</form>
  			
  			<span>
  			<a href="controller?command=logout" class="logout">Выйти</a>
  			</span>	
		</ol>

</body>
</html>