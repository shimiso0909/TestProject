<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
WordBean word=(WordBean)session.getAttribute("dictionary");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英単語辞書</title>
</head>
<body>

<%
	if(word.getJapanese()!=""&&word.getEnglish()!=""){
		out.println("<h2>"+word.getEnglish()+"("+word.getJapanese()+")はすでに登録されています"+"</h2>");
	}else if(word.getEnglish()!=""&&word.getJapanese()==""){
		out.println("<h2>"+"日本語を登録してください"+"</h2>");
	}else if(word.getEnglish()==""&&word.getJapanese()!=""){
		out.println("<h2>"+"英語を登録してください"+"</h2>");
	}else{
		out.println("<h2>"+"英語と日本語を登録してください"+"</h2>");
	}


%>

<hr>
<form action="add.jsp"method="get">
<input type="submit" value="戻る">
</form>
<form action="menu.jsp" method="get">
<input type="submit" value="メニューへ戻る">
</form>

</body>
</html>