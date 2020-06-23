<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英単語辞書</title>
</head>
<body>
<h2>検索結果</h2>
<hr>
意味: ${word.japanese}<br>
<hr>
<form action="menu.jsp"method="get">
<input type="submit" value="メニューへ戻る">
</form>

</body>
</html>