<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    <title>Open Account</title>
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


    <form:form class="container-form" method="post" action="openaccount" modelAttribute="account">
        
        <div>
        	<label for="acNumber">Account Number</label>
        	<form:input type="text" name="acNumber" path="acNumber"/>
        	</br>
        	<form:errors path="acNumber" cssClass="error" />
    	</div>
    	<div>
        	<label for="customerName">Customer Name</label>
        	<form:input type="text" name="customerName" path="customerName"/>
        	</br>
        	<form:errors path="customerName" cssClass="error" />
    	</div>
    	<div>
        	<label for="fathersName">Father's Name</label>
        	<form:input type="text" name="fathersName" path="fathersName"/>
        	</br>
        	<form:errors path="fathersName" cssClass="error" />
    	</div>
    	<div>
        	<label for="mothersName">Mother's Name</label>
        	<form:input type="text" name="mothersName" path="mothersName"/>
        	</br>
        	<form:errors path="mothersName" cssClass="error" />
    	</div>
    	<div>
        	<label for="dob">Date of Birth</label>
        	<form:input type="date" name="dob" path="dob"/>
        	</br>
        	<form:errors path="dob" cssClass="error" />
    	</div>
    	<div>
        	<label for="createDate">Account Create Date</label>
        	<form:input type="date" name="createDate" path="createDate"/>
        	</br>
        	<form:errors path="dob" cssClass="error" />
    	</div>
    	<div>
    	<label for="address">Address</label>
        	<form:input type="text" name="address" path="address"/>
        	</br>
        	<form:errors path="address" cssClass="error" />
    	</div>
    	<div>
    	<label for="nid">National ID</label>
        	<form:input type="text" name="nid" path="nid"/>
        	</br>
        	<form:errors path="nid" cssClass="error" />
    	</div>
    	<div>
    	<label for="phoneNo">Phone No</label>
        	<form:input type="text" name="phoneNo" path="phoneNo"/>
        	</br>
        	<form:errors path="phoneNo" cssClass="error" />
    	</div>
    	<div>
        <label for="acType" style="text-align: left; width: 240px;">Account Type</label>
        <form:select name="acType" path="acType">
            <c:forEach items = "${actypes}" var = "type">
                <option>${type.acTypeName}</option>
             </c:forEach>
        </form:select>
    	</div>
    	
    	<input type="hidden" name="balance" value="0.0"/>
    	
        <input type="submit" name="Submit" class="btn btn-primary">
        
        
        <div align="center" style="margin=10px">
			<p style="font-size: 40; color: #FF1C19;">${message}</p>
		</div>
					
       
    </form:form>
</body>
</html>