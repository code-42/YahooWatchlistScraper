<%@ tag language="java" pageEncoding="ISO-8859-1" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="content" fragment="true" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>${title}</title>
</head>
<body>


	<div id="wrapper">
		<div id="header">
			<a href="index.jsp">Home</a> | 
			<a href="about.jsp">About<a> | 
			<a href="StockControllerServlet">Stock Controller Servlet</a>
		</div>
	</div>
<br>
<jsp:invoke fragment="content"></jsp:invoke>
<br>
<!-- FOOTER -->

<footer>
	<p id="footer">&copy; 2017 Edward Dupre &middot; <a href="https://code-42.github.io/my_portfolio">My Portfolio</a> &middot; <a href="#">Back to top</a></p>
</footer>

</body>
</html>