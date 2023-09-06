<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:red;text-align:center">Register Student</h1>
<frm:form modelAttribute="std">
<table align="center" bgcolor="cyan">
<tr>
<td>Student name::</td>
<td><frm:input path="sname"/> </td>
</tr>
<tr>
<td>Student Qualification::</td>
<td><frm:input path="qualification"/> </td>
</tr>
<tr>
<td>Student Age::</td>
<td><frm:input path="age"/> </td>
</tr>
<tr>
<td>Student Email::</td>
<td><frm:input path="email"/> </td>
</tr>
<tr>
<td><input type="submit" value="submit"/></td>
<td><input type="reset" value="cancel"/></td>
</tr>

</table>
</frm:form>