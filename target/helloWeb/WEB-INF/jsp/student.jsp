<%@page contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8" %>

<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core"
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<head>
    <meta charset="UTF-8">
    <title>Hello Student</title>
</head>
<body>
    <form method="post">
        <div>
            <div>Vyplňte formulář</div>
            <div>Jméno:<input name="name" placeholder="Jana"></div>
            <div>Příjmení:<input name="surname" placeholder="Nováková"></div>
            <div>Datum narození:<input name="birthday" placeholder="1. 10. 1999"></div>
            <div>Pohlaví:
                <select name="sex">
                    <option>female</option>
                    <option>male</option>
                </select>
            </div>
        </div>
        <div>
            <input type="submit" value="Odeslat"/>
        </div>
    </form>
</body>
</html>