<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="shortcut icon" href="/pic/userPath/1.png">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery-3.4.1.js"></script>
    <script src="/static/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/static/css/admin/admin-item.css">
</head>
<body>
<h1>章节管理</h1><br>
<%
    Object o = request.getAttribute("isFlag");
    if (o == null) {
        request.setAttribute("isFlag", false);
    }
%>
<div class="panel panel-default">
    <!-- 搜索部分 -->
    <div class="panel-body">
        <form class="form-inline" method="get" action="/getChapterByNumber">
            <input type="hidden" name="comicid" value="${comicid}">
            <div class="form-group">
                <label for="comicName">章节数</label>
                <input type="text" class="form-control" id="comicName" name="cnumber" value="${cnumber}">
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
</div>
<a href="/tz?${comicsid}" class="btn btn-primary">添加章节</a>
<table class="table table-striped">
    <thead class="thead-light">
    <tr>
        <th>#</th>
        <th>章节数</th>
        <th>章节名</th>
        <th>上传时间</th>
        <th>章节内容</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${chapterList.list}" var="user" varStatus="i">
        <tr>
            <td>${i.count+(chapterList.pageNum-1)*5}</td>
            <td>${user.chapternum}</td>
            <td>${user.chaptername}</td>
            <td>
                    <fmt:formatDate value="${user.uploadtime}" pattern="yyyy-MM-dd"></fmt:formatDate>
            </td>
            <td style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 5;">${user.content}</td>
            <td>
                <a href="#" class="btn btn-danger btn-xs" onclick="deleteUser(${user.id})">删除章节</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${!isFlag}">
    <div class="col-md-12 text-right">
        <nav>
            <ul class="pagination">
                <li><a href="/chapterList?pn=1&comicid=${comicid}">首页 </a></li>
                <li><a href="/chapterList?pn=${chapterList.pageNum-1}&comicid=${comicid}">上一页 </a></li>
                <li><a href="#">${chapterList.pageNum}</a></li>
                <li><a href="/chapterList?pn=${chapterList.pageNum+1}&comicid=${comicid}">下一页</a></li>
                <li><a href="/chapterList?pn=${chapterList.pages}&comicid=${comicid}">尾页</a></li>
            </ul>
        </nav>
    </div>
</c:if>
<script type="text/javascript">
    //删除章节
    function deleteUser(id) {
        if (confirm('确实要删除该章节吗?')) {
            var url = "/deleteChapterById";
            var args = {"id": id};
            $.post(url, args, function (data) {
                if (data == 'true') {
                    alert("章节删除更新成功！");
                    //页面刷新
                    window.location.reload();
                }
                else {
                    alert("删除失败");
                    window.location.reload();
                }

            });
        }
    }
</script>
</body>
</html>
