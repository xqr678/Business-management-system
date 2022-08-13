package com.iweb.servlet;

import com.iweb.dao.impl.UserDAOImpl;
import com.iweb.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author XQR
 * @date 2022/8/13 2022/8/13
 * @dsecription 类的描述和介绍
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        接受参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean isLogin=new UserDAOImpl().login(user);
        System.out.println(isLogin);
        if (isLogin){
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/listCategory");
            return;
        }else {
            resp.sendRedirect("login.jsp");
        }
    }
}
