<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>새글작성</title>
</head>
<body>
	<form:form modelAttribute="QUESTION">
		<div>
			<form:input path="q_seq" type="hidden"/>
		</div>
		<div>
			<label for="q_date">작성일자</label>
			<form:input path="q_date" readonly="true"/>
		</div>
		<div>
			<label for="q_time">작성시각</label>
			<form:input path="q_time" readonly="true"/>
		</div>
		<div>
			<label for="q_writer">작성자</label>
			<form:input path="q_writer"/>
		</div>
		<div>
			<label for="q_title">제목</label>
			<form:input path="q_title"/>
		</div>
		<div>
			<label for="q_content">내용</label>
			<form:input path="q_content"/>
		</div>
		
		<div>
			<button>저장</button>
		</div>
	</form:form>
</body>
</html>