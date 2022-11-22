<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students</title>
</head>
<body>

<h1>Students</h1>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Contact</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${requestScope.students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.contactNo}</td>
            <td>${student.email}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>


</body>
</html>