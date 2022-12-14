package com.iweb.servlet;

import com.iweb.dao.ImgDAO;
import com.iweb.dao.ProductDAO;
import com.iweb.dao.impl.ImgDAOImpl;
import com.iweb.dao.impl.ProductDAOImpl;
import com.iweb.pojo.Category;
import com.iweb.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XQR
 * @date 2022/8/12 2022/8/12
 * @dsecription 类的描述和介绍
 */
@WebServlet("/listProduct")
public class ProductListServlet extends HttpServlet {
    private static ProductDAO dao=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int cid=Integer.parseInt(req.getParameter("id"));
        List<Product> products=new ProductDAOImpl().list(cid);
//        根据pid获取对应的图片集合
//        将每一个商品所对应的图片集合和商品本身进行绑定
        ImgDAO imgdao=new ImgDAOImpl();
        for (Product p:products){
            p.setImages(imgdao.select(p.getId()));
        }
        req.setAttribute("products",products);
        req.setAttribute("cid",cid);
        req.getRequestDispatcher("page/product/listProduct.jsp").forward(req,resp);
    }
}
