<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp" />
<h1> insert 결과</h1>
<b>에러입니다..</b>
<a href="register"> 다시 입력하시기 바랍니다. 3초뒤 이동합니다 </a>
<script>
	setTimeout( function() { window.location='register'; } ,5000);
</script>
<jsp:include page="./include/footer.jsp" />
