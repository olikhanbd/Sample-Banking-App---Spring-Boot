<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    <title>Create User</title>
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
                <li><a href="/">Users</a></li>
                <li><a href="/createuser">Create User</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="#">Logout</a></li>
            </center>
        </ul>
    </Div>
  </center>


    <form class="container-form" method="post" action="updateuser">
        
        <div>
        	<label for="id">id</label>
        	<input type="text" name="id" readOnly value = "${user.id }"/>
    	</div>
    	<div>
        	<label for="name">First Name</label>
        	<input type="text" name="name" value = "${user.name }"/>
    	</div>
    	<div>
        	<label for="lastName">Last Name</label>
        	<input type="text" name="lastName" value = "${user.lastName }"/>
    	</div>
    	<div>
        	<label for="email">Email</label>
        	<input type="text" name="email" value = "${user.email }" readOnly/>
    	</div>
    	<div>
        	<label for="mobile">Mobile</label>
        	<input type="text" name="mobile" value = "${user.mobile }"/>
    	</div>
    	<div>
        	<input type="hidden" name="password" value = "${user.password }"/>
    	</div>
    	<div>
        	<input type="hidden" name="status" value = "${user.status }"/>
    	</div>
    	<div>
        <label for="role" style="text-align: left; width: 240px;">Role</label>
        <select name="role">
            <option>Admin</option>
            <option>User</option>
        </select>
    	</div>
        <input type="submit" name="Submit" class="btn btn-primary">
       
    </form>
</body>
</html>