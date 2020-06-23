<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英単語辞書</title>
</head>
<body>
<h2>単語登録</h2>
<hr>
<form action="AddSevlet" method="get">
英語:<input type="text" name="english" pattern="^[0-9A-Za-z]+$" placeholder="入力してください" title="スペースだめ">(半角英数字のみ)<br>
　意味:<input type="text" name="japanese" pattern=".*\S+.*" required placeholder="入力してください">
<input type="submit" value="登録">
</form>
<hr>
<form action="menu.jsp" method="get">
<input type="submit" value="メニューへ戻る">
</form>

</body>
</html>