<%-- 
    Document   : forgot
    Created on : 28-Nov-2021, 2:11:27 PM
    Author     : kisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password Page</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        
        <p>Please enter your email address to retrieve your password.</p>
        
        <form action="forgot" method="post">
            <div>
                <label>Email Address:</label>
                <input type="email" name="email">
            </div>
            
            <input type="submit" value="Submit">
            
        </form>
        <p>${message}</p>
    </body>
</html>
