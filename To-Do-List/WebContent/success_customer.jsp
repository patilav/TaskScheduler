<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%

if(session.getAttribute("name")==null)
	{
	response.sendRedirect("index.jsp");
	}
else
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#500000;
color:white;
font-family : verdana;
}
#welcome
{
color:white;
}
</style>
</head>
<body>
<h1><center>CUSTOMER SECTION</center></h1>
<hr>
<h3 id="welcome">Welcome ... <%= session.getAttribute("name") %></h3>
<CENTER>

<bR>
<a href="logout.jsp" style="color:white">LOGOUT</a>

</CENTER>
</body>
</html>