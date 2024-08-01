<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Warehouseman</title>
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

</body>
</html>