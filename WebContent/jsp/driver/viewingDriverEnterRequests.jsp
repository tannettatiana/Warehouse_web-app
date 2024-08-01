<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter requests</title>

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

  <h3 align="center">Отправленные заявки на въезд</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Статус
  </thead>
  <tbody>
  	<c:forEach var="driverEnterRequest" items="${driverEnterRequestInformation}">
    <tr>
      <td>${driverEnterRequest.carNumber}</td>
      <td>${driverEnterRequest.time}</td>
      <td>${driverEnterRequest.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>










  <h3 align="center">Активные заявки на въезд</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Статус
  </thead>
  <tbody>
  	<c:forEach var="driverActiveEnterRequestInformation" items="${driverActiveEnterRequestInformation}">
    <tr>
      <td>${driverActiveEnterRequestInformation.carNumber}</td>
      <td>${driverActiveEnterRequestInformation.time}</td>
      <td>${driverActiveEnterRequestInformation.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>



  <h3 align="center">Неактивные заявки на въезд</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Статус
  </thead>
  <tbody>
  	<c:forEach var="driverInactiveEnterRequestInformation" items="${driverInactiveEnterRequestInformation}">
    <tr>
      <td>${driverInactiveEnterRequestInformation.carNumber}</td>
      <td>${driverInactiveEnterRequestInformation.time}</td>
      <td>${driverInactiveEnterRequestInformation.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>









</body>
</html>