<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@include file="include/header.jsp" %>

<%-- <c:forEach var="member" items="${members}">
	${member.mno } , ${member.email } , ${member.pwd } , ${member.mname } , ${member.cre_date } , ${member.mod_date } <br>
</c:forEach> --%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">MEMBER</h1>
          <p class="mb-4">사용자 리스트
          &nbsp;&nbsp;&nbsp;<a href="register">등록</a>
          &nbsp;&nbsp;&nbsp; 로그인 사용자 정보 :  <c:out value="${loginMember.mname }" />
          &nbsp;&nbsp;&nbsp;<a href="../auth/logout">로그아웃</a>
          </p>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">

            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th>
                      <th>이름</th>
                      <th>패스워드</th>
                      <th>이메일</th>
                      <th>작성일</th>
                      <th>수정일</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${members}" var="member">
                    <tr>
                      <td><c:out value="${member.mno }" /></td>
                      <td><a href='update?mno=<c:out value="${member.mno }" />' ><c:out value="${member.mname }" /></a></td>
                      <td><c:out value="${member.pwd }" /></td>
                      <td><c:out value="${member.email }" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.cre_date }" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.mod_date }" /></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->


<%@include file="include/footer.jsp" %>