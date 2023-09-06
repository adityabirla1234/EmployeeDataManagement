<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>	
<c:choose>
<c:when test="${!empty stdList}">
<h1 style="color:red;text-align:center">Student Report</h1>
<table border="1" align="center" bgcolor="cyan">
<tr style="color:red"><th>sno</th><th>std name</th><th>Qualification</th><th>age</th><th>email</th><th>operations</th></tr>
<c:forEach var="std" items="${stdList}">
<tr style="color:blue">
<td>${std.sno}</td>
<td>${std.sname}</td>
<td>${std.qualification}</td>
<td>${std.age}</td>
<td>${std.email}</td>
<td><a href="std_edit?no=${std.sno}"><img src="images/edit.png" width="30px" height="30px"/></a>
<!--   <a href="emp_delete?no=${emp.empno}" onclick="return confirm('Do you want to delete employee')"><img src="images/delete.png" width="30px" height="30px"/></a>-->
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;test-align:center">Student not found</h1>
</c:otherwise>
</c:choose>
<h3 style="color:blue;text-align:center">${saveResultMsg}</h3>
<center><a href="./"><img src="images/home.png" width="40px" height="50px"/></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="std_add"><img src="images/add.png" width="40px" height="50px"/></a></center>
