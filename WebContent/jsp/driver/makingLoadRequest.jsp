<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Load request</title>

<style>
        <jsp:include page="../../css/style.css"/>
</style>
</head>
<body>

<ol class="userMenu">
        <li>
        <form name="MakingEnterRequest" method="POST" action="making_enter_request_page" style="display: inline;">
  			<input type="hidden" name="command" value="makingEnterRequest"/>
  			<input class="menuButton" type="submit" value="Оформить заявку на въезд" />
  		</form>
  		
  		<li>
  		<form name="MakingLoadRequest" method="POST" action="making_load_request" style="display: inline;">
  			<input type="hidden" name="command" value="makingLoadRequest"/>
  			<input class="menuButton" type="submit" value="Оформить заявку на погрузку/разгрузку" />
  		</form>
  			
  		<li>
  		<form name="ViewingDriverEnterRequests" method="POST" action="viewing_driver_enter_requests" style="display: inline;">
	  		<input type="hidden" name="command" value="viewingDriverEnterRequests"/>
	  		<input class="menuButton" type="submit" value="Список заявок на въезд" />
  		</form>
  			
  		<li>
  		<form name="ViewingDriverLoadRequests" method="POST" action="viewing_driver_load_requests" style="display: inline;">
	  		<input type="hidden" name="command" value="viewingDriverLoadRequests"/>
	  		<input class="menuButton" name="viewAuthorizedUsers" type="submit" value="Список заявок на погрузку/разгрузку" />
  		</form>
  		
        <span><a href="controller?command=logout" class="logout">Выйти</a></span>
    </ol>

	<form method="POST" action="sending_load_request">
				<div class="userBlock" align="center">
				<h3>Оформление заявки на погрузку/разгрузку</h3>
					<div style="margin: 10px">
					  Номер машины:
					  <input type="hidden" name="command" value="sendingLoadRequest" />
					  <select name="choosedCar" style="margin-left: 14px; min-width: 182px">
					    <c:forEach var="car" items="${loadingCarNumber}">
					    <option value=${car}>${car}</option>
	 					</c:forEach>
					  </select>
					</div>
					
					<div style="margin: 10px">
					  Продукт:
					  <select name="choosedProduct" style="margin-left: 71px; min-width: 182px">
					    <c:forEach var="product" items="${products}">
					    <option value=${product}>${product}</option>
	 					</c:forEach>
					  </select>
					</div>
					
					<div style="margin: 10px">
					  Тип:
					  <select name="loadType" style="margin-left: 107px; min-width: 182px">
					    <option value="loading">Погрузка</option>
					    <option value="unloading">Разгрузка</option>
					  </select>
					</div>
					
					<div style="margin: 10px">
					<input class="submitButton" type="submit" value="Подать заявку"/>	
					</div>
					
				</div>
		</form>

</body>
</html>