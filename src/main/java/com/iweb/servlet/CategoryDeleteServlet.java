package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author XQR
 * @date 2022/8/11 2022/8/11
 * @dsecription 类的描述和介绍
 */
@WebServlet(urlPatterns = {"/deleteCategory"})
public class CategoryDeleteServlet extends HttpServlet {
    private static CategoryDAO dao=new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String sid = req.getParameter("id");
        int id=Integer.parseInt(sid);
        dao.delete(id);
//        resp.sendRedirect("/listCategory");
//        如果dao执行正常，成功的运行到这一行，说明对应的分类信息，已经被删除了，ajax的响应函数
//        可以后端响应中写入的字符串判断分类是否是删除

        resp.getWriter().print("success");

        }
    }

