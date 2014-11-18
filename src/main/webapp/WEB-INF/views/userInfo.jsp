<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> Users is ${user.id}, ${user.name}, ${user.email}, ${user.level}, ${user.login}, ${user.recommend}. </P>
</body>
</html>
