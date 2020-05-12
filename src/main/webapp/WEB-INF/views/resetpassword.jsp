<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    
    <title>Users</title>
    
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

	<form method="post" action="resetpassword" modelAttribute="postId">
    <center>

        <h1 style="font-size: 50px; color: #009879;">Reset Password</h1>

        <p style="font-size: 30px;">Employee Id: ${user.id}</p>
        <p style="font-size: 30px;">Name: ${user.name } ${user.lastName }</p>
        <p style="font-size: 30px;">Email: ${user.email }</p>
        </br>
        <input type="hidden" name="id" value="${user.id}"/>
        <input type="submit" value="Reset" name="Reset" class="btn btn-primary">
        
        <div style="margin:10px; font-size: 40px; color: #009879;"> ${message} </div>

    </center>
    
    </form>
</body>
</html>