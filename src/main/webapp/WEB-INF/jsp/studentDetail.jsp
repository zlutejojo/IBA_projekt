<%@page contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"%>
<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core"
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="studentDetail"
             type="cz.IBA.servlet.entity.Student"
             scope="request"/>

<jsp:useBean id="formattedDate"
             type="java.lang.String"
             scope="request"/>

<head>
    <meta charset="UTF-8">
    <title>Student Detail</title>
</head>
<body>

    <div>Detail studenta:</div>

    <div>Jméno: ${studentDetail.name}</div>
    <div>Příjmení: ${studentDetail.surname}</div>
    <div>Datum narození: ${formattedDate}</div>
    <div>Pohlaví: ${studentDetail.sex}</div>

</body>
</html>