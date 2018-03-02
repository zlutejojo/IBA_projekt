<%@page contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8" %>

<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core"
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--todo doplnit správné useBeany do všech jsp--%>

<%--<jsp:useBean id="completedForm"--%>
            <%--type="cz.IBA.servlet.entity.Student"--%>
            <%--scope="request"/>--%>

<%--<jsp:useBean id="error"--%>
            <%--type="java.lang.String"--%>
            <%--scope="request"/>--%>

<head>
    <meta charset="UTF-8">
    <title>Hello Student</title>

    <%-- pozor nesmím importovat žádnou knihovnu 2x --%>
    <%-- datepicker --%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>--%>
    <script src="../resources/lib/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="../resources/lib/jquery-ui.min.js"></script>
    <script src="../resources/datePicker.js"></script>

    <%-- validation plugin--%>
    <%-- toto je knihovna, kde funguje fce .format--%>
    <script src="../resources/lib/jquery.validate.min.js"></script>
    <script src="../resources/myValidation.js"></script>
    <script type="text/javascript" src="js/jquery.ui.datepicker.validation.js"></script>
    <link rel="stylesheet" href="../resources/css/error.css">


</head>
<body>
    <form id="form" method="post">
        <div>
            <div>Vyplňte formulář</div>

            ${error}

            <div>
                Jméno:<input name="name" placeholder="Jana" value="${completedForm.name}">
                <spring:errors path="completedForm.name"></spring:errors>
            </div>
            <div>
                Příjmení:<input name="surname" placeholder="Nováková" value="${completedForm.surname}">
                <spring:errors path="completedForm.surname"></spring:errors>
            </div>
            
            <div>
                Datum narození:<input name="birthday" placeholder="10/22/1999" id="datepicker" value="${formattedDate}">
                <spring:errors path="completedForm.birthday"></spring:errors>
            </div>
            <div>Pohlaví:
                <select name="sex" value="${completedForm.sex}">
                    <option value="FEMALE">female</option>
                    <option value="MALE">male</option>
                </select>
            </div>
        </div>
        <div>
            <input type="submit" value="Odeslat"/>
        </div>
    </form>
</body>
</html>