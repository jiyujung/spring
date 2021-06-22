<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, ex02.*"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table align="center"  width="100%">
	<tr align="center" bgcolor="#99ccff">
		<td width="7%" >아이디</td>
	    <td width="7%">비밀번호</td>
	    <td width="5%" >이름</td>
	    <td width="11%" >이메일</td>
	    <td width="5%" >가입일</td>
	</tr>
	<c:choose>
		<c:when test="${membersList==null }">
			<tr>
				<td colspan=5>
				<b>등록된 회원이 없습니다.</b>
				</td>
			</tr>
		</c:when>
		<c:when test="${membersList != null}">
			<c:forEach var="mem" items="${membersList }"> <!-- for문 돌릴 때 i 역할이 var 반복횟수는 items -->
				<tr align = "center">
					<td>${mem.id }</td>
					<td>${mem.pwd }</td>
					<td>${mem.name }</td>
					<td>${mem.email }</td>
					<td>${mem.joinDate }</td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
</table>
</body>
</html>