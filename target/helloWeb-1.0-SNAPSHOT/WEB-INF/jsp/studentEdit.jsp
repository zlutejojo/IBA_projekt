<%@page contentType="text/html;charset=UTF-8"
        language="java" %>
<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core"
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%--<jsp:useBean id="studentDetail"--%>
             <%--type="cz.IBA.servlet.entity.Student"--%>
             <%--scope="request"/>--%>

<%--<jsp:useBean id="formattedDate"--%>
             <%--type="java.lang.String"--%>
             <%--scope="request"/>--%>


<head>
    <meta charset="UTF-8">
    <title>Hello IBA</title>
</head>
<body>

    <div>Edit:</div>

    <div>Jméno: ${studentEdit.name}</div>
    <div>Příjmení: ${studentEdit.surname}</div>
    <div>Datum narození: ${formattedDate}</div>
    <div>Pohlaví: ${studentEdit.sex}</div>

    <div>
        <form method="post">
            <%--<div>--%>
                <%--Jméno:<input name="name" placeholder="Jana" value="${completedForm.name}">--%>
                <%--<spring:errors path="completedForm.name"></spring:errors>--%>
            <%--</div>--%>
            <%--<div>--%>
                <%--Příjmení:<input name="surname" placeholder="Nováková" value="${completedForm.surname}">--%>
                <%--<spring:errors path="completedForm.name"></spring:errors>--%>
            <%--</div>--%>

            <%--<div>--%>
                <%--Datum narození:<input name="birthday" placeholder="01.02.1999" value="${formatedDate}">--%>
                <%--<spring:errors path="completedForm.birthday"></spring:errors>--%>
            <%--</div>--%>
            <%--<div>Pohlaví:--%>
                <%--<select name="sex" value="${completedForm.sex}">--%>
                    <%--<option value="FEMALE">female</option>--%>
                    <%--<option value="MALE">male</option>--%>
                <%--</select>--%>
            <%--</div>--%>

        </form>
    </div>


</body>
</html>