<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#500000;
color:white;
font-family : verdana;}
</style>
</head>
<body>
<center>
<h1>EVENT ADD</h1>
<hr>
<br>
<br>
<br>
<br>

<s:form action="eventEdit" >
<s:textfield name="name" label="NAME" value=""></s:textfield>
<s:textfield name="venue" label="VENUE"></s:textfield>
<s:textfield name="startDate" label="START DATE"></s:textfield>
<s:textfield name="endDate" label="END DATE"></s:textfield>
<s:textfield name="occurrence" label="OCCURRENCE"></s:textfield>
<s:submit   align="center" value="SUBMIT"/>
</s:form>
</center>
</body>
</html>