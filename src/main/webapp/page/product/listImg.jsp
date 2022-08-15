<%--
  Created by IntelliJ IDEA.
  User: GUAN
  Date: 2022/8/15
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false"
%>
<html>
<head>
    <title>Title</title>


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>图片id </th>
                    <th>图片所属商品</th>
                    <th>删除 </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>

                </tr>
                <tr>
                    <td colspan="3">
                        <form role="form" action="addImg">
                            <div class="form-group">
                                <label for="exampleInputEmail1">电子邮件地址</label><input type="email" class="form-control" id="exampleInputEmail1" />
                            </div>                            <div class="form-group">
                             <input type="hidden" class="form-control" id="pid" name="pid" />
                            </div>
                            <button type="submit" class="btn btn-default">提交</button>
                        </form>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
