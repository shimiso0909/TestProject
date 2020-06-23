<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英単語辞書</title>
</head>
<body>
<h2>単語削除</h2>
<hr>
<form action="DeleteServlet" method="get">
英単語から削除：<input type="text" name="english" pattern="^[0-9A-Za-z]+$" required placeholder="入力してください">"WebContent/addResult.jsp"（半角英数字のみ）
<input type="submit" value="削除">
</form>
<hr>
<form action="DeleteServlet" method="get">
意味から削除：<input type="text" name="japanese" pattern=".*\S+.*" required placeholder="入力してください">
<input type="submit" value="削除">
</form>

<form action="menu.jsp" method="get">
<input type="submit" value="メニューへ戻る">
</form>




</body>
</html>