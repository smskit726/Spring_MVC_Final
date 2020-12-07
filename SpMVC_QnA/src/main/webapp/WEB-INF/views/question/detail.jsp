<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>detail</title>
<script>
	document.addEventListener("DOMContentLoaded", function(){
		let seq = ${QUESTION.q_seq}
		
		document.querySelector("#btn-update").addEventListener("click", function(){
			document.location.href = "${rootPath}/update/" + seq
		})
		
		document.querySelector("#btn-delete").addEventListener("click", function(){
			document.location.replace("${rootPath}/delete/" + seq)
		})
	})
</script>
</head>
<body>
	<section id="question-box">
		<div>작성일시</div>
		<div>${QUESTION.q_date} / ${QUESTION.q_time}</div>
		<div>작성자</div>
		<div>${QUESTION.q_writer}</div>
		<div>제목</div>
		<div>${QUESTION.q_title}</div>
		<div>내용</div>
		<div>${QUESTION.q_content}</div>
	</section>
	
	<section id="answer-box">
	
	</section>
	
	<div id="btn-box">
		<button type="button" id="btn-update">질문 수정</button>
		<button type="button" id="btn-delete">질문 삭제</button>
	</div>
</body>
</html>