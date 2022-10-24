<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>

	

	$(function(){
		
		
			
		})
	})
	
</script>
</head>
<body>
	<div>
		<table border = "1">
				<tr>
					<th>결재요청</th>
					<th>과장</th>
					<th>부장</th>
				</tr>
				<tr>
					<td><input type = "checkbox" name = "sign" id = "noSign" disabled="disabled"></td>
					<td><input type = "checkbox" name = "sign" id = "oneSign" disabled="disabled"></td>
					<td><input type = "checkbox" name = "sign" id = "twoSign" disabled="disabled"></td>
				</tr>
		</table>
	</div>
		
	<form name = "regFrm" id = "regFrm">
		<input type = "hidden" name = "status" id = "status">
		<input type = "hidden" name = "memberId" id = "memberId"> 
		<div>
			<table>
				<tr>
					<th>글번호</th>
					<td><input type = "text" name = "boardNo" id = "boardNo" value = "${seq }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type = "text" name = "memberName" id = "memberName" value = "${detailMap.memberName }" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type = "text" name = "subject" id = "subject" value = "${detailMap.apprSubject }" placeholder="제목을 입력하세요" readonly="readonly"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="5" cols="25" name = "content" id = "content" placeholder="내용을 입력하세요" readonly="readonly">${detailMap.apprContent }</textarea></td>
				</tr>
			</table>
		</div>
	</form>
	
	<div>
	
		<input type = "button" name = "tmpBtn" id = "tmpBtn" value = "임시저장">
		<input type = "button" name = "refBtn" id = "refBtn" value = "반려">
		<input type = "button" name = "appBtn" id = "appBtn" value = "결재">
	</div>
		
		
		
	<div>
		<table border = "1">
			<tr>
				<th>번호</th>
				<th>결재일</th>
				<th>결재자</th>
				<th>결재상태</th>
			</tr>
			<c:forEach items="${appHistory }" var = "his">
				<tr> 
					<td>${his.boardNo }</td>
					<td>${his.boardSignDate}</td>
					<td>${his.boardApprover }</td>
					<td>${his.boardSignStatus }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	

</body>
</html>