<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Index</title>
</head>
<body class="index-bg">
    <div class="container" id="container">
        <div class="form-container secondary-container">
            <form:form cssClass="form-css" action="processLogin" modelAttribute="loginData">
                <h1>Signup</h1>
                <div>
                    <form:input cssClass="in-fields" placeholder="Email" path="email"/>
                    <form:errors path="email" cssClass="error"/>
                    <br>
                    <form:password cssClass="in-fields" placeholder="Password" path="password"/>
                    <form:errors path="email" cssClass="error"/>
                    <br>
                    <input class="sbm-btn" type="submit" value="Submit"/>
                </div>
            </form:form>
        </div>
        <div class="text-container">
            <div class="text">
                <div class="panel text-right">
                    <h1>Spring MVC, Hibernate, JSP</h1>
                    <p>This is a login form created using Spring MVC, Hibernate and JSP pages.
                </div>
            </div>
        </div>
    </div>
</body>
</html>