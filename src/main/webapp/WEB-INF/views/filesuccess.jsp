<%@ page language="java" 
    	 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"
    	 isELIgnored="false"
%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Upload result</title>
	</head>
	<body>
		<h1>${message }</h1>
		<img alt="uploaded image" src="<c:url value="WEB-INF/resources/image/${filename }" />" />
	</body>
</html>