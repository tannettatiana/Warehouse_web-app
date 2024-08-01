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
		
  <h3 align="center">Заявки на въезд</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Водитель
      <th>Номер машины
      <th>Время подачи заявки
      <th>
      <th>
  </thead>      
  <tbody>
    <c:forEach var="enterRequest" items="${enterRequestInformation}">
  		<tr>
   			<td>${enterRequest.driver}</td>
    		<td>${enterRequest.carNumber}</td>
    		<td>${enterRequest.time}</td>
    		
    		
    		<form name="approvingEnterRequest" method="POST" action="approving_enter_request" style="display: inline;"> 
   				<td><input type="hidden" name="command" value="APPROVEENTERREQUEST"/>
   				<input type="hidden" name="approvedEnterRequest" value="${enterRequest.id}"/>
  				<input class="menuButton" type="submit" value="Одобрить" />
   			</form>
    		
    		<form name="rejectingEnterRequest" method="POST" action="rejecting_enter_request" style="display: inline;"> 
   				<td><input type="hidden" name="command" value="REJECTENTERREQUEST"/>
   				<input type="hidden" name="rejectedEnterRequest" value="${enterRequest.id}"/>
  				<input class="menuButton" type="submit" value="Отклонить" />
   			</form>

 		</tr>
 	</c:forEach>
  </tbody>
</table>
</div>







  <h3 align="center">История заявок на въезд</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Водитель
      <th>Номер машины
      <th>Время подачи заявки
      <th>
      <th>
  </thead>  
 <tbody>
    <c:forEach var="enterRequestsHistory" items="${enterRequestsHistory}">
  		<tr>
   			<td>${enterRequestsHistory.driver}</td>
    		<td>${enterRequestsHistory.carNumber}</td>
    		<td>${enterRequestsHistory.time}</td>
    		
   <form name="approvingEnterRequest" method="POST" action="approving_enter_request" style="display: inline;"> 
   				<td><input type="hidden" name="command" value="APPROVEENTERREQUEST"/>
   				<input type="hidden" name="approvedEnterRequestHistory" value="${enterRequestsHistory.id}"/>
   				<c:if test="${enterRequestsHistory.status == 'inactive'}">
				  	<input class="menuButton" type="submit" value="Одобрить" />
				</c:if>
				<c:if test="${enterRequestsHistory.status == 'active'}">
				  	<input class="menuButtonInactive" type="submit" value="Одобрить" disabled/>
				</c:if>
   			</form>
    		
    		<form name="rejectingEnterRequest" method="POST" action="rejecting_enter_request" style="display: inline;"> 
   				<td><input type="hidden" name="command" value="REJECTENTERREQUEST"/>
   				<input type="hidden" name="rejectedEnterRequestHistory" value="${enterRequestsHistory.id}"/>
   				<c:if test="${enterRequestsHistory.status == 'active'}">
				  	<input class="menuButton" type="submit" value="Отклонить"/>
				</c:if>
				<c:if test="${enterRequestsHistory.status == 'inactive'}">
				  	<input class="menuButtonInactive" type="submit" value="Отклонить" disabled/>
				</c:if>
   			</form>
   
   
 		</tr>
 	</c:forEach> 		
</tbody>










</body>
</html>