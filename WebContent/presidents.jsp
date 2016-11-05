<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents Bio Page</title>
</head>
<body>
<h1> Site Under Construction</h1>
<%! int i = 0; %>
 <fieldset>
    <form action="presidents.do" method="POST">
    <legend>President</legend>
        <img src="${presidents[0].photo}" />
    <br />
    <button name ="operation"  value="Previous">Previous</button>
    <button name ="operation" value="Home">Home</button>
    <button name ="operation" value="Next">Next</button>
	<input type="text" name="${sessionScope.termNumber}" value="${sessionScope.termNumber}"> 
    <button  value="submit" >Submit</button>
  </fieldset>
  </form>
</body>
</html>