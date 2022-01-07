<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/get10" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="username"> <br/>
        文件一：<input type="file" name="uploadFile1"> <br/>
        文件二：<input type="file" name="uploadFile2"> <br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
