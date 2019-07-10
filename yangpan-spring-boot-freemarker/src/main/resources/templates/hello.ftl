<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 引入src/resources/static/css下的css文件 -->
    <link rel="stylesheet" href="${request.contextPath }/css/yangpan.css">
    <!-- 引入src/resources/static/js下的js文件 -->
    <script src="${request.contextPath }/js/yangpan.js"></script>
    <title>Document</title>
</head>
<body>
    <p>姓名：${name}</p>
    <p>出生日期：${birthday?string('yyyy-MM-dd hh:mm:ss')}<p/>
    <div>
        爱好：<#list likes as item>${item}</#list>
    </div>
</body>
</html>