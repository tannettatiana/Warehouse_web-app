<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driver</title>
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
</body>
</html>