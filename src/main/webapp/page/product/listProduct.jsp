<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xqr
  Date: 2022/8/12
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false"
%>
<jsp:include page="../include/header.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          Pokemmo分组
        </h1>
      </div>
      <table class="table">
        <thead>
        <tr>
          <th>id</th>
          <th>名称</th>
          <th>价格</th>
          <th>库存</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product" varStatus="st">
          <tr>
            <td>
              <c:if test="${empty product.images}">
                <img width="100px" height="100px" src="/img/img.jpg" class="img-rounded" />
            </c:if>
              <c:if test="${!empty product.images}">
                <img width="100px" height="100px" src="${product.images.get(0).url}" class="img-rounded" />
              </c:if>
            </td>

            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td><a href="editProduct?id=${product.id}" /><button type="button"  id="edit" class=" btn btn-primary btn-default ">编辑</button> </td>
            <td><a href="deleteProduct?id=${product.id}" /><button type="button"  id="delete" class=" btn btn-danger btn-default ">删除</button> </td>
            <td><a href="listImg?id=${product.id}"><span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span></a> </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <form role="form" action="addProduct">
        <div class="form-group">
          <label for="name">商品名称</label>
          <input type="text" class="form-control" id="name" name="name" />
          <label for="price">商品价格</label>
          <input type="text" class="form-control" id="price" name="price" />
          <label for="stock">商品库存</label>
          <input type="text" class="form-control" id="stock" name="stock" />

          <input type="hidden" class="form-control" id="cid" name="cid" value="${cid}" />
        </div>

        <button type="submit" class="btn btn-default">增加</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
