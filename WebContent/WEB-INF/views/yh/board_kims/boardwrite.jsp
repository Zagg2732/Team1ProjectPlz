<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
	<link rel="stylesheet" href="css/yh/bootstrap.css"> <!-- 참조  -->

<title>Kim's Board 글쓰기</title>
</head>
<body>

	<c:set var="userInfo" value="${sessionScope.userInfo}" />
<%
    String userid = null; // 로그인이 된 사람들은 로그인정보를 볼수 있도록한다
    if (session.getAttribute("userid") != null)
    {
    	userid = (String)session.getAttribute("userid");
    }
%>
    <nav class ="navbar navbar-default">
        <div class="navbar-header"> <!-- 홈페이지의 로고 -->
            <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                aria-expand="false">
                <span class ="icon-bar"></span> <!-- 줄였을때 옆에 짝대기 -->
                <span class ="icon-bar"></span>
                <span class ="icon-bar"></span>
            </button>
            <a class ="navbar-brand" href="indexyh.jsp">Kim's Board</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="indexyh.jsp">메인</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/kimslist.kims">게시판</a></li>
            </ul>
            <%
            // 접속하기는 로그인이 되어있지 않은 경우만 나오게한다
                if(userid == null)
                {
            %>
            <ul class="nav navbar-nav navbar-right">
            <li>${sessionScope.userInfo.userId}님 환영합니다&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li class="dropdown">
                <a href="#" class = "dropdown-toggle"
                    data-toggle="dropdown" role ="button" aria-haspopup="true"
                    aria-expanded="false">접속하기<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="Login.team1">로그인</a></li>
                        <li><a href="${pageContext.request.contextPath}/Register.team1">회원가입</a></li>                    
                    </ul>
                </li>
            </ul>
             <%
            // 로그인이 되어있는 사람만 볼수 있는 화면
                } else {
            %> 
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                <a href="#" class = "dropdown-toggle"
                    data-toggle="dropdown" role ="button" aria-haspopup="true"
                    aria-expanded="false">회원관리<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="Login.team1">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
             <%
                }
            %>
        </div>
    </nav>
    <div class="container">
        <div class="row">
        <form name="bbs" method="post" action="${pageContext.request.contextPath}/kimswriteok.kims">
        <input type="hidden" name="userid" value="${userInfo.userId}" id="userid">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                        <th colspan="2" style="background-color:#eeeeee; text-align:center;">게시판 글쓰기 양식</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    	<td><input type="text" class="form-control" placeholder="글 제목"  name="subject" maxlength="50" ></td>
                    </tr>
                    <tr>
                    	<td><textarea class="form-control" placeholder="글 내용"  name="content" maxlength="2048" style="height:350px" ></textarea></td>
                    </tr>
                </tbody>
            </table>
                <input type="submit"  class="btn btn-primary pull-right" value="글쓰기">
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/yh/bootstrap.js"></script>
</body>
	<script type="text/javascript">
	function check() {
		if (!bbs.subject.value) {
			alert("제목을 입력해 주세요");
			bbs.subject.focus();
			return false;
		}

		if (!bbs.content.value) {
			alert("내용을 입력해 주세요");
			bbs.content.focus();
			return false;
		}

		document.bbs.submit();
	}
	</script>
</html>
