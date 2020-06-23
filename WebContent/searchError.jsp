<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英単語辞書</title>
</head>
<body>
<h2>${english}は登録されていません</h2>
<hr>
<form action="add.jsp" method="get">
<input type="submit" value="単語登録">
</form>
<form action="menu.jsp" method="get">
<input type="submit" value="メニューへ戻る">
</form>


</body>
</html>