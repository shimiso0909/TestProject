<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英単語辞書</title>
</head>
<body>
<form action="SearchSevlet" method="get">
<h2>英単語検索</h2><br><hr>
<input type="text" name="english" pattern="^[0-9A-Za-z]+$" required placeholder="入力してください">（半角英数字のみ）<br>
<input type="submit" value="検索">
</form><br>
<hr>
<form action="menu.jsp" method="get">
<input type="submit" value="メニュー画面へ">
</form>


</body>
</html>