<%@page contentType="text/html;charset=UTF-8"
        language="java" %>
<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core"
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
    <meta charset="UTF-8">
    <title>Hello IBA</title>
</head>
<body>
    <jstl:forEach begin="1" end="${paramX}">
        <div>Hello IBA!</div>
    </jstl:forEach>
</body>
</html>