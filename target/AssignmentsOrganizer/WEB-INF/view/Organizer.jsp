<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Final Exam</title>
</head>
<body data-gr-c-s-loaded="true">
	<div class="container">
		<h1 class="display-4">Assignments Organizer</h1>
		<hr>
	<div>
		<h3 >Add Assignment</h3><br>
		<form action="AddAssignment">
			Course <br>
			<select id="courseid" name="courseid">
				<c:forEach items="${courses}" var="course">
				<option value="${course.id }">${course.number } - ${course.name }</option>
				</c:forEach>
			</select><br><br>
			Assignment Description<br/>
			<input type="text" name="adescription" id="adescription"></input><br><br>
			<input type="submit" value="Add Assignment" name="addAssignment" id="addAssignment" class="btn btn-primary"></input>
		</form>
	</div>
	<div>
		<br>
		<h3>Add Course</h3><br>
		<form action="AddCourse" method="post">
			Course Number<br>
			<input type="text" name="cnumber" id="cnumber"></input><br><br>
			Course Name<br/>
			<input type="text" name="cname" id="cname"></input><br><br>
			<input type="submit" value="Add Course" name="addCourse" id="addCourse" class="btn btn-primary"></input>
		</form>
	</div>
	<div>
		<br>
		<c:forEach items="${courses}" var="course">
			${course.number}
			${course.name }
			<a href="DeleteCourse?deleteCourseId=<c:out value="${course.id }"/>" name="deleteCourseId">[X]</a>
			<div>
				<c:forEach items="${assignments}" var="assignment">
					<c:if test="${course.id == assignment.courseId }">
						<ul>
						<li>
						<c:choose>
							<c:when test="${assignment.status eq 1}">
						<a href="UpdateAssignmentStatus?updateId=<c:out value="${assignment.id}"/>" name="updateId">${assignment.description}</a>
						</c:when>
						<c:otherwise>
							<a href="UpdateAssignmentStatus?updateId=<c:out value="${assignment.id}"/>" name="updateId"><s>${assignment.description}</s></a>
						</c:otherwise>
						</c:choose>
						<a href="DeleteAssignment?deleteId=<c:out value="${assignment.id}"/>" name="deleteId">[X]</a>
						</li>
						</ul>
					</c:if>
				</c:forEach>
			</div>
		</c:forEach>
	</div>
	<div>
		<a href="ArchiveAssignments" class="btn btn-primary">Archive Completed Assignments</a>
	</div>
	</div>
</body>
</html>