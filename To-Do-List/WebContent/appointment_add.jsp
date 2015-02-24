<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("index.jsp");
	} else {
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate");
	}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Task Scheduler</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<link href="jquery-ui.css" rel="stylesheet">
		<!-- AM added/start -->
		<link href="css/metro-bootstrap.css" rel="stylesheet">
		<link href="css/metro-bootstrap-responsive.css" rel="stylesheet">
		<link href="css/iconFont.css" rel="stylesheet">
		<link href="css/docs.css" rel="stylesheet">
		<link href="js/prettify.css" rel="stylesheet">
		<!-- Load JavaScript Libraries -->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.widget.min.js"></script>
		<script src="js/jquery.mousewheel.js"></script>
		<script src="js/prettify.js"></script>
		<script src="js/carousel.js"></script>		
		<!-- Metro UI CSS JavaScript plugins -->
		<script src="js/load-metro.js"></script>
		<!-- Local JavaScript -->
		<script src="js/docs.js"></script>
		<script src="js/github.info.js"></script>
		<script src="js/metro-tab-control.js"></script>
		<script src="js/metro-calendar.js"></script>
		<script src="js/metro-datepicker.js"></script>
		<!-- AM added/end -->
		
			<script>
		
		function goBack() {
		    window.history.back()
		}
		
		
		function focusOnLogin()
		{
			var id = document.getElementById('1');
			id.focus();
			}

		
		</script>
		
		
	</head>
	<body class="metro" onload="focusOnLogin()">
		<div class="mainDiv">
			<!-- header starts -->
			<div class="header">
				<img src="images/Asha_photo_1_Fotor.jpg" alt="MyOrganizer"/>
			</div>
			<!-- header ends -->
			<!-- nav bar for user and logout starts -->
			<nav class="navigation-bar light">
				<nav class="navigation-bar-content">
					<div class="element">
						<button  class="element icon-user image-button image-left place-right">
						Welcome <%=session.getAttribute("name")%>
						</button>
					</div>
					<a href="logout.jsp" class="element icon-exit image-button image-left place-right">Sign Out</a>
					<span class="element-divider place-right"></span>
					
					<a href="success_customer.jsp" class="element icon-exit image-button image-left place-right">Home</a>
					
				</nav>
			</nav>
			<!-- nav bar for user and logout ends -->
			<!-- add an appointment starts -->
			<div class="tab-control place-center" style="background-color:white;" data-role="tab-control">
				<ul class="tabs">
					<li class="active"><a href="#_page_1"> ADD AN APPOINTMENT </a></li>
				</ul>
				<div class="frames">
					<div class="frame" id="_page_1">
						<div>
							<s:form action="appointmentAdd">
							<s:textfield name="name" label="Name" id="1"></s:textfield>
							<s:textfield id="doa" name="dateOfAppointment" label="Date Of Appointment"
								readonly="true"></s:textfield>
							<s:textfield name="purpose" label="Purpose"></s:textfield>
							<s:textfield name="location" label="Location"></s:textfield>
							<s:textfield name="duration" label="Duration"></s:textfield>
							<s:select label="Priority" name="priority" list='@bean.AppointmentBean$Priority@values()'/>
							<s:submit align="center" value="Submit" />
						
								<div style="margin-top: 20px">
								</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
			<!-- add an appointment ends -->
			<!-- footer starts -->			
			<nav class="navigation-bar light footer" align="center">
				<nav class="navigation-bar-content">
					<ul>
						<li><a onclick="goBack()">Back</a></li>
						
					</ul>
				</nav>
			</nav>
			<p class="footer" align="center">Copyright ©2014 - 2015 <a href="#"> My Organizer </a> All rights reserved.</p>
			<!-- footer ends -->
		</div>
		<script src="js/hitua.js"></script>
		<!-- <center> -->
			<%-- <table align="right">
				<tr>
					<s:url action="homePage.action" var="homePageURL"></s:url>
					<td>Welcome <%=session.getAttribute("name")%></td>
					<td>
						<s:a href="%{homePageURL}"><button>Home</button></s:a>
					</td>
					<td><a href="logout.jsp"><button>Sign out</button></a></td>
				</tr>
			</table>
			<br> <br>
			<hr>
			<table>
				<tr>
					<td class="formHeader">Add an Appointment</td>
				</tr>
				<tr>
					<td>
						<s:form action="appointmentAdd">
							<s:textfield name="name" label="Name"></s:textfield>
							<s:textfield id="doa" name="dateOfAppointment" label="Date Of Appointment"
								readonly="true"></s:textfield>
							<s:textfield name="purpose" label="Purpose"></s:textfield>
							<s:textfield name="location" label="Name"></s:textfield>
							<s:textfield name="duration" label="Duration"></s:textfield>
							<s:select label="Priority" name="priority" list='@bean.AppointmentBean$Priority@values()'/>
							<s:submit align="center" value="Submit" />
						</s:form>
					</td>
				</tr>
			</table>
			<div><a href="success_customer.jsp">Back</a></div>
		</center> --%>
		<script src="external/jquery/jquery.js"></script>
		<script src="jquery-ui.js"></script>
		<script>
			$("#doa").datepicker({
				inline : true,
				dateFormat : "yy-mm-dd"
			});
			
		</script>
	</body>
</html>