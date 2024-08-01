<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods</title>
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
  <div align="center">${productDeletingStatus}</div>
  <h3 align="center">Товары на складе</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>ID
      <th>Наименование
      <th>
  </thead>
  <tbody>
  <c:forEach var="product" items="${productInformation}">
  <tr>
    <td>${product.id}</td>
    <td>${product.name}</td>
    <form name="deletingGood" method="POST" action="goods" style="display: inline;"> 
   		<td><input type="hidden" name="command" value="DELETEGOOD"/>
   		<input type="hidden" name="deletedProductName" value="${product.name}"/>
  		<button class="menuButton" type="submit" value="Удалить" onclick="return confirmDelete()">Удалить</button>
   </form>
 </tr>
 </c:forEach>
  </tbody>
</table>
</div>

<script type="text/javascript">
	function confirmDelete(){
		var result = confirm("Вы уверены, что хотите удалить данный продукт?");
		return result;
	}
</script>

</body>
</html>