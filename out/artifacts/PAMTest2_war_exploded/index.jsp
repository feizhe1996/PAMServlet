<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<form action="/PAMTest2_war_exploded/PAMServlet" method="post">
  Name:<input type="text" name="name" />
  Password:<input type="password" name="password" />

  <input type="submit" value="Login" />
</form>

<%if (request.getAttribute("name") != null) {%>
Your input name is:
<%=request.getAttribute("name")%>
<br>
Your input password is:
<%=request.getAttribute("password")%>
<br>
Your Authentication Result is:
<%=request.getAttribute("result")%>
<br>
<br>
<% } %>
<%if (request.getAttribute("shell")!= null) { %>
<br>
user shell is:
<%=request.getAttribute("shell")%>
<br>
user dir is:
<%=request.getAttribute("dir")%>
<br>
user groups are:
<%=request.getAttribute("groups")%>
<br>
uid is:
<%=request.getAttribute("uid")%>
<% } %>
</body>
</html>