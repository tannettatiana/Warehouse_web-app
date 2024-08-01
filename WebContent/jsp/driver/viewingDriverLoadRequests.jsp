<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Load requests</title>

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

  <h3 align="center">Отправленные заявки на погрузку</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Продукт
      <th>Статус
  </thead>
  <tbody>
    <c:forEach var="driverLoadRequest" items="${driverLoadRequestInformation}">
    <tr>
      <td>${driverLoadRequest.carNumber}</td>
      <td>${driverLoadRequest.time}</td>
      <td>${driverLoadRequest.product}</td>
      <td>${driverLoadRequest.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>


  <h3 align="center">Одобренные заявки на погрузку</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Продукт
      <th>Статус
  </thead>
  <tbody>
    <c:forEach var="driverApprovedLoadRequestInformation" items="${driverApprovedLoadRequestInformation}">
    <tr>
      <td>${driverApprovedLoadRequestInformation.carNumber}</td>
      <td>${driverApprovedLoadRequestInformation.time}</td>
      <td>${driverApprovedLoadRequestInformation.product}</td>
      <td>${driverApprovedLoadRequestInformation.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>


  <h3 align="center">Отклоненные заявки на погрузку</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Продукт
      <th>Статус
  </thead>
  <tbody>
    <c:forEach var="driverNotApprovedLoadRequestInformation" items="${driverNotApprovedLoadRequestInformation}">
    <tr>
      <td>${driverNotApprovedLoadRequestInformation.carNumber}</td>
      <td>${driverNotApprovedLoadRequestInformation.time}</td>
      <td>${driverNotApprovedLoadRequestInformation.product}</td>
      <td>${driverNotApprovedLoadRequestInformation.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>



  <h3 align="center">Отправленные заявки на разгрузку</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Продукт
      <th>Статус
  </thead>
  <tbody>
    <c:forEach var="driverUnloadRequest" items="${driverUnloadRequestInformation}">
    <tr>
      <td>${driverUnloadRequest.carNumber}</td>
      <td>${driverUnloadRequest.time}</td>
      <td>${driverUnloadRequest.product}</td>
      <td>${driverUnloadRequest.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>


  <h3 align="center">Одобренные заявки на разгрузку</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Продукт
      <th>Статус
  </thead>
  <tbody>
    <c:forEach var="driverApprovedUnloadRequestInformation" items="${driverApprovedUnloadRequestInformation}">
    <tr>
      <td>${driverApprovedUnloadRequestInformation.carNumber}</td>
      <td>${driverApprovedUnloadRequestInformation.time}</td>
      <td>${driverApprovedUnloadRequestInformation.product}</td>
      <td>${driverApprovedUnloadRequestInformation.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>



  <h3 align="center">Отклоненные заявки на разгрузку</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Номер машины
      <th>Время подачи заявки
      <th>Продукт
      <th>Статус
  </thead>
  <tbody>
    <c:forEach var="driverNotApprovedUnloadRequestInformation" items="${driverNotApprovedUnloadRequestInformation}">
    <tr>
      <td>${driverNotApprovedUnloadRequestInformation.carNumber}</td>
      <td>${driverNotApprovedUnloadRequestInformation.time}</td>
      <td>${driverNotApprovedUnloadRequestInformation.product}</td>
      <td>${driverNotApprovedUnloadRequestInformation.status}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>


</body>
</html>