<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <main>
            <h1>Age Calculator</h1>
        
            <form action="age" method="POST">
                <label>Enter your age:</label>
                <input type="text" name="age" value=""/>
                <br>
                <input type="submit" value="Age next birthday"/>
            </form>
            <p>${message}</p>
            
            <a href="/Lab03/arithmetic">Arithmetic Calculator</a>
        </main>
    </body>
</html>
