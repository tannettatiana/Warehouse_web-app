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

	<h3 align="center">Заявки на погрузку</h3>
	<div class="tableDiv">
		<table>
			<thead>
				<tr>
					<th>Водитель
					<th>Номер машины
					<th>Время подачи заявки
					<th>Продукт
					<th>Статус заявки
					<th>
					<th>
			</thead>
			<tbody>
				<c:forEach var="loadRequest" items="${loadRequestInformation}">
					<tr>
						<td>${loadRequest.driver}</td>
						<td>${loadRequest.carNumber}</td>
						<td>${loadRequest.time}</td>
						<td>${loadRequest.product}</td>
						<td>${loadRequest.status}</td>
						<form name="approvingLoadRequest" method="POST" action="approving_load_request" style="display: inline;">
							<td><input type="hidden" name="command" value="APPROVELOADREQUEST" /> 
								<input type="hidden"
								name="approvedLoadRequest" value="${loadRequest.id}" /> <input
								class="menuButton" type="submit" value="Одобрить" />
						</form>

						<form name="rejectingLoadRequest" method="POST" action="rejecting_load_request" style="display: inline;">
							<td><input type="hidden" name="command" value="REJECTLOADREQUEST" /> 
								<input type="hidden"
								name="rejectedLoadRequest" value="${loadRequest.id}" /> <input
								class="menuButton" type="submit" value="Отклонить" />
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<h3 align="center">Заявки на разгрузку</h3>
  <div class = "tableDiv">
  <table>
  <thead>
    <tr>
      <th>Водитель
      <th>Номер машины
      <th>Время подачи заявки
      <th>Продукт
      <th>Статус заявки
      <th>
      <th>
  </thead>
  <tbody>
    <c:forEach var="unloadRequest" items="${unloadRequestInformation}">
  		<tr>
   			<td>${unloadRequest.driver}</td>
    		<td>${unloadRequest.carNumber}</td>
    		<td>${unloadRequest.time}</td>
    		<td>${unloadRequest.product}</td>
    		<td>${unloadRequest.status}</td>
    		<form name="approvingUnloadRequest" method="POST" action="approving_unload_request" style="display: inline;"> 
   				<td><input type="hidden" name="command" value="APPROVEUNLOADREQUEST"/>
   				<input type="hidden" name="approvedUnloadRequest" value="${unloadRequest.id}"/>
   				<c:if test="${unloadRequest.status == 'sent' || unloadRequest.status == 'not approved'}">
  				<input class="menuButton" type="submit" value="Одобрить" />
  				</c:if>
  				<c:if test="${unloadRequest.status == 'approved'}">
  				<input class="menuButtonInactive" type="submit" value="Одобрить" disabled/>
  				</c:if>
   			</form>
    		
    		<form name="rejectingUnloadRequest" method="POST" action="rejecting_unload_request" style="display: inline;"> 
   				<td><input type="hidden" name="command" value="REJECTUNLOADREQUEST"/>
   				<input type="hidden" name="rejectedUnloadRequest" value="${unloadRequest.id}"/>
   				<c:if test="${unloadRequest.status == 'sent' || unloadRequest.status == 'approved'}">
  				<input class="menuButton" type="submit" value="Отклонить"/>
  				</c:if>
  				<c:if test="${unloadRequest.status == 'not approved'}">
  				<input class="menuButtonInactive" type="submit" value="Отклонить" disabled/>
  				</c:if>
   			</form>
 		</tr>
 	</c:forEach>  
  </tbody>
</table>
</div>

<h3 align="center">История заявок на погрузку</h3>
	<div class="tableDiv">
		<table>
			<thead>
				<tr>
					<th>Водитель
					<th>Номер машины
					<th>Время подачи заявки
					<th>Продукт
					<th>Статус заявки
					<th>
					<th>
			</thead>
			<tbody>
				<c:forEach var="loadRequestHistory" items="${loadRequestInformationHistory}">
					<tr>
						<td>${loadRequestHistory.driver}</td>
						<td>${loadRequestHistory.carNumber}</td>
						<td>${loadRequestHistory.time}</td>
						<td>${loadRequestHistory.product}</td>
						<td>${loadRequestHistory.status}</td>
						<form name="approvingLoadRequest" method="POST"
							action="approving_load_request" style="display: inline;">
							<td><input type="hidden" name="command" value="APPROVELOADREQUEST" /> 
								<input type="hidden" name="approvedLoadRequestHistory" value="${loadRequestHistory.id}" />
								<c:if test="${loadRequestHistory.status == 'not approved'}">
				  					<input class="menuButton" type="submit" value="Одобрить" />
				  				</c:if>
				  				<c:if test="${loadRequestHistory.status == 'approved'}">
				  					<input class="menuButtonInactive" type="submit" value="Одобрить" disabled/>
				  				</c:if>
						</form>

						<form name="rejectingLoadRequest" method="POST" action="rejecting_load_request" style="display: inline;">
							<td><input type="hidden" name="command" value="REJECTLOADREQUEST" /> 
								<input type="hidden" name="rejectedLoadRequestHistory" value="${loadRequestHistory.id}" /> 
								<c:if test="${loadRequestHistory.status == 'approved'}">
				  					<input class="menuButton" type="submit" value="Отклонить"/>
				  				</c:if>
				  				<c:if test="${loadRequestHistory.status == 'not approved'}">
				  					<input class="menuButtonInactive" type="submit" value="Отклонить" disabled/>
				  				</c:if>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<h3 align="center">История заявок на разгрузку</h3>
	<div class="tableDiv">
		<table>
			<thead>
				<tr>
					<th>Водитель
					<th>Номер машины
					<th>Время подачи заявки
					<th>Продукт
					<th>Статус заявки
					<th>
					<th>
			</thead>
			<tbody>
				<c:forEach var="unloadRequestHistory" items="${unloadRequestInformationHistory}">
					<tr>
						<td>${unloadRequestHistory.driver}</td>
						<td>${unloadRequestHistory.carNumber}</td>
						<td>${unloadRequestHistory.time}</td>
						<td>${unloadRequestHistory.product}</td>
						<td>${unloadRequestHistory.status}</td>
						<form name="approvingUnloadRequest" method="POST" action="approving_unload_request" style="display: inline;">
							<td><input type="hidden" name="command" value="APPROVEUNLOADREQUEST" /> 
								<input type="hidden" name="approvedUnloadRequestHistory" value="${unloadRequestHistory.id}" />
								<c:if test="${unloadRequestHistory.status == 'not approved'}">
				  					<input class="menuButton" type="submit" value="Одобрить" />
				  				</c:if>
				  				<c:if test="${unloadRequestHistory.status == 'approved'}">
				  					<input class="menuButtonInactive" type="submit" value="Одобрить" disabled/>
				  				</c:if>
						</form>

						<form name="rejectingUnloadRequest" method="POST" action="rejecting_unload_request" style="display: inline;">
							<td><input type="hidden" name="command" value="REJECTUNLOADREQUEST" /> 
								<input type="hidden" name="rejectedUnloadRequestHistory" value="${unloadRequestHistory.id}" /> 
								<c:if test="${unloadRequestHistory.status == 'approved'}">
				  					<input class="menuButton" type="submit" value="Отклонить"/>
				  				</c:if>
				  				<c:if test="${unloadRequestHistory.status == 'not approved'}">
				  					<input class="menuButtonInactive" type="submit" value="Отклонить" disabled/>
				  				</c:if>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>