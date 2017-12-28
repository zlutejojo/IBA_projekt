<%@page contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"%>
<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">



<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
    <%-- todo přidat výpis, když je prázdný seznam --%>
    <div>Seznam studentů:</div>

        <jstl:forEach begin="1" end="${studentList.size()}" var="i">
            <div>
                Student/ka ${studentList.get(i-1).surname}
                <a href="studentDetail?index=${i-1}"> Otevřít detail</a>
                <a href="studentEdit?index=${i-1}"> Editovat </a>
            </div>
        </jstl:forEach>
</body>
</html>