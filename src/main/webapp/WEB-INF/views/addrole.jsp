<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/global.css"/>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        
        <title>Add Role</title>
    </head>
<body>

	<center>
    <Div style="width: 1200px; background-color: #009879; margin: 10px;">
        <h1 style="color: #fff; padding: 10px;">Sample Banking System</h2>
        <ul id = "menu">
            <center>
                <li><a href="/users">Users</a></li>
                <li><a href="/createuser">Create User</a></li>
                <li><a href="/addmenu">Add Menu</a></li>
                <li><a href="/addrole">Add Role</a></li>
                <li><a href="/logout">Logout</a></li>
            </center>
        </ul>
    </Div>
  </center>
  
<center>
    <form:form class="container-form" method="post" action="addrole" modelAttribute="role">
        
        <div>
        <label for="id">Role id</label>
        <form:input type="text" name="id" path="id"/>
        </br>
        	<form:errors path="id" cssClass="error" />
    </div>
    <div>
        <label for="roleName">Role Name</label>
        <form:input type="text" name="roleName" path="roleName"/>
        </br>
        	<form:errors path="roleName" cssClass="error" />
    </div>
    <div>
        <label for="desc">Role Description</label>
        <form:input type="text" id="desc" name="desc" path="desc"/>

		</div>

        <input type="submit" name="Submit" class="btn btn-primary">
        
        <div align="center" style="margin=10px">
			<p style="font-size: 40; color: #FF1C19;">${message}</p>
		</div>

    </form:form>

</center>
    
</body>
</html>