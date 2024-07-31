<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Register</h1>
    </header>

    <form action="register" method="post">
        <label for="numberPhone">Phone Number:</label>
        <input type="text" id="numberPhone" name="numberPhone" required pattern="\d{10}"
               title="Enter a 10-digit phone number">
        <br>
        <label for="fullName">fullName: </label>
        <input type="text" id="fullName" name="fullName">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">Register</button>
    </form>

</div>
</body>
</html>

