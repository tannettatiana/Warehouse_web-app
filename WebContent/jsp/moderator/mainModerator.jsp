<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Moderator</title>
<style>
        <jsp:include page="../../css/style.css"/>
</style>
</head>
<body>
		
		<ol class="userMenu">
  			
  			<li>
  			<form name="ViewingUsersStatus" method="POST" action="viewing_users_status" style="display: inline;">
  			<input type="hidden" name="command" value="viewingUsersStatus"/>
  			<input class="menuButton" type="submit" value="Пользователи" />
  			</form>
  			
  			<li>
  			<form name="ViewingGoods" method="POST" action="viewing_goods" style="display: inline;">
  			<input type="hidden" name="command" value="viewingGoods"/>
  			<input class="menuButton" type="submit" value="Товары на складе" />
  			</form>
  			
  			<li>
  			<form name="AddingGoodsPage" method="POST" action="adding_goods" style="display: inline;">
  			<input type="hidden" name="command" value="AddingGoodsPage"/>
  			<input class="menuButton" type="submit" value="Добавить товар" />
  			</form>
  			
  			<span>
  			<a href="controller?command=logout" class="logout">Выйти</a>
  			</span>	
		</ol>

</body>
</html>