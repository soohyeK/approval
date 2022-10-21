<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	
	$(function(){
		
		var checkID = "${userCnt}";
		var checkPW = "${pwCnt}";
		
		if(checkID != ""){
			if(checkID == 0){
				alert("등록되지 않은 사용자입니다.");
			}else if(checkPW == 0){
				alert("비밀번호가 일치하지 않습니다.");
			}else{
				alert("로그인 성공");
				location.href="http://localhost:8090/list";
			}
		}
		
		
		$("#loginBtn").click(function(){
			
			 var id=$("#id").val();
			 var pw=$("#pw").val(); 
			 
			 if(id == ""){
			  alert("아이디를 입력하세요");
			  $("#id").focus();
			  return;
			}else if(pw==""){
				 alert("비밀번호를 입력하세요"); 
				 $("#passwd").focus();
				  return;
			}else{
				
				$("#loginFrm").attr("action","loginChk").attr("method", "post").submit();
				
			}
			
		})

	})

</script>
</head>
<body>
	<form id="loginFrm" name="loginFrm">
		<h2>Login</h2>
		아이디: <input type="text" name="memberId" id="id"><br>
		비밀번호: <input type="password" name="memberPw" id="pw"><br>
		<input type="button" id="loginBtn" name="loginBtn" value="로그인">
	</form>
</body>
</html>