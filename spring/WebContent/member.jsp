<%@ page language="java"   contentType="text/html; charset=UTF-8"
     import="java.util.*,ex0623.*" 
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8"); // 한글 부분 나오게 하기 위해서 있음(없으면 깨짐)
%>    

<%
//request로 memberform.html에서 값을 받아옴(그 값들을 String ____ 에 넣음)
   String   id=request.getParameter("id");
   String  pwd = request.getParameter("pwd");
   String  name = request.getParameter("name");
   String  email = request.getParameter("email");
 
  //bean값으로 전달 addMember로 값을 추가
   MemberBean  m =  new MemberBean(id, pwd, name, email);
   MemberDAO  memberDAO=new MemberDAO();
   memberDAO.addMember(m);
   List membersList = memberDAO.listMembers();	//리스트를 만들어줌
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 목록창</title>
</head>
<body>
<!-- 회원 리스트 출력 -->
  <table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	      <td width="7%" >아이디</td>
	      <td width="7%">비밀번호</td>
	      <td width="5%" >이름</td>
	      <td width="11%" >이메일</td>
	      <td width="5%" >가입일</td>
	   </tr>
	<%
	   if(membersList.size()==0){  //회원이 없을 때
	%>
	  <tr>
	      <td colspan="5">
	        <p align="center"><b><span style="font-size:9pt;">
	                      등록된 회원이  없습니다.</span></b></p>
	      </td>
	  </tr>
	<%
	}else{  //회원 출력
	   for( int i = 0; i < membersList.size(); i++ ) {
	      MemberBean bean = (MemberBean) membersList.get(i);
	%>
	   <tr align="center">
	       <td><%=bean.getId() %></td>
	       <td><%=bean.getPwd() %></td>
	       <td><%=bean.getName() %></td>
	       <td><%=bean.getEmail() %></td>
	       <td><%=bean.getJoinDate() %></td>
	   </tr>
	<%
	      } // end for
	
	   } // end if
	%>
	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
