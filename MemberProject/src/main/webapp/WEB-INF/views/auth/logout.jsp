<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<h1> logout 결과</h1>
<b>정상적으로 로그아웃되었습니다..</b>
<a href="login"> 로그인페이지로 이동하시려면 클릭을 아니면 5초후 자동이동합니다.</a>
${name} 
<script>
	setTimeout( function() { window.location='login'; } ,5000);
</script>
<jsp:include page="../include/footer.jsp" />
