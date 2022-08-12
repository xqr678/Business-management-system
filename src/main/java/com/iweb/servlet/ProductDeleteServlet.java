package com.iweb.servlet;

import com.iweb.dao.ProductDAO;
import com.iweb.dao.impl.ProductDAOImpl;
import com.iweb.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XQR
 * @date 2022/8/12 2022/8/12
 * @dsecription 类的描述和介绍
 */
@WebServlet("/deleteProduct")
public class ProductDeleteServlet extends HttpServlet {
    private static ProductDAO dao=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int pid=Integer.parseInt(req.getParameter("id"));
       int cid=dao.get(pid).getCid();
       dao.delete(pid);
//       重定向到/listProduct并且在发送请求的时候携带参数id
//        这样在listproduct运行的时候，才知道访问那个分类的商品列表
       resp.sendRedirect("/listProduct?id="+cid);

    }
}
