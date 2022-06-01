<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <main>
            <h1>Arithmetic Calculator</h1>

            <form action="arithmetic" method="POST">
                <label>First:</label>
                <input type="text" name="first">
                <br>
                <label>Second:</label>
                <input type="text" name="second">
                <br>
                <input type="submit" value="+" name="operator">
                <input type="submit" value="-" name="operator">
                <input type="submit" value="/" name="operator">
                <input type="submit" value="*" name="operator">
            </form>
            <p>Result: ${message}</p>

            <a href="/Lab03/age">Age Calculator</a>
        </main>
    </body>
</html>
