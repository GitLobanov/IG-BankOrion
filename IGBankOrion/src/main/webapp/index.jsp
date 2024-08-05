<%@ page import="com.backend.repository.UserRepository" %>
<%@ page import="com.backend.model.User" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Website</title>
    <link rel="icon" href="icon.ico" type="image/x-icon">
</head>
<body>
<h2>Hello Motherfucker</h2>

<%
    UserRepository userRepository = (UserRepository) config.getServletContext().getAttribute("userRepository");


    for (User user : userRepository.findAll()){
        %>

        <p> <%= user.getFullName() %> </p>

        <%


    }

%>

</body>
</html>
