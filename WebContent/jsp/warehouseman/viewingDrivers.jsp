<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drivers</title>
<style>
        <jsp:include page="../../css/style.css"/>
</style>
</head>
<body>
  <ol class="userMenu">
  			<li>
  			<form name="ViewingEnterRequests" method="POST" action="viewing_enter_requests" style="display: inline;">
  			<input type="hidden" name="command" value="viewingEnterRequests"/>
  			<input class="menuButton" type="submit" value="Заявки на въезд" />
  			</form>
  			
  			<li>
  			<form name="ViewingLoadRequests" method="POST" action="viewing_load_requests" style="display: inline;">
  			<input type="hidden" name="command" value="viewingLoadRequests"/>
  			<input class="menuButton" type="submit" value="Заявки на погрузку / разгрузку" />
  			</form>
  			
  			<li>
  			<form name="ViewingDrivers" method="POST" action="viewing_drivers" style="display: inline;">
  			<input type="hidden" name="command" value="viewingDrivers"/>
  			<input class="menuButton" type="submit" value="Водители на складе" />
  			</form>
  			
  			<span>
  			<a href="controller?command=logout" class="logout">Выйти</a>
  			</span>	
		</ol>
		
  <h3 align="center">Водители на складе</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>ID
      <th>Login
      <th>Номер машины
  </thead>
  <tbody>
    <c:forEach var="driver" items="${driverInformation}">
  		<tr>
   			<td>${driver.driver}</td>
    		<td>${driver.carNumber}</td>
    		<td>${driver.login}</td>
 		</tr>
 	</c:forEach>
  </tbody>
</table>
</div>
</body>
</html>