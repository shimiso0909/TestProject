<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String eng=(String)session.getAttribute("eng");
WordBean wd=(WordBean)session.getAttribute("wd");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英単語辞書</title>
</head>
<body>
<hr>
<%
	if(eng==null){
		out.println("<h2>意味("+wd.getJapanese()+")は登録されていないかすでに削除済です</h2>");
		session.invalidate();
	}else{
		out.println("<h2>英単語("+eng+")は登録されていないかすでに削除済です</h2>");
		session.invalidate();
}
%>

<hr>
<form action="delete.jsp"method="get">
<input type="submit" value="戻る">
</form>
<form action="menu.jsp"method="get">
<input type="submit"value="メニューへ戻る">
</form>

</body>
</html>