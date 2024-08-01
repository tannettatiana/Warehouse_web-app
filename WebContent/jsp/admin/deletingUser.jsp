<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
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
		
		<form method="POST" action="deleting_user">
				<div class="deleteUserBlock" align="center">
					<h3>Удаление пользователя</h3>
				    Логин удаляемого пользователя:
					<input type="hidden" name="command" value="deletingUsers" />
					<select name="deletingLogin">
					  	<c:forEach var="login" items="${loginsInformation}">
					    <option value=${login}>${login}</option>
	 					</c:forEach>
					</select>
					<div style="margin: 10px"><button class="submitButton" type="submit" value="Удалить" onclick="return confirmDelete()">Удалить</button></div>
				</div>
		</form>
		<script type="text/javascript">
			function confirmDelete(){
				var result = confirm("Вы уверены, что хотите удалить данного пользователя?");
				return result;
			}
		</script>
</body>
</html>