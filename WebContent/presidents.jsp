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
		<form action="presidents.do" method="POST">
			<c:choose>
				<c:when test="${presidents == null}">
					<h2>President George Washington</h2>
				
					<img src="https://www.whitehouse.gov/sites/default/files/imagecache/gallery_img_full/image/image_file/washington.jpg" />
					<table>
						<thead>
							<tr>
								<th colspan="2">Biography</th>
							<tr>
						</thead>
						<tr>
							<td>Term Number:</td>
							<td>1</td>
						</tr>
						<tr>
							<td>Start Year:</td>
							<td>1789</td>
						</tr>
						<tr>
							<td>End Year:</td>
							<td>1797</td>
						</tr>
						<tfoot>
							<tr>
								<th>Fun Fact:</th>
								<th>In 1967, to ensure that he would never be outranked,
									George Washington was awarded the highest military rank that
									will ever be bestowed: General of the Armies of the United
									States.</th>
							</tr>
						</tfoot>
					</table>
				</c:when>
				<c:otherwise>
					<h2>President ${presidents[currentTerm].firstName} ${presidents[currentTerm].lastName}</h2>
				
					<img src="${presidents[currentTerm].photo}" />
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
				</c:otherwise>
			</c:choose>
			
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