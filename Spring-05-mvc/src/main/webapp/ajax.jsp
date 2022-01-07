<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    在这个页面中引入/js/jquery-3.3.1.js文件--%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList.push({"username":"ZhangSan", "age":18});
        userList.push({"username":"LiSi", "age":20});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/get5",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
