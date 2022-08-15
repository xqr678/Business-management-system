<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xqr
  Date: 2022/8/11
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false"
%>
<html>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                   分类管理界面 <small>除了crud还有其他功能</small>

                </h1>
                <span>欢迎你,尊贵的外星人用户:${user.username}</span>
                <a href="/login" >退出登录</a>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
               <c:forEach items="${categories}" var="category" varStatus="st">
                   <tr>
                   <td>${category.id}</td>
                       <td><a href="listProduct?id=${category.id}">${category.name}</a></td>
                       <td><a href="editCategory?id=${category.id}" /><button type="button"  id="edit" class=" btn btn-primary btn-default ">编辑</button> </td>
<%--                       <td><a href="deleteCategory?id=${category.id}" /><button type="button"  id="delete" class=" btn btn-danger btn-default ">删除</button> </td>--%>
                       <td><button type="button" id="${category.id}" class=" btn delete btn-danger btn-default ">删除</button> </td>

                   </tr>
                   </c:forEach>
                </tbody>
            </table>
            <form role="form" action="addCategory">
                <div class="form-group">
                    <label for="name">增加内容</label>
                    <input type="text" class="form-control" id="name" name="name" />
                </div>

                 <button type="submit" class="btn btn-default">增加</button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(function (){
        $('.delete').click(function (){
            let id=$(this).attr("id");
            let url="/deleteCategory";
            let $that=$(this);
            $.get(
                url,
                {"id":id},
                function (result){
                    if (result=="success"){
                        $that.parent().parent().remove();
                    }else {
                        alert("删除失败");
                    }
                }
            )
        })
    })

</script>
</html>
