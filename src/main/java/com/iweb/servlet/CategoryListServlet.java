package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**默认查询所有分类的数据，并且将数据显示到listCategory.jsp页面上
 * @author XQR
 * @date 2022/8/11 2022/8/11
 * @dsecription 类的描述和介绍
 */
@WebServlet("/listCategory")
public class CategoryListServlet extends HttpServlet {
    private static CategoryDAO dao=new CategoryDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Category> categories=dao.list();
//      将集合存入到请求中
        req.setAttribute("categories",categories);
//      利用转发进行页面的跳转，并通过请求的作用域经数据传递给指定的页面
        req.getRequestDispatcher("page/category/listCategory.jsp").forward(req,resp);


    }
}

