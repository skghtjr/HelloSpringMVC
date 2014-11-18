<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> Users is ${user.id}, ${user.name}, ${user.email}, ${user.level}, ${user.login}, ${user.recommend}. </P>

<table>
<c:forEach var="user" items="${users}" varStatus="status">
<tr>
<td align="center" class="listtd"><c:out value="${status.count}"/></td>
<td align="center" class="listtd"><c:out  value="${user.id}"/>')"><c:out value="${result.id}"/></td>
<td align="left" class="listtd"><c:out value="${user.name}"/> </td>
<td align="center" class="listtd"><c:out value="${user.email}"/> </td>
<td align="center" class="listtd"><c:out value="${user.level}"/> </td>
<td align="center" class="listtd"><c:out value="${user.login}"/> </td>
<td align="center" class="listtd"><c:out value="${user.recommend}"/> </td>
</tr>
</c:forEach>
</table>


</body>
</html>
