<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
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
		
		<form method="POST" action="adding_user">
				<div class="userBlock" align="center">
				<h3>Добавление пользователя</h3>
					<div style="margin: 10px">
						Логин пользователя:
						<input type="hidden" name="command" value="addingUsers" />
						<input class="input" type="text" name="addingLogin" value="" style="margin-left: 10px"/>
					</div>
					<div style="margin: 10px">
						Пароль пользователя:
						<input class="input" type="text" name="addingPassword" value=""/>
					</div>
					<div style="margin: 10px">
					  Роль:
					  <select name="choosedRole" style="margin-left: 140px; min-width: 182px">
					    <c:forEach var="role" items="${rolesInformation}">
					    <option value=${role}>${role}</option>
	 					</c:forEach>
					  </select>
					</div>
					
					<div style="margin: 10px">
					<input class="submitButton" type="submit" value="Добавить"/>	
					</div>
					
				</div>
		</form>
		
</body>
</html>