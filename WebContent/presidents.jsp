<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="ovalOfficeInside.css" media="screen" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents Bio Page</title>
<link rel="stylesheet" type="text/css" href="ovalOfficeInside.css"/>
 </head>
<body>
	<fieldset>
	<h2>President ${presidents[currentTerm].firstName} ${presidents[currentTerm].lastName}</h2>
		<form action="presidents.do" method="POST">
			<c:choose>
				<c:when test="${presidents == null}">
					<img src="https://www.whitehouse.gov/sites/default/files/imagecache/gallery_img_full/image/image_file/washington.jpg" />
				</c:when>
				<c:otherwise>
					<img src="${presidents[currentTerm].photo}" />
				</c:otherwise>
			</c:choose>
			
			<table>
				<thead><tr><th colspan="2">Biography</th><tr></thead>
				<tr>
					<td>Term Number:</td>
					<td>${presidents[currentTerm].termNumber}</td>
				</tr>
				<tr>
					<td>Start Year:</td>
					<td>${presidents[currentTerm].startDate}</td>
				</tr>
				<tr>
					<td>End Year:</td>
					<td>${presidents[currentTerm].endDate}</td>
				</tr>
				<tfoot>
				<tr>
					<th>Fun Fact:</th>
					<th>${presidents[currentTerm].funFact}</th>
				</tr>
				</tfoot>
			</table>
			
			<br />
			<button name="operation" value="Previous">Previous</button>
			<button name="operation" value="Home">Home</button>
			<button name="operation" value="Next">Next</button>
			<input type="text" name="termNumber"> 
   			<button  value="submit" >Submit</button>
	</fieldset>
	</form>
</body>
</html>