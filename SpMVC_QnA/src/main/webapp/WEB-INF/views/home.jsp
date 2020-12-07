<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>title</title>
<script>
	document.addEventListener("DOMContentLoaded", function(){
		let items = document.querySelectorAll(".q-item")
		items.forEach(function(obj){
			obj.addEventListener("click", function() {
				let seq = obj.dataset.seq
				document.location.href = "${rootPath}/detail/"+ seq;
			})
		})
	})
</script>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>No</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${QUESTIONS}" var="q" varStatus="i">
			<tr class="q-item" data-seq="${q.q_seq}">
				<td>${i.count}</td>
				<td>${q.q_writer}</td>
				<td>${q.q_title}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="${rootPath}/q_write">새로작성</a>
</body>
</html>