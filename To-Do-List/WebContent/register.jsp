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
<h1>REGISTER</h1>
<hr>
<br>
<br>
<br>
<br>

<s:form action="register" >
<s:textfield name="username" label="USERNAME"></s:textfield>
<s:textfield name="fname" label="FIRST NAME"></s:textfield>
<s:textfield name="lname" label="LAST NAME"></s:textfield>
<s:textfield name="dob" label="DATE OF BIRTH"></s:textfield>
<s:password name="password" label="PASSWORD"></s:password>
<s:password name="confirmPassword" label="CONFIRM PASSWORD"></s:password>
<s:textfield name="secretQuestion" label="SECRET QUESTION"></s:textfield>
<s:textfield name="secretAnswer" label="ANSWER"></s:textfield>
<s:submit   align="center" value="SUBMIT"/>
</s:form>
</center>
</body>
</html>