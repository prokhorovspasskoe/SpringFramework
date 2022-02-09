<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Product Add Form</title>
</head>
<body>
    <form action="FormHandler">
        <p>ID Product <input type="text" id="id"></p>
        <p>TITLE <input type="text" id="title"></p>
        <p>COST <input type="text" id="cost"></p>
        <input type="submit" value="Send">
    </form>
</body>
</html>