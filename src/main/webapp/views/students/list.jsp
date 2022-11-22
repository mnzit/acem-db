<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students</title>
</head>
<body>

<h1>Students</h1>

<script>
    function fetchStudents() {
        fetch("http://localhost:8080/api/v1/students")
            .then(response => response.json())
            .then(data => {

                let list = data.data;
                console.log(list);
                let studentTableBody = document.getElementById("studentTableBody");
                console.log(studentTableBody);
                list.forEach((student) => {
                    studentTableBody.appendChild(createRow(student));
                })
            })
            .catch(err => console.error(err));
    }

    function createRow(data) {
        let tr = document.createElement("tr");
        let id = document.createElement("td");
        id.innerText = data.id;
        tr.appendChild(id);
        let name = document.createElement("td");
        name.innerText = data.name;
        tr.appendChild(name);
        let email = document.createElement("td");
        email.innerText = data.email;
        tr.appendChild(email);
        let contactNo = document.createElement("td");
        contactNo.innerText = data.contactNo;
        tr.appendChild(contactNo);

        return tr;
    }
</script>

<button onclick="fetchStudents()">Fetch Students</button>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Contact</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody id="studentTableBody">

    </tbody>
</table>


</body>
</html>