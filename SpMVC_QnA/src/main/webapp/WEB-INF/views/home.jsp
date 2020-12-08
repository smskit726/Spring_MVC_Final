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
</head>
<link href="${rootPath}/static/css/index.css?ver=001" rel="stylesheet">
<script>
	document.addEventListener("DOMContentLoaded", function() {
		let items = document.querySelectorAll(".q-item")
		items.forEach(function(obj){
			obj.addEventListener("click", function() {
				let seq = obj.dataset.seq
				document.location.href = "${rootPath}/detail/"+ seq;
			})
		})
		
		document.querySelector("#btn-home").addEventListener("click",function(){
			document.location.href = "${rootPath}/";
		})
		
		document.querySelector("#btn-new").addEventListener("click",function(){
			document.location.href = "${rootPath}/q_write";
		})
	})
</script>
<body>
<header>
	<h2>QnA</h2>
</header>
<nav>
	<ul>
		<li id="btn-home">Home</li>
		<li id="btn-signIn">Sign In</li>
		<li id="btn-sintUp">Sign Up</li>
	</ul>
</nav>
<table>
	<thead>
		<tr>
			<th width="15%">No</th>
			<th width="15%">작성자</th>
			<th width="70%">제목</th>
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

<div id="btn-box">
	<button id="btn-new" type="button">New</button>
</div>
</body>
</html>