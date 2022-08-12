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
        System.out.println(id);
        dao.delete(id);

        resp.sendRedirect("/listCategory");

        }
    }

