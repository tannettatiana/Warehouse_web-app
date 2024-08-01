<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
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
		
  <h3 align="center">Активные пользователи</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>ID
      <th>Login
      <th>Role
      <th>Authorized
      <th>
  </thead>
  <tbody>
    <c:forEach var="user" items="${usersActive}">
  <tr>
    <td id="ddd">${user.id}</td>
    <td>${user.login}</td>
    <td>${user.role}</td>
    <td>${user.isAuthorized}</td>
   <form name="blockingUser" method="POST" action="blocking" style="display: inline;"> 
   		<td><input type="hidden" name="command" value="BLOCK"/>
   		<input type="hidden" name="blockedUserId" value="${user.id}"/>
  		<input class="menuButton" type="submit" value="Заблокировать" />
   </form>
 </tr>
 </c:forEach>
  </tbody>
  
</table>
</div>

  <h3 align="center">Заблокированные пользователи</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>ID
      <th>Login
      <th>Role
      <th>Authorized
      <th>
  </thead>
  <tbody>
    <c:forEach var="user" items="${usersBlocked}">
  <tr>
    <td><output name="idForBlock" values=${user.id}>${user.id}</output></td>
    <td>${user.login}</td>
    <td>${user.role}</td>
    <td>${user.isAuthorized}</td>
      <form name="unblockingUser" method="POST" action="blocking" style="display: inline;"> 
   		<td><input type="hidden" name="command" value="UNBLOCK"/>
   		<input type="hidden" name="unblockedUserId" value="${user.id}"/>
  			<input class="menuButton" type="submit" value=" Разблокировать" />
   </form>
 </tr>
 </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>