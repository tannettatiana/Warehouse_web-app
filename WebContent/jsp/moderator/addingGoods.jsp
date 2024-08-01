<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Goods</title>
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
		
		<form method="POST" action="adding_goods">
		<div align="center">${productAddingStatus}</div>
				<div class="userBlock" align="center">
				<h3>Добавление товара</h3>
					<div style="margin: 10px">
						Наименование:
						<input type="hidden" name="command" value="addingGoods" />
						<input class="input" type="text" name="addingGoodName" value="" style="margin-left: 10px"/>
					</div>
					
					<div style="margin: 10px">
					<input class="submitButton" type="submit" value="Добавить"/>	
					</div>
					
				</div>
		</form>
		
</body>
</html>