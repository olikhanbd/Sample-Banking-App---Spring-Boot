<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    <title>Settings</title>
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    
    
    <center>
    <Div style="width: 1200px; background-color: #009879; margin: 10px;">
        <h1 style="color: #fff; padding: 10px;">Sample Banking System</h2>
        <ul id = "menu">
            <center>
                <li><a href="/accounts">Accounts</a></li>
                <li><a href="/search">Search</a></li>
                <li><a href="/openaccount">Open Account</a></li>
                <li><a href="/settings">Settings</a></li>
                <li><a href="/logout">Logout</a></li>
            </center>
        </ul>
    </Div>
  </center>


    <form:form class="container-form" method="post" action="changepass" modelAttribute="changePassModel">
        
    	<div>
        	<label for="oldPass">Old Password</label>
        	<form:input type="password" name="oldPass" path="oldPass"/>
        	</br>
        	<form:errors path="oldPass" cssClass="error" />
    	</div>
    	
    	<div>
        	<label for="newPass">New Password</label>
        	<form:input type="password" name="newPass" path="newPass"/>
        	</br>
        	<form:errors path="newPass" cssClass="error" />
    	</div>
    	
        <input type="submit" name="Submit" class="btn btn-primary">
        
        
        <div align="center" style="margin=10px">
			<p style="font-size: 40; color: #FF1C19;">${message}</p>
		</div>
					
       
    </form:form>
</body>
</html>