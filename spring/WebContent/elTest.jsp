<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어</title>
</head>
<body>
<h1>표현언어로 여러 가지 데이터 출력하기</h1>
\${100} : ${100 }<br>
\${"안녕하세요"} : ${"안녕하세요"}<br>
\${10+1} : ${10+1}<br>
\${"10"+1} : ${"10"+1 }<br>
	\${null+10 } : ${null+10 }<br>
	\${10+10} : ${10+10}<br>
	\${20-10} : ${20-10}<br>
	\${20!=10} : ${20!=10}<br>
	\${10*10} : ${10*10}<br>
	\${100/9} : ${100/9}<br>
	\${100%9} : ${100%9}<br>
	\${100 mod 9} : ${100 mod 9}<br>
	\${10==10} : ${10==10}<br>
	\${10 eq 10} : ${10 eq 10}<br><br>
</body>
</html>