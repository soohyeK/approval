<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 메인화면</title>
</head>
<body>

	<span>${memberName}(${memberRank})님 환영합니다.</span>
	<button type="button" onclick="location.href='http://localhost:8090/logout'">로그아웃</button>
	<button type="button" onclick="location.href='http://localhost:8090/reg'">글쓰기</button>
	
	<form id="searchFrm" name="searchFrm">
		<select name="opt" id="opt">
			<option value="select">선택</option>
			<option value="memName">작성자</option>
			<option value="boardPayer">결재자</option>
			<option value="content">제목+내용</option>
		</select>
		<input type="text" id="txt" name="txt" placeholder="검색어를 입력하세요" autocomplete="off">
		<select name="status" id="status">
			<option value="payStatus">결재상태</option>
			<option value="save">임시저장</option>
			<option value="waitng">결재대기</option>
			<option value="ing">결재중</option>
			<option value="completed">결재완료</option>
			<option value="reject">반려</option>
		</select>
		<br>
		<input type="date" id="date1" name="date1">~<input type="date" id="date2" name="date2">
		<input type="button" id="btnSearch" name="btnSearch" value="검색">
		<br>
	</form>
	
	<table border = "1">
		
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>결재일</td>
				<td>결재자</td>
				<td>결재상태</td>
			</tr>
		<c:forEach items="${list}" var="list" varStatus="num">
			<tr>
				<td>${list.boardNo}</td>
				<td>${list.memberDTO.memberName}</td>
				<td><a href="${contextPath}/project/detail?boardNo=${list.boardNo}">${list.boardTitle}</a></td>
				<td>${list.boardCreatedDate}</td>
				<td>${list.boardPaymentDate}</td>
				<td>${list.boardPayer}</td>
				<td>${list.boardPaymentStatus}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>