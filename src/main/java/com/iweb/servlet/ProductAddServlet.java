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
@WebServlet("/addProduct")
public class ProductAddServlet extends HttpServlet {
    private static ProductDAO dao=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        Float price=Float.parseFloat(req.getParameter("price"));
        int stock=Integer.parseInt(req.getParameter("stock"));
        int cid=Integer.parseInt(req.getParameter("cid"));
//        将数据封装在对象中
        Product p=new Product();
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        p.setCid(cid);
//        数据入库
        dao.add(p);
        resp.sendRedirect("/listProduct?id="+cid);
    }
}
